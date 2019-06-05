package com.peace.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/05/19
 * Time:    10:13 PM
 * https://www.geeksforgeeks.org/design-a-data-structure-that-supports-insert-delete-search-and-getrandom-in-constant-time/
 */
public class DataStructureConstantTime<T> {

  HashMap<T, Integer> map = null;
  ArrayList<T> list = null;

  DataStructureConstantTime() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  public void insert(T u) {
    if (!map.containsKey(u)) {
      map.put(u,list.size());
      list.add(u);
    }
  }

  public boolean remove(T u){
    if (map.containsKey(u)) {
      int index = map.get(u);
      map.remove(u);
      T last = list.get(list.size()-1);
      if (index != list.size()-1) {
        Collections.swap(list, index, list.size()-1);
        map.put(last,index);
      }
      list.remove(list.size()-1);
      return true;
    }
    return false;
  }

  public Integer search(T u) {
    return map.get(u);
  }

  public T getRandom() {
    Random rand = new Random();
    Integer idx = rand.nextInt(list.size());
    return list.get(idx);

  }

  public static void main(String[] args) {
    DataStructureConstantTime<Integer> myds = new DataStructureConstantTime<>();
    myds.insert(1);
    myds.insert(2);
    myds.insert(3);
    System.out.println(myds.getRandom());
    System.out.println(myds.search(4));
    System.out.println(myds.remove(1));
  }
}
