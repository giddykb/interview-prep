package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/06/19
 * Time:    2:04 AM
 *
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * https://www.programcreek.com/2013/01/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructBinaryTree {

  public TreeNode buildTee(int [] inOrder, int [] postOrder) {

    int inStart = 0;
    int inEnd = inOrder.length-1;
    int postStart = 0;
    int postEnd = postOrder.length-1;
    return buildTee(inOrder,postOrder,inStart,inEnd,postStart,postEnd);
  }

  public TreeNode buildTee(int [] inOrder, int [] postOrder,int inStart, int inEnd,
                           int postStart, int postEnd) {

    if (inStart > inEnd || postStart > postEnd) return null;

    int rootVal = postOrder[postEnd];
    TreeNode root = new TreeNode(rootVal);
    int k = getRootInorderIndex(rootVal, inOrder);
    root.left = buildTee(inOrder,postOrder,inStart,k,postStart, postStart +(k-inStart-1));
    root.right = buildTee(inOrder,postOrder,k+1,inEnd, postStart + (k-inStart),postEnd-1);
    return root;
  }

  public int getRootInorderIndex(int val, int [] inOrder) {

    for (int i = 0; i < inOrder.length; i++) {
      if (val == inOrder[i]) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] inOrder = { 4, 2, 5, 1, 6, 3, 7 };
    int[] postOrder = { 4, 5, 2, 6, 7, 3, 1 };
    ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
    TreeNode treeNode = constructBinaryTree.buildTee(inOrder,postOrder);
    System.out.println(treeNode);
  }

}
