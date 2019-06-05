package com.peace.slidwing.window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    04/06/19
 * Time:    10:21 PM
 * https://www.techiedelight.com/find-substrings-string-permutation-given-string/
 */
public class SubstringsThatArePermutations {

  static List<String> findAllAnagrams(String X, String Y) {
    List<String> result = new ArrayList<>();
     int [] frequency = new int[26];
    for (int i = 0; i < Y.length(); i++) {
      frequency[Y.charAt(i) -'A']++;
    }

    int left = 0, right = 0;
    while (right < X.length()) {
      frequency[X.charAt(right) - 'A']--;
      if (right - left+1 == Y.length()) {
        boolean isAnagram = true;
        for (int i = 0; i <  frequency.length; i++) {
          if (frequency[i] != 0) {
            isAnagram = false;
            break;
          }
        }
        if (isAnagram) {
          String res = X.substring(left,right+1);
          System.out.println(" Anagram found at Index:" + left +" ::" + res);
          result.add(X.substring(left,right+1));
        }
        frequency[X.charAt(left) - 'A']++;
        left++;

      }
      right++;
    }
    return result;
  }


  public static void main(String[] args) {
    String X = "XYYZXZYZXXYZ";
    String Y = "XYZ";
    List<String> result = findAllAnagrams(X,Y);
    System.out.println(result);
  }
}
