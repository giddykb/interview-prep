package com.peace.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    11/05/19
 * Time:    12:51 AM
 */
public class RightView {

  private  int maxLevelSoFar = -1;
  public List<Integer> rightViewUtil(TreeNode root){
    List<Integer> result = new ArrayList<>();
    rightViewUtil(root, 0,result);
    return result;
  }

  private void rightViewUtil(TreeNode<Integer> root, int currentLevel, List<Integer> result) {
    if (root == null) return;
    if( currentLevel > maxLevelSoFar) {
      result.add(root.data);
      maxLevelSoFar = currentLevel;
    }
    rightViewUtil(root.right,currentLevel+1,result);
    rightViewUtil(root.left,currentLevel+1,result);
  }


  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    RightView rightView = new RightView();
    List<Integer> result = rightView.rightViewUtil(bt.root);
    System.out.println(result);
  }

}
