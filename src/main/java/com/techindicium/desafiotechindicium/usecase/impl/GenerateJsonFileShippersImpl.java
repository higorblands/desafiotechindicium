package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Shippers;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileShippers;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileShippersImpl implements GenerateJsonFileShippers {
    @SneakyThrows
    @Override
    public String execute(List<Shippers> shippersList, String date) {
        String finalJSON = new Gson().toJson(shippersList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-shippers.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
