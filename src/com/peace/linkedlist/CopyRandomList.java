package com.peace.linkedlist;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    21/05/19
 * Time:    7:18 PM
 *  https://leetcode.com/problems/copy-list-with-random-pointer
 */
public class CopyRandomList {
  Node head;



  public Node clone() {
    if(head == null) return null;

    Node curr = head;

    while (curr !=null) {
      Node t = new Node(curr.val);
      t.next = curr.next;
      curr.next = t;
      curr = curr.next.next;
    }

    curr = head;
    while (curr != null) {
      if ( curr.random!= null){
        curr.next.random = curr.random.next;
      }
      curr = curr.next.next;
    }

    Node copy = head.next;
    curr = head;

    while (curr.next != null) {
      Node tmp = curr.next;
      curr.next = curr.next.next;
      curr = tmp;
    }

    return copy;
  }


  void insert( int val) {
    Node n = new Node(val);
    if (head == null) head = n;
    else {
      Node curr = head;
      while (curr.next != null) {
        curr = curr.next;
      }
      curr.next = n;
    }
  }

  public String toString(){
    StringBuilder sb = new StringBuilder();
    Node curr = head;
    while (curr != null) {
      sb.append(curr.val);
      sb.append("->");
      curr=curr.next;
    }
    sb.append("null");
    return sb.toString();
  }


  public static void main(String[] args) {
    CopyRandomList list1 = new CopyRandomList();
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
/*
    n1.next = n2;
    n2.next =n3;
    n3.next = n4;
    n4.next =n5;
    n1.random = n3;
    n2.random = n1;
    n3.random = n4;
    n4.random = n3;
    n5.random = n2;
*/
    list1.head = n1;
    CopyRandomList list2 = new CopyRandomList();
    Node t = list1.clone();
    while ( t != null) {
      System.out.print( t.val + "->");
      t =t.next;
    }
    System.out.println("---");
    System.out.println(list1);
  }

  static  class Node {

    private int val;
    Node next;
    Node random;

    Node (int val) {
      this.val = val;
    }


  }
}
