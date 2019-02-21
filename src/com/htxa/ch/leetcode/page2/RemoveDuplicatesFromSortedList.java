package com.htxa.ch.leetcode.page2;

public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        int current=head.val;
        ListNode point=head;
        while (point.next != null) {
            if(current==point.next.val){
                point.next=point.next.next;
            }else {
                current=point.next.val;
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
