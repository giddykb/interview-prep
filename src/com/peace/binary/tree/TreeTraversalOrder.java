package com.peace.binary.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    10/05/19
 * Time:    8:26 PM
 */
public class TreeTraversalOrder<T> {

  public List<T> inOrderTraversal = null;
  public List<T> preOrderTraversal = null;
  public List<T> postOrderTraversal = null;

  TreeTraversalOrder() {
    inOrderTraversal = new ArrayList<>();
    preOrderTraversal = new ArrayList<>();
    postOrderTraversal = new ArrayList<>();

  }

  public void inOrder(TreeNode t ) {
    if( t == null ) return;
    inOrder(t.left);
    inOrderTraversal.add((T)t.getData());
    inOrder(t.right);
  }

  public void preOrder(TreeNode t ) {
    if( t == null ) return;
    preOrderTraversal.add((T)t.getData());
    preOrder(t.left);
    preOrder(t.right);
  }
  public void postOrder(TreeNode t ) {
    if( t == null ) return;
    postOrder(t.left);
    postOrder(t.right);
    postOrderTraversal.add((T)t.getData());
  }

  public static void main(String[] args) {
    BinaryTree bt = new BinaryTree();
    TreeTraversalOrder treeTraversalOrder = new TreeTraversalOrder();
    treeTraversalOrder.inOrder(bt.root);
    treeTraversalOrder.preOrder(bt.root);
    treeTraversalOrder.postOrder(bt.root);
    System.out.println(" In Order" + treeTraversalOrder.inOrderTraversal);
    System.out.println(" Pre order" + treeTraversalOrder.preOrderTraversal);
    System.out.println( "Post Order" + treeTraversalOrder.postOrderTraversal);
  }
}
