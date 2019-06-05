package com.peace.binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    9:53 PM
 */
public class ZigZagLevelOrder {

  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    boolean isRightToLeft = false;
    while (!queue.isEmpty()) {
      int sz = queue.size();
      LinkedList<Integer> list  = new LinkedList<>();
      while (sz-- > 0) {
        TreeNode curr = queue.remove();
        int val = Integer.valueOf((String) curr.data);
        if (isRightToLeft) {
          list.addFirst(val);
        } else {
          list.add(val);
        }
        if(curr.left != null) queue.add(curr.left);
        if (curr.right != null) queue.add(curr.right);

      }
      result.add(list);
      isRightToLeft = !isRightToLeft;
    }
    return result;
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    ZigZagLevelOrder zigZagLevelOrder = new ZigZagLevelOrder();
    List<List<Integer>> result = zigZagLevelOrder.zigzagLevelOrder(bt.root);
    for (List<Integer> levelList : result) {
      System.out.println(levelList);
    }
  }

}
