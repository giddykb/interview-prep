package com.peace.slidwing.window;

import java.util.HashMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/06/19
 * Time:    11:28 PM
 */
public class LongestSubstringKDistinct {

  public static int longestLength(String s, int k) {
    if (s == null || s.length() == 0) return 0;
    HashMap<Character,Integer> map = new HashMap<>();
    int left = 0;
    int right = 0;
    int res [] = {0,0,0};
    while (right < s.length()) {
      int count = map.getOrDefault(s.charAt(right),0);
      map.put(s.charAt(right),count+1);
      if (map.size() <= k) {
        if (res[0] < right - left + 1) {
          res[0] = right - left + 1;
          res[1] = left;
          res[2] = right;
        }
      } else  {
          while (map.size() > k) {
            Character c = s.charAt(left);
            if (map.get(c) ==1 ) {
              map.remove(c);
            } else {
              map.put(c, map.get(c)-1);
            }
            left++;
          }
        }
      right++;

    }
    System.out.println("Result : " + s.substring(res[1],res[2]+1));
    return res[0];
  }
  public static void main(String[] args) {
    String s = "abcadcacacaca";
    int k = 3;
    System.out.println(longestLength(s,k));
  }
}
