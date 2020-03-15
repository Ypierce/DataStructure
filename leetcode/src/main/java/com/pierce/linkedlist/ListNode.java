package com.pierce.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int[] num){
        val = num[0];
        ListNode head = this;

        ListNode cur = head;
        for(int i= 1; i<num.length;i++){
            cur.next = new ListNode(num[i]);
            cur = cur.next;
        }
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        ListNode cur = this;
        while (cur != null){
            builder.append(cur.val+"->");
            cur = cur.next;
        }
        return builder.append("NUll").toString();
    }
}
