package com.peace.array;

import java.util.Arrays;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    08/05/19
 * Time:    10:17 PM
 *
 * We can determine how "out of order" an array A is by counting the number of inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A[j] but i < j. That is, a smaller element appears after a larger element.

 Given an array, count the number of inversions it has. Do this faster than O(N^2) time.

 You may assume each element in the array is distinct.

 For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] has ten inversions: every distinct pair forms an inversion.
 */


public class CountInversions {
  public static void main(String[] args) {
    int a[] = {5, 4, 3, 2, 1};
    System.out.println(bruteForce(a));
    System.out.println(mergeSort(a));
  }


  public static int mergeSort(int arr[]) {
    int []aux = Arrays.copyOf(arr,arr.length);
    return mergeSort(arr, aux, 0, arr.length-1);
  }

  public static int mergeSort(int arr[], int aux[], int low, int high) {
    if (high<=low) return 0;
    int mid = (low +(high-low)/2) ;
    int inversionCount = 0;
    inversionCount += mergeSort(arr,aux,low,mid);
    inversionCount += mergeSort(arr,aux,mid+1,high);
    inversionCount += merge(arr,aux,low, mid, high);
    return inversionCount;

  }

  public static int merge(int arr[] ,int aux[], int low, int mid, int high){

    for (int k =low; k<=high;k++){
      aux[k] = arr[k];
    }

    int i= low;
    int j = mid +1;
    int inversionCount = 0;
    for (int k=low; k<=high ;k++) {
      if(i > mid) arr[k] = aux[j++];
      else if(j > high) arr[k] = aux[i++];
      else if(aux[i] <= aux[j]) {
        arr[k] = arr[i++];
      } else {
        arr[k] = aux[j++];
        inversionCount += ( mid-i+1);
      }
    }
    return inversionCount;
  }


  public static int bruteForce (int [] a) {
    int count = 0;
    for (int i = 0; i <a.length-1 ; i++) {
      for (int j = i+1; j < a.length ; j++) {
        if(a[i] > a[j]) {
          count++;
        }
      }
    }
    return count;
  }
}
