package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Region;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileRegion;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileRegionImpl implements GenerateJsonFileRegion {
    @SneakyThrows
    @Override
    public String execute(List<Region> regionList, String date) {
        String finalJSON = new Gson().toJson(regionList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-region.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
