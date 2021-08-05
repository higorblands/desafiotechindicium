package com.techindicium.desafiotechindicium.adapter;

import com.techindicium.desafiotechindicium.models.Orders;
import com.techindicium.desafiotechindicium.models.OrdersMongo;

public class OrdersAdapter {
    public static OrdersMongo convert(Orders orders){
    return OrdersMongo
            .builder()
            .order_id(orders.getOrder_id())
            .customer_id(orders.getCustomer_id())
            .employee_id(orders.getEmployee_id())
            .order_date(orders.getOrder_date())
            .required_date(orders.getRequired_date())
            .shipped_date(orders.getShipped_date())
            .ship_via(orders.getShip_via())
            .freight(orders.getFreight())
            .ship_name(orders.getShip_name())
            .ship_address(orders.getShip_address())
            .ship_city(orders.getShip_city())
            .ship_region(orders.getShip_region())
            .ship_postal_code(orders.getShip_postal_code())
            .ship_country(orders.getShip_country())
            .build();
    }
}
