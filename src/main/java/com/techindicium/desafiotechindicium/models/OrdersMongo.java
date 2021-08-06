package com.techindicium.desafiotechindicium.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(collection = "orders")
public class OrdersMongo {
    @Id
    String id;
    int order_id;
    String customer_id;
    int employee_id;
    String order_date;
    String required_date;
    String shipped_date;
    int ship_via;
    String freight;
    String ship_name;
    String ship_address;
    String ship_city;
    String ship_region;
    String ship_postal_code;
    String ship_country;
}
