package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Categories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileCategories;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileCategoriesImpl implements GenerateJsonFileCategories {
    @SneakyThrows
    @Override
    public String execute(List<Categories> categoriesList, String date) {
        String finalJSON = new Gson().toJson(categoriesList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-categories.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
