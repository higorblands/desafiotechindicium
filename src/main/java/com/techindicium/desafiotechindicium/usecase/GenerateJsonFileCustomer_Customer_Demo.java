package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Customer_Customer_Demo;

import java.util.List;

public interface GenerateJsonFileCustomer_Customer_Demo {
    String execute(List<Customer_Customer_Demo> customer_customer_demo, String date);
}
