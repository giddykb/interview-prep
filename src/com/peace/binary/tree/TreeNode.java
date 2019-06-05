package com.peace.binary.tree;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreeNode <T>{
    T data;
    TreeNode left;
    TreeNode right;
    TreeNode(T data) {
      this.data = data;
    }
  }