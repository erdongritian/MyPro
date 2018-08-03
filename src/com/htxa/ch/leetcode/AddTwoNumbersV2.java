package com.htxa.ch.leetcode;

/**
 * 该算法有长度限制，如果listnode过长，则结果错误。
 */
public class AddTwoNumbersV2 {


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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long resultInt=convertNode(l1)+convertNode(l2);
        ListNode result=new ListNode((int)(resultInt%10));
        ListNode parentNode=result;

        while (resultInt/10!=0){
            resultInt=resultInt/10;
            ListNode listNode=new ListNode((int) (resultInt%10));
            parentNode.next=listNode;
            parentNode=listNode;
        }
        return result;
    }

    public long convertNode(ListNode l1){
        long i=0;
        long count=1;
        while (l1!=null){
            i=i+l1.val*count;
            count=count*10;
            l1=l1.next;
        }
        return i;
    }



    public static void main(String[] args) {
        AddTwoNumbersV2 addTwoNumbers=new AddTwoNumbersV2();
        addTwoNumbers.test();
    }

    private void test(){
        ListNode l1=new ListNode(9);
        ListNode l2=new ListNode(1);
        l2.next=new ListNode(9);
        l2.next.next=new ListNode(9);
        l2.next.next.next=new ListNode(9);
        l2.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next=new ListNode(9);
        l2.next.next.next.next.next.next.next.next.next=new ListNode(9);

        System.out.println(addTwoNumbers(l1,l2));

//        System.out.println(convertNode(l2));



    }


}
