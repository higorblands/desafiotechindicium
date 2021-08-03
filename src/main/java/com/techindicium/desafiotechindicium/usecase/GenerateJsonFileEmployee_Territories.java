package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Employee_Territories;

import java.util.List;

public interface GenerateJsonFileEmployee_Territories {
    String execute(List<Employee_Territories> employee_territoriesList, String date);
}
