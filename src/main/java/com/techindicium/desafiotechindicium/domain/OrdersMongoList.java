package com.techindicium.desafiotechindicium.domain;

import com.techindicium.desafiotechindicium.models.OrdersMongo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersMongoList {
    List<OrdersMongo> orders;
}
