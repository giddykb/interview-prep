package com.peace.slidwing.window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    05/06/19
 * Time:    4:49 PM
 */
public class LongestSubstringDistinctCharacters {

  public static String longestSubString(String str) {
    if (str ==  null || str.length() == 0) return null;

    int left  = 0;
    int right = 0;
    int res[] = new int[3];
    HashMap<Character, Integer> map = new HashMap<>();
    while (right < str.length()) {
      Character curr = str.charAt(right);
      if (map.containsKey(curr)) {
        int idx = map.get(curr);
        left = Math.max(left,idx+1);
      }
      if (res[0] <  right-left +1) {
         res[0] =  right-left +1;
         res[1] = left;
         res[2] = right;
      }
      map.put(curr, right);
      right++;
    }
    return str.substring(res[1],res[2]+1);
  }

  public static void main(String[] args) {
    String str = "abbcdafeegh";
    System.out.println(longestSubString(str));

  }
}
