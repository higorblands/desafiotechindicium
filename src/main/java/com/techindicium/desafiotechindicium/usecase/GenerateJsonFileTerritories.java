package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Territories;

import java.util.List;

public interface GenerateJsonFileTerritories {
    String execute(List<Territories> territoriesList, String date);
}
