package com.peace.binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/05/19
 * Time:    2:11 AM
 */
public class VerticalOrder {



  public TreeMap<Integer,List<Integer>> verticalOrderUtil(TreeNode root){
    TreeMap<Integer,List<Integer>> result  = new TreeMap<>();
    verticalOrderUtil(root, 0, result);
    return result;
  }

  public void verticalOrderUtil(TreeNode<Integer> treeNode, int dist,
                                                          TreeMap<Integer,List<Integer>> map) {
    if (treeNode == null) return ;
    if(!map.containsKey(dist)) {
      map.put(dist, new ArrayList<>());
    }
    map.get(dist).add(treeNode.data);
    verticalOrderUtil(treeNode.left, dist-1, map);
    verticalOrderUtil(treeNode.right, dist+1, map);
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    VerticalOrder verticalOrder = new VerticalOrder();
    TreeMap<Integer,List<Integer>> result  = verticalOrder.verticalOrderUtil(bt.root);
    result.forEach((k,v) -> System.out.println( k + ", " + v));
  }
}
