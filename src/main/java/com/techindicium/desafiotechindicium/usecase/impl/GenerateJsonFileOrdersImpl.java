package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Orders;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileOrders;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileOrdersImpl implements GenerateJsonFileOrders {
    @SneakyThrows
    @Override
    public String execute(List<Orders> ordersList, String date) {
        String finalJSON = new Gson().toJson(ordersList);


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-orders.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
