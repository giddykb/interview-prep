package com.peace.amazon;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    28/06/19
 * Time:    11:40 PM
 */
public class LRUCache<K,V> {

  private  static  int DEFAULT_CAPACITY =10;
  Node head ;
  Node tail;
  HashMap<K,Node> cache ;
  private int MAX_CAPACITY ;


  LRUCache() {
    cache = new HashMap<>(DEFAULT_CAPACITY);
    MAX_CAPACITY = 10;
  }

  LRUCache(int capacity) {
    MAX_CAPACITY = capacity;
    cache = new HashMap<>(capacity);
  }

  public void put(K k, V v) {

    if (cache.containsKey(k)) {
      Node n = cache.get(k);
      delete(n);
      setHead(n);
    } else {
      if (cache.size( ) >= MAX_CAPACITY) {
        cache.remove(tail.k);
        delete(tail);
      }
      Node n = new Node(k,v);
      cache.put(k,n);
      setHead(n);
    }
  }


  public V get(K k) {
    if (!cache.containsKey(k)) return null;
    Node n = cache.get(k);
    delete(n);
    setHead(n);
    return (V) n.v;
  }

  private void  setHead(Node n ) {
    n.next = head;
    if (head != null) {
      head.prev = n;
    }
    head  = n;
   if (tail == null) {
     tail = head;
   }
  }


  private void delete(Node node) {
    if (node.next != null) {
      node.next.prev= node.prev;
    } else {
      tail  = node.prev;
    }

    if (node.prev != null) {
      node.prev.next = node.next;
    } else {
      head = node.next;
    }
  }



  private static class Node<K,V> {
    K k;
    V v;
    Node next;
    Node prev;

    Node (K k, V v) {
      this.k = k;
      this.v = v;
    }
  }

  public static void main(String[] args) {

    Scanner scr = null;
    System.out.println("Please enter capacity");
    scr = new Scanner(System.in);
    int capacity = scr.nextInt();
    LRUCache cache = new LRUCache(capacity);

    while (true) {
      System.out.println("Enter command");
      scr = new Scanner(System.in);
      String inp =  scr.nextLine();
      if (inp.equals("exit")) break;
      else if (inp.contains("set")) {
        String [] s = inp.split(" ");
        cache.put(s[1],s[2]);
      } else if (inp.contains("get")) {
        String [] s = inp.split(" ");
        String v = (String) cache.get(s[1]);
        System.out.println(v);
      }
    }
  }
}
