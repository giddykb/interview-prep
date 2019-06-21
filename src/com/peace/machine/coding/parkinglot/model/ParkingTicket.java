package com.peace.machine.coding.parkinglot.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/06/19
 * Time:    2:22 AM
 */
public class ParkingTicket implements Serializable {
  private String id;
  private String registrationNo;


  public  ParkingTicket(String registrationNo) {
    this.id = UUID.randomUUID().toString();
    this.registrationNo = registrationNo;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getRegistrationNo() {
    return registrationNo;
  }

  public void setRegistrationNo(String registrationNo) {
    this.registrationNo = registrationNo;
  }
}
