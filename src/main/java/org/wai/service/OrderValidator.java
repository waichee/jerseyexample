package org.wai.service;

import org.wai.domain.Order;

@FunctionalInterface
public interface OrderValidator {

  Boolean isValid(Order order);

}
