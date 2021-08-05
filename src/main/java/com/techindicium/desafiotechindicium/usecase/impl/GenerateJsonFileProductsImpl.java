package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Products;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileProducts;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileProductsImpl implements GenerateJsonFileProducts {
    @SneakyThrows
    @Override
    public String execute(List<Products> productsList, String date) {
        String finalJSON = new Gson().toJson(productsList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-products.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
