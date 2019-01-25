package com.htxa.ch.leetcode.page1;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode currentNode=head;
        ListNode nextNode=head.next;

        while (nextNode != null) {
            int temp=nextNode.val;
            nextNode.val=currentNode.val;
            currentNode.val=temp;

            currentNode=nextNode.next;
            if(currentNode!=null){
                nextNode=currentNode.next;
            }else {
                break;
            }
        }
        return head;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


