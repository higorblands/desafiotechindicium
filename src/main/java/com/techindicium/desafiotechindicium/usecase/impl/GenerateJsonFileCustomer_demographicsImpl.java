package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Customer_Demographics;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCustomer_Demographics;
import lombok.SneakyThrows;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileCustomer_demographicsImpl implements GenerateJsonFileCustomer_Demographics {
    @SneakyThrows
    @Override
    public String execute(List<Customer_Demographics> customer_demographicsList, String date) {
        JSONArray jsonArray = new JSONArray();

        customer_demographicsList.stream().forEach(customer_demographics -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(customer_demographics);
            jsonArray.put(jsonString);
        });
        String finalJSON = new Gson().toJson(customer_demographicsList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-customer_demographics.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
