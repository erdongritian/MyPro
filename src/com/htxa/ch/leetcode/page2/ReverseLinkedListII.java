package com.htxa.ch.leetcode.page2;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        int[] valArrays=new int[n-m+1];
        int arrayIndex=0;
        ListNode point=head;

        for (int i = 0; i < n; i++) {
            if(i>=m-1){
                valArrays[arrayIndex]=point.val;
                arrayIndex++;
            }
            point=point.next;
        }

        point=head;

        for (int i = 0; i < n; i++) {
            if(i>=m-1){
                arrayIndex--;
                point.val=valArrays[arrayIndex];
            }
            point=point.next;
        }

        return head;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
