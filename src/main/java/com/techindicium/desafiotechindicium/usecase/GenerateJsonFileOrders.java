package com.techindicium.desafiotechindicium.usecase;

import com.techindicium.desafiotechindicium.models.Orders;

import java.util.List;

public interface GenerateJsonFileOrders {
    String execute(List<Orders> ordersList, String date);
}
