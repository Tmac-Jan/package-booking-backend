package com.oocl.packagebooking.controller;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.service.ParcelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(origins = "*")
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

  @GetMapping(value = "/parcels")
  public ResponseEntity<List<Parcel>> getAllParcelsByStatus(@RequestParam(required = false) Integer status) {
    return ResponseEntity.ok(parcelService.getAllByStatus(status));
  }

  @PutMapping(value = "/parcels/{id}")
  public ResponseEntity modifyParcelStatus(@PathVariable Integer id,
      @RequestBody Parcel parcel) {
    if (id != null) {
      Parcel parcelGet = parcelService.setParcelStatus(id, parcel.getStatus());
      if (parcelGet != null) {
        return ResponseEntity.ok(parcelGet);
      } else {
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
      }
    } else {
      return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }
  }
  @PutMapping(value = "/parcels/{id}")
  public ResponseEntity modifyParcelStatusByCustomer(@PathVariable Integer id,
      @RequestBody Parcel parcel) {
    if (id != null) {
      Parcel parcelGet = parcelService.setParcelStatus(id, parcel.getStatus());
      if (parcelGet != null) {
        return ResponseEntity.ok(parcelGet);
      } else {
        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
      }
    } else {
      return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }
  }
//  @PutMapping(value = "/parcels/{id}")
//  public ResponseEntity appointParcel(@PathVariable Integer id,
//      @RequestBody Parcel parcel) {
//    if (id != null) {
//      Parcel parcelGet = parcelService.setParcelStatus(id,parcel.getStatus());
//      if (parcelGet != null) {
//        return ResponseEntity.ok(parcelGet);
//      } else {
//        return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
//      }
//    } else {
//      return (ResponseEntity) ResponseEntity.status(HttpStatus.BAD_REQUEST);
//    }
//  }
}
