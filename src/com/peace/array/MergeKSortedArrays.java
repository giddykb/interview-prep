package com.peace.array;

import java.util.*;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/05/19
 * Time:    2:09 PM
 */
public class MergeKSortedArrays {

  public static int[] merge(int [][] arrays) {

    int sz = 0;
    for (int i = 0; i <arrays.length ; i++) {
      sz += arrays[0].length;
    }
    int result[] = new int[sz];

    PriorityQueue<HeapNode> minHeap =
        new PriorityQueue<>(arrays.length, (HeapNode a, HeapNode b) -> a.val -b.val);

    for (int i = 0; i < arrays.length; i++) {
      minHeap.offer(new HeapNode(i,0,arrays[i][0]));
    }
    for (int i = 0; i < sz ; i++) {
      HeapNode node = minHeap.poll();
      result[i] = node.val;
      int nextIndex = node.index +1;
      if (nextIndex < arrays[node.arrayNum].length) {
        minHeap.offer(new HeapNode(node.arrayNum, nextIndex,arrays[node.arrayNum][nextIndex]));
      }
    }

    return result;
  }

  private static class HeapNode {
    int arrayNum;
    int index;
    int val;

    HeapNode(int arrayNum, int idx, int val) {
      this.arrayNum = arrayNum;
      this.index = idx;
      this.val = val;
    }

  }

  public static void main(String[] args) {
    int[][] input  ={
        { 1, 5, 8, 9 }, {2, 3, 7, 10}, { 4, 6, 11, 15  },{ 9, 14, 16, 19 },{ 2, 4, 6, 9 }
    };

    int [] result = merge(input);
    System.out.println(Arrays.toString(result));
  }
}
