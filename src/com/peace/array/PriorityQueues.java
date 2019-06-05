package com.peace.array;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/05/19
 * Time:    2:59 PM
 */
public class PriorityQueues<Key> {
  Key[] pq;
  int capacity;
  int N ;


  PriorityQueues(int N) {
    this.capacity = N;
    pq = (Key[]) new Object[N];
  }

  public void offer(Key k) {
    if (N ==pq.length -1){

    }
    pq[++N] = k;
  }

  public void swim( int k) {

  }
}
