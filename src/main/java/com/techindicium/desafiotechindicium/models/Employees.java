package com.techindicium.desafiotechindicium.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employees implements Serializable {
    @Id
    int employee_id;
    String last_name;
    String first_name;
    String title;
    String title_of_courtesy;
    Date birth_date;
    Date hire_date;
    String address;
    String city;
    String region;
    String postal_code;
    String country;
    String home_phone;
    String extension;
    byte[] photo;
    String notes;
    String reports_to;
    String photo_path;
}
