package com.peace.binary.tree;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    09/05/19
 * Time:    3:52 PM
 */
@Getter
@Setter
public class BinaryTree {
  TreeNode root;

  BinaryTree() {
    //String data = "[3,5,1,6,2,0,8,null,null,7,4]";
    String data = "[1,2,5,3,4,null,6]";
    constructTreeLevelOrder(data);

  }

  public static void main(String[] args) {
    String data = "[1, 2, 4, 3, null,5,6,null,null,7,null]";
    BinaryTree bt = new BinaryTree();
    bt.constructTreeLevelOrder(data);
  }

  void constructTreeLevelOrder(String data) {
    if ( data == null || data.length()==0 ) return;
    String strArray [] = data.substring(1,data.length()-1).split(",");
    Deque<String> strList = new LinkedList<>(Arrays.asList(strArray));

    Queue<TreeNode> queue = new LinkedList<>();
    //queue.add(strList.getFirst());
    Integer val = Integer.valueOf((String) strList.remove());
    root = new TreeNode(val);
    queue.add(root);
    while (!strList.isEmpty()) {
      TreeNode curr =  queue.remove();
      if(curr != null) {
        String str = strList.remove();

        if(!str.trim().equals("null")) {
          val = Integer.valueOf((String) str);
          TreeNode left = new TreeNode(val);
          curr.left = left;
          queue.add(left);

        }
        if(strList.isEmpty()) break;
        str = strList.remove();
        if(!str.trim().equals("null")) {
          val = Integer.valueOf((String) str);
          TreeNode right = new TreeNode(val);
          curr.right = right;
          queue.add(right);
         }
        }
      }


  }

}
