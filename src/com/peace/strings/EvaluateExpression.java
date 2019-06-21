package com.peace.strings;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    08/05/19
 * Time:    2:47 AM
 */
public class EvaluateExpression {

  public static void main(String[] args) {

    String expression = "(2+((3+4)*(8-5)))";
    String expression1 = "(100 * (2 + 12))";
    System.out.println(evaluate(expression1));
    System.out.println(evaluate(expression));
  }


  static int evaluate(String s ) {
    int res= 0;
    Stack<String> stack = new Stack<>();

    int i = 0;
    while (i< s.length()) {
      String currentInteger = "";
      if(s.charAt(i) == ' ') {
        i++;
        continue;
      }
      if(s.charAt(i) >= '0' && s.charAt(i) <='9') {
        while ( i < s.length() &&  s.charAt(i) >= '0' && s.charAt(i) <='9') {
          currentInteger += String.valueOf(s.charAt(i));
          i++;
        }
        stack.push(currentInteger);
      }
      else  {
        if ( s.charAt(i) == ')')  {
          while (!stack.peek().equals("(")) {
            String operandOne = stack.pop();
            String operator = stack.pop();
            String operandTwo = stack.pop();
            res = performArthimetic(operandOne, operandTwo, operator);
          }
          stack.pop();
          stack.push(res+"");
        } else {
          stack.push(s.charAt(i)+"");
        }
        i++;

      }
    }

    return res;
  }
  static int performArthimetic(String op1, String op2, String operator) {
     Integer t1 =  Integer.valueOf(op2);
     Integer t2 =  Integer.valueOf(op1);
     if(operator.equals("+")) {
       return t1 + t2;
     } else if (operator.equals("-")) {
       return t1 -t2;
     } else if (operator.equals("*")) {
       return t1 * t2;
     }
     return -1;
  }
}
