package com.peace.google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    26/06/19
 * Time:    11:53 AM
 * https://evelynn.gitbooks.io/google-interview/meeting_rooms_ii.html
 * https://evelynn.gitbooks.io/google-interview/meeting_rooms.html
 */
public class MeetingRooms {

  public static boolean canAttendMeeting(int [][] intervals) {

    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    for (int i = 1; i < intervals.length; i++) {
      if (intervals[i-1][1] > intervals[i][0]) {
        return false;
      }
    }

    return true;
  }


  public static  int minimumRoomsRequired(int [][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
      }
    });

    int minRooms = 0;

    return minRooms;
  }


  public static void main(String[] args) {
    int [][] intervals =  { {0, 30},{15, 20},{5, 10} };
    System.out.println(canAttendMeeting(intervals));

  }
}
