package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories, Integer> {
}
