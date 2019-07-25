package com.oocl.packagebooking.repository;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.enums.ParcelStatus;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@DataJpaTest
@RunWith(SpringRunner.class)
public class ParelRepositroyTest {

  @Autowired
  private TestEntityManager entityManager;
  @Autowired
  private ParcelRepositroy parelRepositroy;
  @Before public void setUp(){
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
    entityManager.persist(parcels.get(2));
  }
  @Test
  public void should_return_parcel_list_when_call_findAllByStatusOfAppoint(){
    List<Parcel> parcelsActual = parelRepositroy.findAllByStatus(ParcelStatus.APPOINT.getStatus());
    Assert.assertEquals(1,parcelsActual.size());
  }

  @Test
  public  void should_return_parcel_list_when_call_findByOrderNumber_API(){
    List<Parcel> parcels = parelRepositroy.findAllByOrderNumber("0003");
    Parcel result = parcels.get(0);
    Assert.assertEquals("0003",result.getOrderNumber());
  }
}