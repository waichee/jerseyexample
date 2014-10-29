package org.wai.jerseyexample.service;

import org.wai.jerseyexample.domain.Order;

@FunctionalInterface
public interface OrderValidator {

  Boolean isValid(Order order);

}
