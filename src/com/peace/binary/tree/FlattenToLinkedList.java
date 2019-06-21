package com.peace.binary.tree;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/06/19
 * Time:    12:33 AM
 */
public class FlattenToLinkedList {

  public  void flatten(TreeNode root) {
    if (root == null) return;
    TreeNode curr = root;

    while (curr != null) {
      if (curr.left != null) {
        TreeNode last = curr.left;
        while (last.right != null) last = last.right;
        last.right = curr.right;
        curr.right = curr.left;
        curr.left = null;
      }
      curr =curr.right;
    }
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    FlattenToLinkedList flatten = new FlattenToLinkedList();
    flatten.flatten(bt.root);
  }
}
