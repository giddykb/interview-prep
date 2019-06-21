package com.peace.machine.coding.parkinglot.repositories;

import com.peace.machine.coding.parkinglot.model.ParkingTicket;
import com.peace.machine.coding.parkinglot.model.Vehicle;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/06/19
 * Time:    1:25 AM
 */
public interface ParkingRepository {
  ParkingTicket park(Vehicle vehicle);
}
