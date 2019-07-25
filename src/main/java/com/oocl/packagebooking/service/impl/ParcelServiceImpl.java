package com.oocl.packagebooking.service.impl;

import com.oocl.packagebooking.Utils.EnumUtils;
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
    return  parcelRepositroy.save(parcel);
  }

  @Override
  public Parcel setParcelStatus(Integer id, Integer status) {
    Optional<Parcel> parcel  = parcelRepositroy.findById(id);
    if (parcel!=null){
      parcel.get().setStatus(status);
      return parcelRepositroy.save(parcel.get());
    }else
    return null;
  }

  @Override
  public Parcel appointParcel(Integer parcelId) {
    Optional<Parcel> parcel = parcelRepositroy.findById(parcelId);
    if (parcel.get()!=null){
      parcel.get().setStatus(ParcelStatus.APPOINT.getStatus());
      return  parcelRepositroy.save(parcel.get());
    }else
      return null;
  }

  @Override
  public Parcel pickParcel(Integer parcelId) {
    Optional<Parcel> parcel = parcelRepositroy.findById(parcelId);
    if (parcel.get()!=null){
      parcel.get().setStatus(ParcelStatus.SUCCESS.getStatus());
      return  parcelRepositroy.save(parcel.get());
    }else
    return null;
  }

  @Override
  public List<Parcel> getAllByStatus(Integer status) {
    if (status==null)
      return parcelRepositroy.findAll();
    else return null;
  }
}
