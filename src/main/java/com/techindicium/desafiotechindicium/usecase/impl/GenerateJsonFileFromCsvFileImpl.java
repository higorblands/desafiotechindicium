package com.techindicium.desafiotechindicium.usecase.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.techindicium.desafiotechindicium.usecase.GenerateJsonFileFromCsvFile;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;
import java.util.Map;

public class GenerateJsonFileFromCsvFileImpl implements GenerateJsonFileFromCsvFile {
    @SneakyThrows
    @Override
    public String execute(String localDate) {
        CsvMapper csvMapper = new CsvMapper();
        ObjectMapper mapper = new ObjectMapper();

        File input = new File("data\\order_details.csv");
        File output = new File("data\\csv-" + localDate + "-order_details.json");

        CsvSchema csvSchema = CsvSchema.builder().setUseHeader(true).build();
        List<Object> readAll = csvMapper.readerFor(Map.class).with(csvSchema).readValues(input).readAll();
        mapper.writerWithDefaultPrettyPrinter().writeValue(output, readAll);
        return null;
    }
}
