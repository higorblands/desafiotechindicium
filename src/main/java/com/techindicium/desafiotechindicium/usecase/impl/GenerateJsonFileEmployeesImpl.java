package com.techindicium.desafiotechindicium.usecase.impl;

import com.google.gson.Gson;
import com.techindicium.desafiotechindicium.models.Employees;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileEmployees;
import lombok.SneakyThrows;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GenerateJsonFileEmployeesImpl implements GenerateJsonFileEmployees {
    @SneakyThrows
    @Override
    public String execute(List<Employees> employeesList, String date) {
        String finalJSON = new Gson().toJson(employeesList);

        try (FileWriter file = new FileWriter("data\\postgres-" + date + "-employees.json")) {
            file.write(finalJSON);
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
