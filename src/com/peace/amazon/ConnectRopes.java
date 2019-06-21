package com.peace.amazon;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/06/19
 * Time:    2:21 AM
 */
public class ConnectRopes {

  public static int getMinimumCost( int [] ropeLengths) {
    if (ropeLengths.length == 0) return 0;
    if (ropeLengths.length < 2) return ropeLengths[0];

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    List<Integer> list = Arrays.stream(ropeLengths).boxed().collect(Collectors.toList());
    minHeap.addAll(list);
    int mincost = 0;

    while (minHeap.size()>1) {
      Integer min1 = minHeap.poll();
      Integer min2 = minHeap.poll();
      mincost += (min1+min2);
      minHeap.add(min1+min2);

    }
    return mincost;
  }

  public static void main(String[] args) {
    int ropeLengths [] = {5,2,3,9};
    System.out.println(getMinimumCost(ropeLengths));
  }
}
