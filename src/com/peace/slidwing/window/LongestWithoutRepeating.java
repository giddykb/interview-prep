package com.peace.slidwing.window;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    28/05/19
 * Time:    7:57 PM
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestWithoutRepeating {

  static  int lengthOfLongest(String s) {
    if (s == null || s.isEmpty()) return 0;

    HashMap<Character,Integer> map = new HashMap<>();
    int maxLength =0 ;
    int left = 0, right= 0;
    while (right < s.length()) {
      if (map.containsKey(s.charAt(right))) {
        left = Math.max(left, map.get(s.charAt(right)) +1);
      }
      map.put(s.charAt(right), right);
      maxLength = Math.max(maxLength, right-left +1);
      right++;
    }
    return maxLength;
  }

  public static void main(String[] args) {
    String s = "adbccba";
    System.out.println(lengthOfLongest(s));
  }
}
