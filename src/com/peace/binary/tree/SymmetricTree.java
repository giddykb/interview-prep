package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    8:59 PM
 */
public class SymmetricTree {

  public boolean isSymmetric(TreeNode root) {
    return isSymmetric(root.left, root.right);
  }
  private boolean isSymmetric(TreeNode left, TreeNode right) {
    if(left == null && right == null) return true;
    if(left == null || right == null ) return false;
    return (left.data .equals(right.data)) &&
        isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    SymmetricTree st = new SymmetricTree();
    System.out.println(st.isSymmetric(bt.root));
  }
}
