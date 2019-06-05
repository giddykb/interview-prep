package com.peace.array;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    22/05/19
 * Time:    5:37 AM
 */
public class SearchInRotatedArray {

  public static void main(String[] args) {

    int arr  [] = {4,5,6,7,8,1,2,3};
    System.out.println(search(arr,2));
  }

  static  int search(int arr[], int element) {
    return search(arr, element,0 , arr.length-1);
  }

  static int search(int arr[] , int element, int lo, int hi) {
    if (lo > hi) return -1;

    if (arr[lo] == element) return lo;
    else if (arr[hi] == element) return hi;

    int mid = lo + (hi - lo) / 2;

    if (arr[mid] == element) return mid;

     if (arr[lo] <= arr[mid]) {
      if (element >= arr[lo] && element <= arr[mid]) {
        return search(arr, element, lo, mid - 1);
      }
        return search(arr, element, mid + 1, hi);
     }

     if (element >= arr[mid + 1] && element <= arr[hi]) {
       return search(arr, element, mid + 1, hi);
     }

    return search(arr, element, lo, mid-1);
  }

  static int searchTwo(int arr[], int target) {

    return -1;
  }
}
