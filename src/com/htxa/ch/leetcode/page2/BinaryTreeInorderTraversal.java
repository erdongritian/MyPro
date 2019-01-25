package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 * 左中右
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root!=null){
            inorder(result,root);
        }
        return result;
    }

    private void inorder(List<Integer> list,TreeNode root){
        if(root.left!=null){
            inorder(list,root.left);
        }
        list.add(root.val);
        if(root.right!=null){
            inorder(list,root.right);
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
