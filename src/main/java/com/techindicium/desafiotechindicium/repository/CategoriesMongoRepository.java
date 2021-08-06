package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.CategoriesMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriesMongoRepository extends MongoRepository<CategoriesMongo, String> {
}
