package com.oocl.packagebooking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.enums.ParcelStatus;
import com.oocl.packagebooking.service.ParcelService;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public  class ParcelControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private ParcelService parcelService;

  @Test
  public void shoule_return_parcel_when_call_add_parcell_API() throws Exception {
    ObjectMapper MAPPER = new ObjectMapper();
    Parcel parcel = new Parcel("0001","zhangrun","13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(),new Date(),3);
    Mockito.when(
        parcelService.addParcel(
            (Parcel)Mockito.any()
        )).thenReturn(parcel);
    mockMvc.perform(post("/parcels")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(MAPPER.writeValueAsString(parcel)
        ))
        .andExpect(status().isOk());
  }
  @Test
  public void shoule_return_parcel_when_call_appoint_parcell_API() throws Exception {
    ObjectMapper MAPPER = new ObjectMapper();
    Parcel parcel = new Parcel("0001","zhangrun","13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(),new Date(),3);
    Parcel parcelExpected = new Parcel("0001","zhangrun","13192266960",
        ParcelStatus.APPOINT.getStatus(),new Date(),3);
    Mockito.when(
        parcelService.appointParcel(
            (Integer) Mockito.any()
        )).thenReturn(parcelExpected);
    mockMvc.perform(put("/parcels/{id}",1)
//        .contentType(MediaType.APPLICATION_JSON_UTF8)
//        .content(MAPPER.writeValueAsString(parcel)
        )
        .andExpect(status().isOk());
  }
}