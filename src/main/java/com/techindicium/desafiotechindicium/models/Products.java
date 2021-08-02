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
public class Products implements Serializable {
    int product_id;
    String product_name;
    int supplier_id;
    int category_id;
    String quantity_per_unit;
    float unit_price;
    int units_in_stock;
    int units_on_order;
    int reorder_level;
    int discontinued;
}
