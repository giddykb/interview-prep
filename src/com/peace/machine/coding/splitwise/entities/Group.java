package com.peace.machine.coding.splitwise.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:12 PM
 */
@Setter
@Getter
public class Group {
  private  Integer id;
  private Integer name;
  private List<User> users = new ArrayList<>();
}
