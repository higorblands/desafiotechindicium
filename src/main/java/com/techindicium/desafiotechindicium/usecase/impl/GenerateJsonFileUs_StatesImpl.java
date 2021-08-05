package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Us_States;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileUs_States;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileUs_StatesImpl implements GenerateJsonFileUs_States {
    @SneakyThrows
    @Override
    public String execute(List<Us_States> us_statesList, String date) {
        String finalJSON = new Gson().toJson(us_statesList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-us_states.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
