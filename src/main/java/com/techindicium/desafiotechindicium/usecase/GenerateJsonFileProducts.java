package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Products;

import java.util.List;

public interface GenerateJsonFileProducts {
    String execute(List<Products> productsList, String date);
}
