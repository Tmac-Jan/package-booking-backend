package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Parcel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepositroy extends JpaRepository<Parcel,Integer> {

 List<Parcel> findAllByStatus(Integer status);

}
