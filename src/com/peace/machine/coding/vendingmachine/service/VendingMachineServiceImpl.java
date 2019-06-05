package com.peace.machine.coding.vendingmachine.service;

import com.peace.machine.coding.vendingmachine.Inventory;
import com.peace.machine.coding.vendingmachine.enums.Coin;
import com.peace.machine.coding.vendingmachine.enums.Item;
import com.peace.machine.coding.vendingmachine.exceptions.InvalidDenominationException;
import com.peace.machine.coding.vendingmachine.exceptions.SoldOutException;
import com.peace.machine.coding.vendingmachine.utils.Bucket;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    03/06/19
 * Time:    8:21 PM
 */
public class VendingMachineServiceImpl implements VendingMachineService {

  Inventory<Coin> cashInventory = new Inventory();
  Inventory<Item> itemInventory = new Inventory();
  private long currentBalance;
  private Item currentItem;


  @Override
  public long selectItemAndGetPrice(Item item) {
    if (itemInventory.hasItem(item)) {
      return item.getPrice();
    }
    throw new SoldOutException("Sold Out, Please buy another item");
  }


  @Override
  public void insertCoin(Coin coin) {
    if (!coin.isValidDenomination(coin)) {
      throw new InvalidDenominationException("This coins is not accepted");
    }
    currentBalance += coin.getDenomination();
    cashInventory.add(coin);
  }

  @Override
  public Bucket<Item, List<Coin>> collectItemAndChange(Item item) {

    return null;
  }

  Item collectItem() {
    if (currentBalance >= currentItem.getPrice()) {

    }
    return null;
  }

  private boolean hasSufficientChange() {
    return true;
  }

  private List<Coin> getChange( long amount) {
    List<Coin> changes = new ArrayList<>();
    Set<Coin> coins = cashInventory.getAllItems();
    Coin[] coinsArray = (Coin[]) coins.toArray();
    return changes;
  }

  private boolean getChange(long amount, List<Coin> changes,Coin[]  coins, int idx ) {
    if (amount == 0 ) {
      return true;
    }
    if (amount < 0 || amount - coins[idx].getDenomination() < 0) return false;

    changes.add(coins[idx]);
    cashInventory.deduct(coins[idx]);;
    boolean include = getChange(amount-coins[idx].getDenomination(), changes, coins, idx);
    changes.remove(coins[idx]);
    cashInventory.add(coins[idx]);
    boolean exclude = getChange(amount, changes, coins, idx+1);
    return include || exclude;

  }

  @Override
  public List<Coin> refund() {
    return null;
  }

  @Override
  public void reset() {

  }
}
