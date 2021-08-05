package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Suppliers;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileSuppliers;
import lombok.SneakyThrows;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileSuppliersImpl implements GenerateJsonFileSuppliers {
    @SneakyThrows
    @Override
    public String execute(List<Suppliers> suppliersList, String date) {
        JSONArray jsonArray = new JSONArray();

        suppliersList.stream().forEach(suppliers -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(suppliers);
            jsonArray.put(jsonString);
        });
        String finalJSON = new Gson().toJson(suppliersList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-suppliers.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
