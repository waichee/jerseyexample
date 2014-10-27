package org.wai.service;


import org.wai.domain.Order;

public interface OrderService<T> {

  default Order createDefaultOrder(){
    Order order = new Order();
    order.setName("John Smith");
    return order;
  }

  Order getOrder(Long orderId);

  boolean isValid(Order order);

}
