package com.peace.hackerrank;

import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/05/19
 * Time:    11:06 PM
 */
public class ReducedString {

  static String superReducedString(String s) {
    if (s == null || s.isEmpty()) return null;
    Stack<Character> stack = new Stack();
    int i = 0;
    while(i < s.length()) {
      Character c  = s.charAt(i);
      i++;
      if(!stack.isEmpty() && c.equals(stack.peek())) {
        stack.pop();
        continue;
      }
        stack.push(c);

    }
    String result = "";
    while(!stack.isEmpty()) {
      result  = stack.pop()+result;
    }
    return result;
  }


  public static void main(String[] args) {
    String s = "aaabccddd";
    System.out.println(superReducedString(s));
  }
}
