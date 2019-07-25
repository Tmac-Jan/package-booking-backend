package com.oocl.packagebooking.service.impl;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.enums.ParcelStatus;
import com.oocl.packagebooking.repository.ParcelRepositroy;
import com.oocl.packagebooking.service.ParcelService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParcelServiceImpl implements ParcelService {

  @Autowired
  private ParcelRepositroy parcelRepositroy;

  @Override
  public Parcel addParcel(Parcel parcel) {
    parcel.setStatus(ParcelStatus.NOTAPPOINT.getStatus());
    return parcelRepositroy.save(parcel);
  }

  @Override
  public Parcel setParcelStatus(Integer id, Parcel parcel) {
    if (id != null) {
      Optional<Parcel> parcelResult = parcelRepositroy.findById(id);
      if (parcel != null) {
        parcelResult.get().setStatus(parcel.getStatus());
        return parcelRepositroy.save(parcelResult.get());
      } else {
        return null;
      }
    } else {
      List<Parcel> parcels = parcelRepositroy.findAllByOrderNumber(parcel.getOrderNumber());
      if (parcels.size()>0){
        parcels.get(0).setStatus(ParcelStatus.APPOINT.getStatus());
        return  parcelRepositroy.save(parcels.get(0));
      }else
      return null;
    }
  }

  @Override
  public List<Parcel> getAllByStatus(Integer status) {
    if (status == null) {
      return parcelRepositroy.findAll();
    } else {
      return parcelRepositroy.findAllByStatus(status);
    }
  }
}
