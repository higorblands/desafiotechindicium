package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
}
