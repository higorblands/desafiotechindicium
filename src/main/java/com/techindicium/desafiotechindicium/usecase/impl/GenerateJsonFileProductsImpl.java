package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Products;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileProducts;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileProductsImpl implements GenerateJsonFileProducts {
    @SneakyThrows
    @Override
    public String execute(List<Products> productsList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();

        productsList.stream().forEach(products -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(products);
            jsonArray.put(jsonString);
        });
        jSONObject.put("products", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");
        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-products.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
