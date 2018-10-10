package com.htxa.ch.leetcode.page1;

public class MergeTwoSortedListsV2 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode result = new ListNode(0);
        ListNode parentNode = result;

        while (true) {
            if (l1 == null) {
                if (l2 != null) {
                    parentNode.next = l2;
                }
                return result.next;
            } else if (l2 == null) {
                if (l1 != null) {
                    parentNode.next = l1;
                }
                return result.next;
            } else if (l1.val < l2.val) {
                ListNode listNode = new ListNode(l1.val);
                parentNode.next = listNode;
                parentNode = listNode;
                l1 = l1.next;
            } else {
                ListNode listNode = new ListNode(l2.val);
                parentNode.next = listNode;
                parentNode = listNode;
                l2 = l2.next;
            }
        }
    }

    //递归实现：http://www.ciaoshen.com/algorithm/leetcode/2017/03/31/leetcode-merge-two-sorted-list.html
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) { return l2; }
//        if (l2 == null) { return l1; }
//        if (l1.val <= l2.val) {
//            l1.next = mergeTwoLists(l1.next,l2);
//            return l1;
//        } else {
//            l2.next = mergeTwoLists(l1,l2.next);
//            return l2;
//        }
//    }





}

//class ListNode {
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//    }
//}
