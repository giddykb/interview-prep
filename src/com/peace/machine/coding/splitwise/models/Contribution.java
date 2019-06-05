package com.peace.machine.coding.splitwise.models;

import com.peace.machine.coding.splitwise.entities.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    13/05/19
 * Time:    8:19 PM
 */

@Getter
@Setter
public class Contribution {

  private Integer userId;
  private float share;

  public Contribution(User user, float share) {
    this.userId = user.getId();
    this.share = share;
  }
}
