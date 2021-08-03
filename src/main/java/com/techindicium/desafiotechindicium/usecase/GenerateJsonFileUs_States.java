package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Territories;
import com.techindicium.desafiotechindicium.models.Us_States;

import java.util.List;

public interface GenerateJsonFileUs_States {
    String execute(List<Us_States> us_statesList, String date);
}
