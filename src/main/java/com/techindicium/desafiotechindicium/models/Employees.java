package com.techindicium.desafiotechindicium.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employees implements Serializable {
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
    int reports_to;
    String photo_path;

}
