package org.wai.jerseyexample.service;


import org.wai.jerseyexample.domain.Order;

import java.util.List;

public interface OrderService<T> {

  String DEFAULT_NAME = "John Smith";


  default Order createDefaultOrder(){
    Order order = new Order();
    order.setName(DEFAULT_NAME);
    return order;
  }

  Order getOrder(Long orderId);

  Order modifyOrder(Order order);

  List<Order> findAllOrders();

  boolean isValid(Order order);

}
