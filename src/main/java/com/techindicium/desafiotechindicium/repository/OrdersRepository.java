package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
