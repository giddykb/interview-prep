package com.peace.stack;

import java.util.LinkedList;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    6:43 PM
 */
public class ImplementStackUsingQueue<T> {
  LinkedList<T> queue = null;

  ImplementStackUsingQueue(){
    queue = new LinkedList<>();
  }

  public void push(T data) {
    queue.add(data);
    int sz = queue.size();
   while (sz > 1) {
     queue.add(queue.remove());
     sz--;
   }
  }

  public T pop() {
    return queue.remove();
  }

  public T top() {
    return queue.peek();
  }



  public String toString(){
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < queue.size(); i++) {
      sb.append(queue.get(i)).append(" ");
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    ImplementStackUsingQueue<String> s = new ImplementStackUsingQueue();
    s.push("A");s.push("B");s.push("C");
    System.out.println(s.toString());
    s.pop();
    System.out.println(s.toString());
  }
}
