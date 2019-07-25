package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.repository.ParcelRepositroy;
import java.util.List;

public interface ParcelService {

   Parcel addParcel(Parcel parcel);
   Parcel setParcelStatus(Integer id,Parcel parcel);
   List<Parcel> getAllByStatus(Integer status);

}
