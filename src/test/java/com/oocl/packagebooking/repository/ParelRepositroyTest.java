package com.oocl.packagebooking.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
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
  private ParelRepositroy parelRepositroy;
  @Before void setUp(){


  }
  public void shoule_return_parcel_list_when_call_findAllByStatus(){

  }
}