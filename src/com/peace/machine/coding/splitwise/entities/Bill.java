package com.peace.machine.coding.splitwise.entities;

import com.peace.machine.coding.splitwise.enums.ShareType;
import com.peace.machine.coding.splitwise.models.Contribution;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:13 PM
 */

@Getter
@Setter
public class Bill {

  private Integer id;
  private String title;
  private String description;
  private ShareType shareType;
  private Integer amount;
  private List<Contribution> paidUsers;
  private List<Contribution> payableUsers;
  private User createdBy;
  private Integer groupId;

  public Bill() {

  }

}
