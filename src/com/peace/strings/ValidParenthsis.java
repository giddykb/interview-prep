package com.peace.strings;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    08/05/19
 * Time:    12:45 AM
 */
public class ValidParenthsis {

  static HashMap<Character,Character> mappings = new HashMap<>();
  static {
    mappings.put(')','(');
    mappings.put(']','[');
    mappings.put('}','{');
  }

  public static void main(String[] args) {
    String s = "()";
    System.out.println(isValid(s));

  }

  public static boolean isValid(String str) {
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while (i <str.length()) {
      Character c = str.charAt(i++);
      if(!mappings.containsKey(c)){
        stack.push(c);
      } else{
        if(stack.isEmpty()) return false;
        Character topElement = stack.pop();
        if(!topElement.equals(mappings.get(c))){
          return false;
        }
      }
    }
    return stack.isEmpty();
  }

  public static boolean isValidParanthesis(String s ) {
    Stack<Character> stack = new Stack<>();

    for (Character c : s.toCharArray()) {
      if(c == '(') {
        stack.push(')');
      } else if (c == '[') {
        stack.push(']');
      } else if ( c == '{') {
        stack.push('}');
      } else if( stack.isEmpty() || stack.pop() != c) {
        return false;
      }
    }
    return stack.isEmpty();
  }
}
