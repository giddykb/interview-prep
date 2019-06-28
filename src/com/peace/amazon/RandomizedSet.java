package com.peace.amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    29/06/19
 * Time:    1:39 AM
 *
 * Insert Delete GetRandom O(1)

 * Design a data structure that supports all following operations in average O(1) time.
 insert(val): Inserts an item val to the set if not already present.
 remove(val): Removes an item val from the set if present.
 getRandom: Returns a random element from current set of elements.
 Each element must have the same probability of being returned.
 */
public class RandomizedSet<T> {

  private HashMap<T,Integer> map ;
  private ArrayList<T> list ;

  RandomizedSet() {
    map = new HashMap<>();
    list = new ArrayList<>();
  }

  public boolean insert(T val) {
    if (map.containsKey(val)) return false;
    map.put(val, list.size());
    list.add(val);
    return true;
  }

  public boolean remove(T val) {
    if (!map.containsKey(val)) return false;
    int idx = map.get(val);
    T lastVal = list.get(list.size()-1);
    list.set(idx, lastVal);
    map.put(lastVal,idx);
    list.remove(list.size()-1);
    map.remove(val);
    return true;
  }

  public T getRandom() {
    Random rand = new Random();
    int idx = rand.nextInt(list.size());
    return list.get(idx);
  }

  @Override
  public String toString() {
    return list.toString();
  }

  public static void main(String[] args) {
    RandomizedSet<String> set = new RandomizedSet<>();
    set.insert("cat");
    set.insert("dog");
    set.insert("apple");
    System.out.println(set);
    System.out.println(set.getRandom());
  }
}
