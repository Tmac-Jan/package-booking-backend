package com.oocl.packagebooking.service.impl;

import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.enums.ParcelStatus;
import com.oocl.packagebooking.repository.ParcelRepositroy;
import java.util.Arrays;
import java.util.Date;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
public class ParcelServiceImplTest {

  @Autowired
  private MockMvc mockMvc;

  private ParcelRepositroy parcelRepositroy;


  private ParcelServiceImpl parcelService = new ParcelServiceImpl();


  @Before
  public void setUp() {
    parcelRepositroy = Mockito.mock(ParcelRepositroy.class);
  }

  @Test
  public void should_return_parcel_when_call_addParcel_with_correct_parcel() {
    Parcel parcelActual = new Parcel("0001", "zhangrun", "13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(), new Date(), 3);
    Parcel parcelExpected = new Parcel(1, "0001", "zhangrun", "13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(), new Date(), 3);
    ReflectionTestUtils
        .setField(parcelService, ParcelServiceImpl.class, "parcelRepositroy", parcelRepositroy,
            ParcelRepositroy.class);
    Mockito.when((
        parcelRepositroy.save(Mockito.any(Parcel.class))
    )).thenReturn(parcelExpected);
    Parcel result = parcelService.addParcel(parcelActual);
    Assert.assertEquals(result.getId(), parcelExpected.getId());
  }

  @Test
  public void should_return_parcel_appointed_when_call_setParcelStatus_with_id_null_and_parcel_status_not_null() {
    Parcel parcelActual = new Parcel("0001", "zhangrun", "13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(), new Date(), 3);
    Parcel parcelExpected1 = new Parcel(1, "0001", "zhangrun", "13192266960",
        ParcelStatus.APPOINT.getStatus(), new Date(), 3);
    Parcel parcelExpected2 = new Parcel(1, "0001", "zhangrun", "13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(), new Date(), 3);
    ReflectionTestUtils
        .setField(parcelService, ParcelServiceImpl.class, "parcelRepositroy", parcelRepositroy,
            ParcelRepositroy.class);
    Mockito.when((
        parcelRepositroy.findAllByOrderNumber(Mockito.any(String.class))
    )).thenReturn(Arrays.asList(parcelExpected2));
    Mockito.when((
        parcelRepositroy.save(Mockito.any(Parcel.class))
    )).thenReturn(parcelExpected1);

    Parcel result = parcelService.setParcelStatus(null,parcelActual);
    Assert.assertEquals(result.getStatus(),parcelExpected1.getStatus());
  }
  @Test
  public void should_return_parcel_appointed_when_call_setParcelStatus_with_id_not_null_and_parcel_status_not_null() {
    Parcel parcelActual = new Parcel(1,"0001", "zhangrun", "13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(), new Date(), 3);
    Parcel parcelExpected1 = new Parcel(1, "0001", "zhangrun", "13192266960",
        ParcelStatus.SUCCESS.getStatus(), new Date(), 3);
    ReflectionTestUtils
        .setField(parcelService, ParcelServiceImpl.class, "parcelRepositroy", parcelRepositroy,
            ParcelRepositroy.class);
    Mockito.when((
        parcelRepositroy.save(parcelActual)
    )).thenReturn(parcelExpected1);
    Assert.assertEquals(ParcelStatus.SUCCESS.getStatus(),parcelExpected1.getStatus());
  }
}