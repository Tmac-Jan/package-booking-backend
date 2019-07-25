package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.enums.ParcelStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class ParelRepositroyTest {
  @Autowired
  private MockMvc mockMvc;


  @Autowired
  private ParcelRepositroy parelRepositroy;
  @Before void setUp(){
    List<Parcel> parcels = new ArrayList<Parcel>(){
      {
        add(new Parcel("0001","zhangrun","13192266960",
            ParcelStatus.NOTAPPOINT.getStatus(),new Date(),3));
        add(new Parcel("0002","haha","13192236960",
            ParcelStatus.SUCCESS.getStatus(),new Date(),3));
        add(new Parcel("0003","barry","13192266960",
            ParcelStatus.APPOINT.getStatus(),new Date(),3));
      }
    };

  }
//  @Test
//  public void shoule_return_parcel_list_when_call_findAllByStatusOfAppoint(){
//    List<Parcel> parcelsActual = parelRepositroy.findAllbyStatus()
//
//  }
}