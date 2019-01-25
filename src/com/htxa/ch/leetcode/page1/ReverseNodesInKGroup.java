package com.htxa.ch.leetcode.page1;

public class ReverseNodesInKGroup {

    public static void main(String[] args) {

        ReverseNodesInKGroup reverseNodesInKGroup=new ReverseNodesInKGroup();
        ListNode listNode=new ListNode(1);
        ListNode listNode2=new ListNode(2);
        listNode.next=listNode2;

//        ListNode listNode3=new ListNode(3);
//        listNode2.next=listNode3;
//
//        ListNode listNode4=new ListNode(4);
//        listNode3.next=listNode4;
//
//        ListNode listNode5=new ListNode(5);
//        listNode4.next=listNode5;

        ListNode k=reverseKGroup(listNode,2);
        System.out.println(k);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if(head==null||k==1){
            return head;
        }

        int[] temp=new int[k];

        ListNode node=head;
        for (int i = 0; i < k; i++) {
            temp[i]=head.val;
            head=head.next;
            if (head == null&&i<k-1) {
                return node;
            }
        }

        ListNode tNode=node;
        for (int i = k-1; i > -1; i--) {
            tNode.val=temp[i];
            tNode=tNode.next;
        }
        if(tNode!=null){
            reverseKGroup(tNode,k);
        }

        return node;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
