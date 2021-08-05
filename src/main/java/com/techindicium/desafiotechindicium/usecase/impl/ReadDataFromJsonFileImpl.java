package com.techindicium.desafiotechindicium.usecase.impl;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.techindicium.desafiotechindicium.models.OrdersMongo;
import com.techindicium.desafiotechindicium.repository.OrdersMongoRepository;
import com.techindicium.desafiotechindicium.usecase.ReadDataFromJsonFile;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.io.IOException;

public class ReadDataFromJsonFileImpl implements ReadDataFromJsonFile {


    @Override
    public String execute(String json) {
        System.out.println("Salvo");
        return null;
    }
}
