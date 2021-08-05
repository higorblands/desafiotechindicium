package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Territories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileTerritories;
import lombok.SneakyThrows;
import org.json.JSONArray;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileTerritoriesImpl implements GenerateJsonFileTerritories {
    @SneakyThrows
    @Override
    public String execute(List<Territories> territoriesList, String date) {
        JSONArray jsonArray = new JSONArray();

        territoriesList.stream().forEach(territories -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(territories);
            jsonArray.put(jsonString);
        });
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
