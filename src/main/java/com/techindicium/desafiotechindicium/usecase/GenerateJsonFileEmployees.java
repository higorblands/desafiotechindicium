package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Employees;

import java.util.List;

public interface GenerateJsonFileEmployees {
    String execute(List<Employees> employeesList, String date);
}
