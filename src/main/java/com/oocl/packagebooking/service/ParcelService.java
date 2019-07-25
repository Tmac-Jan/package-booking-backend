package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Parcel;
import java.util.List;

public interface ParcelService {

   Parcel addParcel(Parcel parcel);
   Parcel setParcelStatus(Integer id,Integer status);
   Parcel appointParcel(Integer parcelId);
   Parcel pickParcel(Integer parcelId);
   List<Parcel> getAllByStatus(Integer status);

}
