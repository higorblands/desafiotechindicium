package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Customers;

import java.util.List;

public interface GenerateJsonFileCustomers {
    String execute(List<Customers> customersList, String date);
}
