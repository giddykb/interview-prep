package com.peace.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/06/19
 * Time:    9:29 AM
 *
 * https://leetcode.com/problems/heaters/
 */
public class MinimumRadius {


  public  int findRadiusOne( int houses [], int heaters []) {
    Arrays.sort(heaters);
    Arrays.sort(houses);
    int result = 0;
    int idx = 0;
    for (int house : houses) {
      while (idx < houses.length-1 && Math.abs(heaters[idx] - house) >= Math.abs(heaters[idx+1] - house)) {
        idx++;
      }
      result = Math.max(result, Math.abs((heaters[idx] - house)));
    }

    return result;

  }

  public int findRadiusTwo( int houses [], int heaters []) {
    int result = 0;
    Arrays.sort(heaters);
    Arrays.sort(houses);
    for (int house : houses) {
      int index = Arrays.binarySearch(heaters,house);
      if (index < 0) {
        index = ~index;
        int dist1 = index-1 >=0 ? house - heaters[index-1] : Integer.MAX_VALUE;
        int dist2 = index <  heaters.length ? heaters[index-1] - house: Integer.MAX_VALUE;
        result = Math.max(result, Math.min(dist1,dist2));
      }
    }
    return result;
  }

  public int findRadiusThree( int houses [], int heaters []) {
    int result = 0;
    TreeSet<Integer> set = new TreeSet<>();

    for (int heater : heaters) {
      set.add(heater);
    }

    for (int house : houses) {
      int dist1 = set.ceiling(house) == null ?  Integer.MAX_VALUE : set.ceiling(house)- house ;
      int dist2 = set.floor(house) == null ? Integer.MAX_VALUE : house - set.floor(house) ;
      result = Math.max(result, Math.min(dist1,dist2));
    }


    return result;
  }

  public static void main(String[] args) {

  }
}
