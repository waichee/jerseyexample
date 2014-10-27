package org.wai.service;

import org.springframework.stereotype.Service;
import org.wai.domain.Order;

@Service
public class BatchOrderService implements OrderService {

  public static final String BATCH_ADDRESS= "LA";

  //Stubbing the response as we're not building the persistence for our domains yet....
  //No database are added yet
  public Order getOrder(Long orderId) {
    Order myOrder = createDefaultOrder();
    myOrder.setOrderId(orderId);
    myOrder.setAddress(BATCH_ADDRESS);
    return myOrder;
  }

  public boolean isValid(Order order) {
    OrderValidator validator = (orderInput) ->  orderInput.getOrderId() != null
        && BATCH_ADDRESS.equals(orderInput.getAddress());
    return validator.isValid(order);

  }

}
