package com.peace.slidwing.window;

import java.util.HashSet;
import java.util.Set;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    27/05/19
 * Time:    9:55 PM
 *
 *
 * https://www.techiedelight.com/find-longest-substring-containing-k-distinct-characters/
 *
 */
public class LongestSubStringKDistinctCharacters {

  static String longest(String str, int k ) {
    if( str == null || str.isEmpty() || k == 0) return null;

    int left = 0;
    int right = 0;
    int res [] = new int[3];
    Set<Character> window = new HashSet<>();
    int [] freq =  new int[26];

    while (right < str.length()) {
      window.add(str.charAt(right));
      freq[str.charAt(right) - 'a']++;

      while (window.size() > k) {
        if (--freq[str.charAt(left) - 'a'] == 0) {
          window.remove(str.charAt(left));
        }
        left++;
      }

      if (res[2] - res[1] < right -left) {
        res[2] = right;
        res[1] = left;
        res[0] = right -left + 1;
      }
      right++;

    }

    return str.substring(res[1] ,res[0]+res[1]);
  }

  public static void main(String[] args) {
    String s = "abcbdbdbbdcdabd";
    int k = 2;
    System.out.println(longest(s,k));
  }
}
