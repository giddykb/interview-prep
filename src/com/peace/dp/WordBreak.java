package com.peace.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/05/19
 * Time:    6:56 PM
 */
public class WordBreak {
  public static void main(String[] args) {
    String [] arr =  {"cats", "dog", "sand", "and", "cat"};
    Set<String> dictionary = new HashSet<>();
    dictionary.add("cats");
    dictionary.add("dog");
    dictionary.add("sand");
    dictionary.add("and");
    dictionary.add("cat");
    dictionary.add("fog");

    String input = "catsandfog";
    System.out.println(isWordBreak(input,dictionary, ""));
  }

  public static boolean isWordBreak(String input, Set<String> dictionary, String answer) {
    if(input.length() == 0)  {
      System.out.println( answer);
      return true;
    }

    if (dictionary.contains(input))  {
      System.out.println( answer + " " + input);
      return true;
    }

    for (int i = 0; i < input.length(); i++) {
      String prefix = input.substring(0,i);
      if (dictionary.contains(prefix)) {
        String suffix = input.substring(i,input.length());
        if (isWordBreak(suffix, dictionary, answer + prefix + " ")) {
          return true;
        }
      }
    }
    return false;
  }
}
