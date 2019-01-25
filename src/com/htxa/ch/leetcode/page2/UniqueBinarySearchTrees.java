package com.htxa.ch.leetcode.page2;


import java.util.*;


public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        UniqueBinarySearchTrees t=new UniqueBinarySearchTrees();
        t.numTrees(11);
        System.out.println(t.totle);
    }


    int totle=0;
    public int numTrees(int n) {
        if(n==1)return 1;
        LinkedList<Integer> intArray=new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            intArray.add(i);
        }
        getTrees(intArray,new TreeNode(0),n);
        return totle;
    }

    private void getTrees(LinkedList<Integer> intArray,TreeNode tNode,int n){

        for (int i = 0; i < n; i++) {
            if(tNode.val==0){
                tNode.val=intArray.remove(i);
                getTrees(intArray,tNode,n-1);
                intArray.add(i,tNode.val);
                tNode.val=0;
                continue;
            }

            int flag=intArray.pop();
            TreeNode tempNode=tNode;
            boolean isLeft=true;

            while (tempNode!=null){
                if(flag>tempNode.val){
                    if(tempNode.right==null){
                        tempNode.right=new TreeNode(flag);
                        isLeft=false;
                        break;
                    }
                    tempNode=tempNode.right;
                }else {
                    if(tempNode.left==null){
                        tempNode.left=new TreeNode(flag);
                        isLeft=true;
                        break;
                    }
                    tempNode=tempNode.left;
                }
            }

            if(intArray.isEmpty()){
                if(isHas(tNode)){
                    totle++;
                }
            }else {
                getTrees(intArray,tNode,n-1);
            }
            if(isLeft){
                tempNode.left=null;
            }else {
                tempNode.right=null;
            }

            intArray.addLast(flag);
        }

    }

    Set<String> haveSet=new HashSet<>();
    private boolean isHas(TreeNode treeNode){
        nodeStrBuilder=new StringBuilder();
        preOrder(treeNode);
        return haveSet.add(nodeStrBuilder.toString());
    }

    StringBuilder nodeStrBuilder;
    private void preOrder(TreeNode treeNode){
        if (treeNode!=null){
            nodeStrBuilder.append(treeNode.val);
            if(treeNode.left!=null){
                preOrder(treeNode.left);
            }
            if(treeNode.right!=null){
                preOrder(treeNode.right);
            }
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
