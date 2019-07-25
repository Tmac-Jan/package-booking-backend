package com.oocl.packagebooking.enums;


public enum ParcelStatus implements StatusEnum {
  NOTAPPOINT(0, "未预约"),
  APPOINT(1, "已预约"),
  SUCCESS(2, "已取件"),
  ;


  private Integer status;

  private String message;

  ParcelStatus(Integer status, String message) {
    this.status = status;
    this.message = message;
  }

  @Override
  public Integer getStatus() {
    return this.status;
  }
}
