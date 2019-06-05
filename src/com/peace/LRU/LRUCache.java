package com.peace.LRU;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/05/19
 * Time:    11:25 PM
 */
public class LRUCache<K,V> {

  private static int CAPACITY = 10;
  HashMap<K,Node> cache = new HashMap<>();
  Node head;
  Node tail;

  LRUCache() {

  }

  LRUCache(int capacity) {
    this.CAPACITY = capacity;
  }

  public  void put(K k, V v) {
    if (cache.containsKey(k)) {
      Node n = cache.get(k);
      delete(n);
      setHead(n);
    } else {
      Node newNode = new Node(k,v);
      if (cache.size() >= CAPACITY) {
        cache.remove(tail.key);
        delete(tail);
      }
      cache.put(k, newNode);
      setHead(newNode);
    }
  }


  private void delete(Node node) {
    if (node.next != null) {
      node.next.prev = node.prev;
    } else {
      tail = node.prev;
    }
    if (node.prev !=null) {
      node.prev.next= node.next;
    } else {
      head = node.next;
    }

  }

  private void setHead(Node node) {
    node.next = head;
    node.prev = null;
    if( head != null) {
      head.prev = node;
    }
    head = node;
    if (tail == null) {
      tail = head;
    }
  }

  public V get(K k) {
    if (cache.containsKey(k)) {
      Node node = cache.get(k);
      delete(node);
      setHead(node);
      return (V) node.value;
    }
    return null;
  }

  private static class Node<K,V> {
    K key;
    V value;
    Node next;
    Node prev;

    Node(K k, V v) {
      this.key = k;
      this.value = v;
    }

  }

  public static void main(String[] args) {
    LRUCache LRU = new LRUCache(2);
    LRU.put(1,1);
    LRU.put(2,2);
    System.out.println(LRU.get(1));
    LRU.put(3,3);
    System.out.println(LRU.get(2));
    LRU.put(4,4);
    System.out.println(LRU.get(1));
    System.out.println(LRU.get(3));
    System.out.println(LRU.get(4));
  }

}
