package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Suppliers;

import java.util.List;

public interface GenerateJsonFileSuppliers {
    String execute(List<Suppliers> suppliersList, String date);
}
