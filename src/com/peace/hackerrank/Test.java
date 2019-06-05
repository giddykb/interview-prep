package com.peace.hackerrank;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    28/05/19
 * Time:    12:40 AM
 *
 * Palindromic String Problem
 You are given two strings  and . You need to convert the string  into a palindromic string such that it contains the string  as its substring by using minimum number of operations. You are allowed to use only one type of operation i.e., you can replace any character of the string  with any other character.

 Input format

 First line:  denoting the number of test cases

 For each test case,

 First line: String
 Second line: String
 Note

 Both the strings can contain lower and upper case letters only.
 The upper case letter and its corresponding lower case letter are not the same. For example, A and a are considered as distinct characters.
 Output format

 Print the minimum number of operations that are required in a single line. If that is not possible, print .
 Constraints


 Length

 Sample Input
 2
 archit
 ar
 aaaaa
 bbb
 Sample Output
 3
 3
 Explanation
 In the first sample, we can get a string "arccra" or " arhhra" as our final string which is both palindromic as well as contains "ar" as substring. We can see that our final string differs from original string i.e. "archit" in exactly 3 places. So, minimum number of operations required is 3.

 Note: Your code should be able to convert the sample input into the sample output. However, this is not enough to pass the challenge, because the code will be run on multiple test cases. Therefore, your code must solve this problem statement.

 */
public class Test {

  static int Solver(String s1, String s2) {
    if(s1.length() < s2.length()) return -1;
    int count = 0;
    int left  = 0;
    int right = s1.length()-1;

    while (left<right) {
      if (s1.charAt(left) != s1.charAt(right)) {
        count++;
      }
      left++;
      right--;
    }

    if(count == 0 && !s1.contains(s2)) {
      return s2.length();
    }
    return count;

  }

  public static void main(String[] args) {
    String s1 = "aaaaa";
    String s2 = "bbb";
    System.out.println(Solver(s1,s2));
  }
}
