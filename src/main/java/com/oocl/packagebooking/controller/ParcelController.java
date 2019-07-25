package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.service.ParcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ParcelController {

  @Autowired
  private ParcelService parcelService;

  @PostMapping(value = "/parcels")
  public ResponseEntity createParcel(@RequestBody Parcel parcel) {
    if (parcel.getId() == null) {
      Parcel parcelGet = parcelService.addParcel(parcel);
      if (parcelGet != null) {
        return ResponseEntity.ok(parcelGet);
      } else {
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
      }
    } else {
      return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }
  }
}
