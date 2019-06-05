package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    10:32 PM
 */
public class MaxPathSum {

  MaxPathSum() {

  }


  private  int maxPathSum(TreeNode<Integer> node) {
    if ( node == null) return 0;
    int leftSum = maxPathSum(node.left);
    int rightSum = maxPathSum(node.right);
    int currMax = Math.max(node.data, Math.max(leftSum,rightSum) + node.data);
    maxSum = Math.max( maxSum, Math.max(currMax,leftSum + rightSum + node.data));
    return currMax;
  }

  private static int maxSum = Integer.MIN_VALUE;

  public static void main(String[] args) {
    MaxPathSum maxPathSum = new MaxPathSum();
    BinaryTree bt = new BinaryTree();
    maxPathSum.maxPathSum(bt.root);
    System.out.println(maxSum);

  }
}
