package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Employee_Territories;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileEmployee_Territories;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileEmployee_TerritoriesImpl implements GenerateJsonFileEmployee_Territories {
    @SneakyThrows
    @Override
    public String execute(List<Employee_Territories> employee_territoriesList, String date) {
        String finalJSON = new Gson().toJson(employee_territoriesList);


        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-employee_territories.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
