package com.oocl.packagebooking.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.oocl.packagebooking.Utils.Date2LongSerializer;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Parcel {
    @Id
    @GeneratedValue
    private Integer id;

    private String orderNumer;

    private String customerName;

    private String customerPhone;

    private Integer status;

  @JsonSerialize(using = Date2LongSerializer.class)
    private Date  appointTime;

    private Integer weight;

  public Parcel(Integer id, String orderNumer, String customerName, String customerPhone,
      Integer status, Date appointTime, Integer weight) {
    this.id = id;
    this.orderNumer = orderNumer;
    this.customerName = customerName;
    this.customerPhone = customerPhone;
    this.status = status;
    this.appointTime = appointTime;
    this.weight = weight;
  }

  public Parcel(String orderNumer, String customerName, String customerPhone,
      Integer status, Date appointTime, Integer weight) {
    this.orderNumer = orderNumer;
    this.customerName = customerName;
    this.customerPhone = customerPhone;
    this.status = status;
    this.appointTime = appointTime;
    this.weight = weight;
  }

  public Parcel() {
  }

  public Integer getWeight() {
    return weight;
  }

  public void setWeight(Integer weight) {
    this.weight = weight;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrderNumer() {
    return orderNumer;
  }

  public void setOrderNumer(String orderNumer) {
    this.orderNumer = orderNumer;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public String getCustomerPhone() {
    return customerPhone;
  }

  public void setCustomerPhone(String customerPhone) {
    this.customerPhone = customerPhone;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getAppointTime() {
    return appointTime;
  }

  public void setAppointTime(Date appointTime) {
    this.appointTime = appointTime;
  }
}
