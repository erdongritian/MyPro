package com.htxa.ch.leetcode.page1;

public class AddTwoNumbers {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    int emp=0;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int val=emp;
        if(l1!=null){
            val=val+l1.val;
        }
        if(l2!=null){
            val=val+l2.val;
        }
        ListNode result=new ListNode(val%10);

        emp=val/10;
        if((l1!=null&&l1.next!=null)||(l2!=null&&l2.next!=null)||emp!=0){
            result.next=addTwoNumbers(l1==null?null:l1.next,l2==null?null:l2.next);
        }

        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers=new AddTwoNumbers();
        addTwoNumbers.test();
    }

    private void test(){
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(9);
        l2.next=new ListNode(9);
        System.out.println(addTwoNumbers(l1,l2));
    }


}
