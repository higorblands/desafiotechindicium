package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Employees;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileEmployees;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileEmployeesImpl implements GenerateJsonFileEmployees {
    @SneakyThrows
    @Override
    public String execute(List<Employees> employeesList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();


        employeesList.stream().forEach(employees -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(employees);
            jsonArray.put(jsonString);
        });
        jSONObject.put("employees", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-employees.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
