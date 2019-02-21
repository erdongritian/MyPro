package com.htxa.ch.leetcode.page2;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode point=head;
        ListNode preNode=null;
        boolean isRepeat=false;

        while (point!=null&&point.next != null) {
            while (point.next != null&&point.val==point.next.val) {
                point.next=point.next.next;
                isRepeat=true;
            }

            if(isRepeat){
                if(preNode!=null){
                    preNode.next=point.next;
                }else {
                    head=point.next;
                }
                point=point.next;
                isRepeat=false;
            }else {
                preNode=point;
                point=point.next;
            }
        }
        return head;

    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
