package org.wai.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Order {

  private Long orderId;

  private String name;

  private String address;

  //Some property thats not required to be returned to the client
  @JsonIgnore
  private String description;


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
