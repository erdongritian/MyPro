package com.htxa.ch.leetcode.page2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Binary Search Trees(BST)二叉树搜索
 * 非叶子结点的左指针指向小于其关键字的子树，右指针指向大于其关键字的子树
 * TODO:未完成
 */
public class UniqueBinarySearchTreesII {

    public static void main(String[] args) {
        UniqueBinarySearchTreesII t=new UniqueBinarySearchTreesII();
        t.generateTrees(3);
        System.out.println(t.result);

    }


    List<TreeNode> result=new ArrayList<>();
    public List<TreeNode> generateTrees(int n) {
        LinkedList<Integer> intArray=new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            intArray.add(i);
        }

        getTrees(intArray,new TreeNode(0),n);

        return result;
    }

    private void getTrees(LinkedList<Integer> intArray,TreeNode tNode,int n){

        for (int i = 0; i < n; i++) {
            if(tNode.val==0){
                tNode.val=intArray.remove(i);
                getTrees(intArray,tNode,n-1);
                intArray.add(i,tNode.val);
                tNode.val=0;
            }

            int flag=intArray.pop();
            TreeNode tempNode=tNode;

            while (tempNode!=null){
                if(flag>tempNode.val){
                    if(tempNode.right==null){
                        tempNode.right=new TreeNode(flag);
                        break;
                    }
                    tempNode=tempNode.right;
                }else {
                    if(tempNode.left==null){
                        tempNode.left=new TreeNode(flag);
                        break;
                    }
                    tempNode=tempNode.left;
                }
            }

            if(intArray.isEmpty()){
                result.add(tNode);
            }else {
                getTrees(intArray,tNode,n-1);
            }


            intArray.addFirst(flag);
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
