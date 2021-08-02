package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Categories;

import java.util.List;

public interface GenerateJsonFileCategories {
    String execute(List<Categories> categoriesList, String date);
}
