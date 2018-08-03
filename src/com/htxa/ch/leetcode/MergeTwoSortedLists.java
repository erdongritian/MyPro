package com.htxa.ch.leetcode;

public class MergeTwoSortedLists {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result=null;
        ListNode parentNode=null;
        if (l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }

        while (true){
            if(l1==null){
                if(l2==null){
                    return result;
                }else {
                    while (l2!=null){
                        ListNode listNode=new ListNode(l2.val);
                        parentNode.next=listNode;
                        parentNode=listNode;
                        l2=l2.next;
                    }
                    return result;
                }
            }else if(l2==null){
                if(l1==null){
                    return result;
                }else {
                    while (l1!=null){
                        ListNode listNode=new ListNode(l1.val);
                        parentNode.next=listNode;
                        parentNode=listNode;
                        l1=l1.next;
                    }
                    return result;
                }
            }else if(l1.val<l2.val){
                if(result==null){
                    result=new ListNode(l1.val);
                    parentNode=result;
                }else {
                    ListNode listNode=new ListNode(l1.val);
                    parentNode.next=listNode;
                    parentNode=listNode;
                }
                l1=l1.next;
            }else {
                if(result==null){
                    result=new ListNode(l2.val);
                    parentNode=result;
                }else {
                    ListNode listNode=new ListNode(l2.val);
                    parentNode.next=listNode;
                    parentNode=listNode;
                }
                l2=l2.next;
            }
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
