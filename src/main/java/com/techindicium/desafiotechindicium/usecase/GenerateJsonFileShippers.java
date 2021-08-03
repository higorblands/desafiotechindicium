package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Shippers;

import java.util.List;

public interface GenerateJsonFileShippers {
    String execute(List<Shippers> shippersList, String date);
}
