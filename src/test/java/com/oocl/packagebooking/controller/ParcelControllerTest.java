package com.oocl.packagebooking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oocl.packagebooking.entity.Parcel;
import com.oocl.packagebooking.enums.ParcelStatus;
import com.oocl.packagebooking.service.ParcelService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        parcelService.setParcelStatus(
            (Integer) Mockito.any(), (Integer) Mockito.any()
        )).thenReturn(parcelExpected);
    mockMvc.perform(put("/parcels/{id}",1)
//        .contentType(MediaType.APPLICATION_JSON_UTF8)
//        .content(MAPPER.writeValueAsString(parcel)
        )
        .andExpect(status().isOk());
  }
  @Test
  public void shoule_return_parcel_list_when_call_get_all_parcell_API_wihtout_status() throws Exception {
    ObjectMapper MAPPER = new ObjectMapper();
    Parcel parcelActual = new Parcel(0,"0001","zhangrun","13192266960",
        ParcelStatus.NOTAPPOINT.getStatus(),new Date(),3);
    Parcel parcelExpected = new Parcel(1,"0001","zhangrun","13192266960",
        ParcelStatus.APPOINT.getStatus(),new Date(),3);
    List<Parcel> parcelList = new ArrayList<>();
    parcelList.add(parcelActual);
    parcelList.add(parcelExpected);
    Mockito.when(
        parcelService.getAllByStatus(
          (Integer) Mockito.any()
        )).thenReturn(parcelList);
    mockMvc.perform(get("/parcels")
//        .contentType(MediaType.APPLICATION_JSON_UTF8)
//        .content(MAPPER.writeValueAsString(parcel)
    )
        .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].id").value("0"));
  }
}
