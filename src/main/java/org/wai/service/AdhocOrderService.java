package org.wai.service;

import org.springframework.stereotype.Service;
import org.wai.domain.Order;

@Service
public class AdhocOrderService implements OrderService {

  public static final String ADHOC_ADDRESS= "Tiny village";

  //Stubbing the response as we're not building the persistence for our domains yet....
  //No database are added yet
  public Order getOrder(Long orderId) {
    Order myOrder = createDefaultOrder();
    myOrder.setAddress(ADHOC_ADDRESS);
    myOrder.setOrderId(orderId);
    return myOrder;
  }

  public boolean isValid(Order order) {
    OrderValidator validator = (orderInput) ->  orderInput.getOrderId() != null;
    return validator.isValid(order);

  }


}
