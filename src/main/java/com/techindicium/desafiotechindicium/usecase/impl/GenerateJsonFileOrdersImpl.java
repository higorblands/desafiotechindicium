package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Orders;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileOrders;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileOrdersImpl implements GenerateJsonFileOrders {
    @SneakyThrows
    @Override
    public String execute(List<Orders> ordersList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();


        ordersList.stream().forEach(orders -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(orders);
            jsonArray.put(jsonString);
        });
        jSONObject.put("orders", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-orders.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
