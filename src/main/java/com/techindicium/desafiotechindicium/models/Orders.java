package com.techindicium.desafiotechindicium.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders implements Serializable {
    @Id
    int order_id;
    String customer_id;
    int employee_id;
    Date order_date;
    Date required_date;
    Date shipped_date;
    int ship_via;
    float freight;
    String ship_name;
    String ship_address;
    String ship_city;
    String ship_region;
    String ship_postal_code;
    String ship_country;
}
