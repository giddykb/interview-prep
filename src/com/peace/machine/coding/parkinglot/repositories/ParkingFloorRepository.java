package com.peace.machine.coding.parkinglot.repositories;

import com.peace.machine.coding.parkinglot.model.ParkingTicket;
import com.peace.machine.coding.parkinglot.model.Vehicle;
import com.peace.machine.coding.parkinglot.strategy.NearestStrategy;
import com.peace.machine.coding.parkinglot.strategy.ParkingStrategy;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    06/06/19
 * Time:    1:26 AM
 */
public class ParkingFloorRepository  implements ParkingRepository {

  private Integer floor;
  private Integer capacity;
  private ParkingStrategy strategy;
  private Integer availableSlots;
  private Map<Integer, Vehicle> slotVehicleMap;
  private Map<String, Integer> activeTickets;
  private static ParkingFloorRepository INSTANCE = null;

  private ParkingFloorRepository(){}

  private ParkingFloorRepository(Integer floor, Integer capacity) {
    this.floor = floor;
    this.capacity = capacity;
    availableSlots = capacity;
    this.strategy = new NearestStrategy();
    slotVehicleMap = new ConcurrentHashMap<>(capacity);

    for (int slot = 1; slot <=capacity ; slot++) {
      strategy.add(slot);
    }
  }

  private ParkingFloorRepository(Integer floor, Integer capacity, ParkingStrategy strategy) {
    this(floor,capacity);
    this.strategy = strategy;
  }


  public ParkingFloorRepository getInstance(Integer floor, Integer capacity) {
/*
    INSTANCE =  ParkingFloorSingletonHelper.INSTANCE;
    INSTANCE.setFloor(floor);
    INSTANCE.setCapacity(capacity);
*/
    if (INSTANCE == null) {
      synchronized (ParkingFloorRepository.class) {
        if (INSTANCE == null) {
          INSTANCE = new ParkingFloorRepository(floor,capacity);
        }
      }
    }
    return INSTANCE;
  }

  public ParkingTicket park(Vehicle vehicle) {
    ParkingTicket ticket = null;
    if (availableSlots == 0) {
      //throw exception here
    } else {
      ticket = issueTicket(vehicle);
    }
    return ticket;
  }

  private ParkingTicket issueTicket(Vehicle vehicle) {
    int currentNearestSlot = strategy.getSlot();
    slotVehicleMap.put(currentNearestSlot, vehicle);
    ParkingTicket ticket = new ParkingTicket(vehicle.getRegistrationNo());
    activeTickets.put(ticket.getId(),currentNearestSlot);
    availableSlots--;
    return ticket;
  }

  public void leave(ParkingTicket ticket) {
    if (activeTickets.containsKey(ticket.getId())) {
      Integer parkedSlot = activeTickets.get(ticket.getId());
      slotVehicleMap.remove(parkedSlot);
      activeTickets.remove(ticket.getId());
      strategy.add(parkedSlot);
      availableSlots++;
    }
  }

  private static class ParkingFloorSingletonHelper {
    static ParkingFloorRepository INSTANCE = new ParkingFloorRepository();
  }

  public Integer getFloor() {
    return floor;
  }

  public void setFloor(Integer floor) {
    this.floor = floor;
  }

  public Integer getCapacity() {
    return capacity;
  }

  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }

  public ParkingStrategy getStrategy() {
    return strategy;
  }

  public void setStrategy(ParkingStrategy strategy) {
    this.strategy = strategy;
  }

  public Integer getAvailableSlots() {
    return availableSlots;
  }

  public void setAvailableSlots(Integer availableSlots) {
    this.availableSlots = availableSlots;
  }

}
