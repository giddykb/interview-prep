package com.peace.queues;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    2:07 PM
 */

public class ImplementQueueUsingStack<T> {

  Stack<T> stackOne = null;
  Stack<T> stackTwo = null;


  ImplementQueueUsingStack () {
    stackOne = new Stack<>();
    stackTwo = new Stack<>();
  }

  public void push(T data){
    stackOne.push(data);
  }

  public T pop(){
    peek();
    return stackTwo.pop();
  }

  public T peek() {
    if (stackTwo.isEmpty()) {
      while (!stackOne.isEmpty()) {
        stackTwo.push(stackOne.pop());
      }
    }
    return stackTwo.peek();
  }

  public boolean isEmpty() {
    return stackOne.isEmpty() && stackTwo.isEmpty();
  }

  public static void main(String[] args) {
    ImplementQueueUsingStack<Integer> q = new ImplementQueueUsingStack<>();
    q.push(1);
    q.push(2);q.push(3);
    System.out.println(q.pop());
    q.push(4);
    System.out.println(q.peek());
    System.out.println(q.pop());

  }
}
