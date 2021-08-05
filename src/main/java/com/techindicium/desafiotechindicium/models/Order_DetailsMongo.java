package com.techindicium.desafiotechindicium.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order_details")
public class Order_DetailsMongo  extends org.bson.Document{
    @Id
    int _id;
    int order_id;
    int product_id;
    int unit_price;
    int quantity;
    int discount;
}
