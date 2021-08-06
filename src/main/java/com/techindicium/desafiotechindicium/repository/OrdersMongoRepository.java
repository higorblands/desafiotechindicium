package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.OrdersMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrdersMongoRepository extends MongoRepository<OrdersMongo , String> {
}
