package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Customers;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCustomers;
import lombok.SneakyThrows;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileCustomersImpl implements GenerateJsonFileCustomers {
    @SneakyThrows
    @Override
    public String execute(List<Customers> customersList, String date) {
        JSONArray jsonArray = new JSONArray();

        customersList.stream().forEach(customers -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(customersList);
            jsonArray.put(jsonString);
        });
        String finalJSON = new Gson().toJson(customersList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-customers.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
