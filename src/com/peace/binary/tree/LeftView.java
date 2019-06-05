package com.peace.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/05/19
 * Time:    12:44 AM
 */
public class LeftView {
  private  int maxLevelSoFar = -1;

  public List<Integer> leftViewUtil(TreeNode root){
    List<Integer> result = new ArrayList<>();
    leftViewUtil(root, 0,result);
    return result;
  }


  public void leftViewUtil(TreeNode<Integer> root, int currLevel, List<Integer> result){
    if( root == null) return;
    if( currLevel > maxLevelSoFar) {
      result.add(root.data);
      maxLevelSoFar  = currLevel;
    }
    leftViewUtil(root.left, currLevel+1,result);
    leftViewUtil(root.right, currLevel+1, result);
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    LeftView leftView = new LeftView();
    List<Integer> result = leftView.leftViewUtil(bt.root);
    System.out.println(result);

  }
}
