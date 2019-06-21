package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/06/19
 * Time:    12:13 AM
 */
public class LongestConsecutive {
  private int longestLength = 0;

  public int longestConsecutive(TreeNode root) {
    if (root == null) return 0;
    longestConsecutive(root, 0,(int)root.data);
    return longestLength;
  }

  public void longestConsecutive(TreeNode root, int currentLength, int expected) {
    if (root == null) return ;
    if (root.data.equals(expected)) {
      currentLength++;
    }
    else {
      currentLength = 1;
    }
    longestLength = Math.max(currentLength,longestLength);
    longestConsecutive(root.left,currentLength,(int)root.data+1);
    longestConsecutive(root.right,currentLength,(int)root.data+1);
  }

  public static void main(String[] args) {

  }
}
