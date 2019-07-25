package com.oocl.packagebooking.service;

import com.oocl.packagebooking.entity.Parcel;

public interface ParcelService {

   Parcel addParcel(Parcel parcel);
   Parcel appointParcel(Integer parcelId);
   Parcel pickParcel(Integer parcelId);


}
