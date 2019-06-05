package com.peace.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    28/05/19
 * Time:    1:13 AM
 *
 * The hack number
 You are given two strings  and , a character C (which can be either Y or N), and an integer I.

 A Hack Number is defined as follows:

 It is the first occurrence (the index of the first character) of the string  in the string  starting from the initial position I or later in , depending on the value of C.
 If C is Y, then the matched  must have a space to the left of it in  or should be at the start of . It must have a space to the right of it in  or should be at the end of .
 If C is N, then there is no such compulsion and it can also be
 inside a word of . (See Sample Test case 2 and 3 as an example)
 If no element in S1 matches any element in S2, print “Goodbye Watson”.
 Input format

 First line: T (number of test cases)
 For each test case

 First line:
 Second line:
 Third line: C
 Fourth line: I
 Output format

 Print the hack number for each test case. If no valid number exists, print “Goodbye Watson”.

 Note
 All indexes are 0-based, including 'I' and the answer value of 'Hack Number'.


 Constraints
 1 ≤ T ≤ 100
 1 ≤ |S1| ≤ 50, containing letters('a'-'z', 'A'-'Z') and spaces.
 1 ≤ |S2| ≤ 50, containing only letters('a'-'z', 'A'-'Z').
 C will either be 'Y' or 'N'
 I will be between 0 and L-1, L=length of S1.

 Sample Input
 3
 We love to hack on hackerearth
 hack
 Y
 0
 We love to hack on hackerearth
 hack
 Y
 14
 We love to hack on hackerearth
 hack
 N
 14

 */
public class HackNumber {


  static void solve(String S1, String S2, char C, int I) {

    String res = "Goodbye Watson";
    if (C =='Y') {
     int index =  S1.indexOf(S2,I);
      if (index == -1) {
        System.out.println(res);
      }
      else if ((index == 0   &&  S1.charAt(index+S2.length()) == ' ') ||  (index+S2.length() == S1.length() &&  S1.charAt(index-1) == ' ')
         ||  (index > 0 && S1.charAt(index-1) == ' ' &&  S1.charAt(index+S2.length()) == ' ' )) {
       System.out.println(index);
     } else {
        System.out.println(res);
      }

    }
    else if( C =='N') {
      int index =  S1.indexOf(S2,I);
      if (index == -1) {
        System.out.println(res);
      } else  {
        System.out.println(index);

      }
    }

    return;
  }


  public static void main(String[] args) {

    solve("hackerearth love to hack on hackerearth", "hacker",'Y',0);

    int arr [] =  {3,1,5,10,4};
    List<Integer> list = Arrays.stream(arr)		// IntStream
        .boxed()  		// Stream<Integer>
        .collect(Collectors.toList());
    Collections.sort(list,Collections.reverseOrder());
    System.out.println(list.get(2));
  }
}
