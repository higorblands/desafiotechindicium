package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Us_States;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileUs_States;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileUs_StatesImpl implements GenerateJsonFileUs_States {
    @SneakyThrows
    @Override
    public String execute(List<Us_States> us_statesList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();

        us_statesList.forEach(us_states -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(us_states);
            jsonArray.put(jsonString);
        });
        jSONObject.put("us_states", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");
        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-us_states.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
