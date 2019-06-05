package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/05/19
 * Time:    8:54 PM
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class Diameter {
  public static void main(String[] args) {
    Diameter d = new Diameter();
    BinaryTree bt = new BinaryTree();
    System.out.println(d.diameter(bt.root));
  }

  public int diameter(TreeNode root) {
    diameterUtil(root);
    return maxLength;
  }

  public int diameterUtil(TreeNode root) {
    if ( root == null) return 0;
    int leftLength = diameterUtil(root.left);
    int rightLength = diameterUtil(root.right);
    maxLength = Math.max(maxLength, leftLength + rightLength );
    return Math.max(leftLength, rightLength) + 1;
  }

  private int maxLength = 0;
}
