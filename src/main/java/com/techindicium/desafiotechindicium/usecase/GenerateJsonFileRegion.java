package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Region;

import java.util.List;

public interface GenerateJsonFileRegion {
    String execute(List<Region> regionList, String date);
}
