package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Shippers;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileShippers;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileShippersImpl implements GenerateJsonFileShippers {
    @SneakyThrows
    @Override
    public String execute(List<Shippers> shippersList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();


        shippersList.stream().forEach(shippers -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(shippers);
            jsonArray.put(jsonString);
        });
        jSONObject.put("shippers", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-shippers.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
