package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/05/19
 * Time:    9:35 PM
 */
public class LowestCommonAncestor {

  LowestCommonAncestor(){}


  TreeNode LCA(TreeNode root, TreeNode p , TreeNode q) {
    if (root == null) return null;
    if( root.data == p.data || root.data == q.data) {
      return root;
    }

    TreeNode left  =  LCA(root.left, p, q);
    TreeNode right =  LCA(root.right, p, q);

    if (left != null && right != null) return root;
    else if (left != null) return left;
    else if (right!= null) return right;
    else  return null;
  }

  public static void main(String[] args) {
    BinaryTree bt  = new BinaryTree();
    LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
    TreeNode p = new TreeNode(6);
    TreeNode q = new TreeNode(7);
    TreeNode res  = lowestCommonAncestor.LCA(bt.root, p , q );
    if (res != null) {
      System.out.println("LCA is " + res.data);
    }



  }
}
