package com.peace.binary.tree;

/**
 * Created using IntelliJ IDEA
 * Author:  girishkumar
 * Date:    17/05/19
 * Time:    4:42 PM
 */
public class SumTree {

  public static void main(String[] args) {
    SumTree st = new SumTree();
    BinaryTree bt = new BinaryTree();
    st.sumTree(bt.root);
    TreeTraversalOrder t = new TreeTraversalOrder();
    t.inOrder(bt.root);
    System.out.println(t.inOrderTraversal);

  }

  public TreeNode sumTree(TreeNode root) {
    sumTreeUtil(root);
    return root;
  }

  public int sumTreeUtil(TreeNode node) {
    if (node == null) return  0;

    int left = sumTreeUtil(node.left);
    int right = sumTreeUtil(node.right);
    int oldData = (int) node.data;
    node.data = left + right;
    return (int) node.data + oldData ;

  }
}
