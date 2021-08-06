package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Region;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileRegion;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileRegionImpl implements GenerateJsonFileRegion {
    @SneakyThrows
    @Override
    public String execute(List<Region> regionList, String date) {
        JSONArray jsonArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();

        regionList.stream().forEach(region -> {
            Gson gson = new Gson();
            String jsonString = gson.toJson(region);
            jsonArray.put(jsonString);
        });
        jSONObject.put("region", jsonArray);

        String jsonFormattedString = jSONObject.toString().replace("\\\"", "\"");
        String finalJSON = jsonFormattedString.replace("\"{", "{").replace("}\"", "}");
        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-region.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
