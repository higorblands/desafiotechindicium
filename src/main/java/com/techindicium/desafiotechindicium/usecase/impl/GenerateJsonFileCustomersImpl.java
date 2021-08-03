package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Customer_Demographics;
import com.techindicium.desafiotechindicium.models.Customers;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCustomers;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileCustomersImpl implements GenerateJsonFileCustomers {
    @SneakyThrows
    @Override
    public String execute(List<Customers> customersList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();


        customersList.stream().forEach(customers -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(customersList);
            jsonArray.put(jsonString);
        });
        jSONObject.put("customers", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-customers.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
