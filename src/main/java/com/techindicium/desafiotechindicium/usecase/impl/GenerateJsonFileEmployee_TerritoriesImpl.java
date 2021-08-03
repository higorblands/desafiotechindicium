package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Customers;
import com.techindicium.desafiotechindicium.models.Employee_Territories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileEmployee_Territories;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileEmployee_TerritoriesImpl implements GenerateJsonFileEmployee_Territories {
    @SneakyThrows
    @Override
    public String execute(List<Employee_Territories> employee_territoriesList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();


        employee_territoriesList.stream().forEach(employee_territories -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(employee_territories);
            jsonArray.put(jsonString);
        });
        jSONObject.put("employee_territories", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-employee_territories.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
