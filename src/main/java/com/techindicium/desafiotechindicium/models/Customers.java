package com.techindicium.desafiotechindicium.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customers implements Serializable {
    String customer_id;
    String company_name;
    String contact_name;
    String contact_title;
    String address;
    String city;
    String region;
    String postal_code;
    String country;
    String phone;
    String fax;

}
