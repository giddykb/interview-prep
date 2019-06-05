package com.peace.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    9:09 PM
 */
public class LevelOrderTraversal<T> {

  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if( root == null) return new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> levelList = new ArrayList<>();
      while (size-- > 0) {
        TreeNode curr = queue.remove();
        levelList.add((Integer.valueOf((String) curr.data)));
        if(curr.left != null) queue.add(curr.left);
        if(curr.right != null) queue.add(curr.right);
      }
      result.add(levelList);
    }
    return result;

  }
  public List<List<Integer>> levelOrderRecursive(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    levelOrderRecursive(root, 0, result);
    return result;
  }

  private  int maxLevel = -1;
  private void levelOrderRecursive(TreeNode node, int currentLevel, List<List<Integer>> result) {
    if( node == null) return;
    Integer val = Integer.valueOf((String) node.data);
    if(currentLevel > maxLevel) {
      List<Integer> list = new ArrayList<>();
      list.add(val);
      result.add(list);
      maxLevel = currentLevel;
    }

    else {
      result.get(currentLevel).add(val);
    }

    levelOrderRecursive(node.left, currentLevel + 1, result);
    levelOrderRecursive(node.right, currentLevel + 1, result );

  }
  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
    List<List<Integer>> result = levelOrderTraversal.levelOrder(bt.root);
    for (List<Integer> levelList : result) {
      System.out.println(levelList);
    }
    System.out.println("------Recursive Level Order Traversal-------");
    result = levelOrderTraversal.levelOrderRecursive(bt.root);
    for (List<Integer> levelList : result) {
      System.out.println(levelList);
    }
  }
}
