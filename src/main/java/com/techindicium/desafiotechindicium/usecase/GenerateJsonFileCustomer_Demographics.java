package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Customer_Demographics;

import java.util.List;

public interface GenerateJsonFileCustomer_Demographics {
    String execute(List<Customer_Demographics> customer_demographicsList, String date);
}
