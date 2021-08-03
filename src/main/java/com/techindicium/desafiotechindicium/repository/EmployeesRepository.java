package com.techindicium.desafiotechindicium.repository;

import com.techindicium.desafiotechindicium.models.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeesRepository extends JpaRepository<Employees, Integer> {
}
