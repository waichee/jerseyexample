package org.wai.jerseyexample.service

import spock.lang.Specification

class BatchOrderServiceSpec extends Specification {

  OrderService orderService;

  def setup() {
    orderService = new BatchOrderService();
  }


  def "should return order by id"() {
    given:
    Long orderId = 1L

    when:
    def result = orderService.getOrder(orderId)

    then:
    result.orderId == orderId
    result.address == BatchOrderService.BATCH_ADDRESS
    result.name == BatchOrderService.BATCH_NAME

  }

  def "should validate order when the details required is valid"() {
    given:
    Long orderId = 1L
    def order = orderService.getOrder(orderId)

    and:
    order.setAddress(addressInput)

    when:
    def result = orderService.isValid(order)

    then:
    result == expectedResult

    where:
    addressInput                      | expectedResult
    BatchOrderService.BATCH_ADDRESS   | true
    null                              | false
    "bla"                             | false
    "Tiny village"                    | false
  }

  def "should modify order description"() {
    when:
    def order = orderService.getOrder(1L)
    def originalDescription = order.description
    def result = orderService.modifyOrder(order)

    then:
    result.orderId == order.orderId
    result.name == order.name
    result.address == order.address
    result.description == "Default batch size is:100"
    !originalDescription

  }



  def "should illegal argument exception when trying to modify null order"() {
    when:
    orderService.modifyOrder(null)

    then:
    IllegalArgumentException e = thrown()

  }


}