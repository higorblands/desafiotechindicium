package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomersRepository extends JpaRepository<Customers, String> {
}
