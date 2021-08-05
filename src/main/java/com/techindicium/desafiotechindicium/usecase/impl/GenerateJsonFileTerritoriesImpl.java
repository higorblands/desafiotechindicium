package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Territories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileTerritories;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileTerritoriesImpl implements GenerateJsonFileTerritories {
    @SneakyThrows
    @Override
    public String execute(List<Territories> territoriesList, String date) {
        String finalJSON = new Gson().toJson(territoriesList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-territories.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
