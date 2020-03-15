package com.pierce.linkedlist;

public class RemoveElements {
    public static ListNode removeElements(ListNode head,int val){

        ListNode dumpHead = new ListNode(-1);
        dumpHead.next = head;
        ListNode prev =dumpHead;

        while(prev.next != null){
            if(prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;

            }else {
                prev = prev.next;
            }
        }
        return dumpHead.next;
    }

    public static void main(String[] args) {
        int[] num={1,2,6,3,4,5,6};
        ListNode head = new ListNode(num);

        System.out.println(head);

/*        ListNode listNode =RemoveElements.removeElements(head,6);
        System.out.println(listNode);*/


        ListNode listNode1 =RemoveElements.removeElementsRecursion(head,6);
        System.out.println(listNode1);

        System.out.println(reverse(head));
    }

    public static ListNode removeElementsRecursion(ListNode head,int val){
        if(head == null) return null;
/*        if(head.val == val){
            return  removeElementsRecursion(head.next,val);
        }else {
           head.next =  removeElementsRecursion(head.next,val);
            return head;
        }*/
        head.next = removeElementsRecursion(head.next,val);

        if(head.val == val){
            return head.next;
        }else {
            return head;
        }

    }

    public static ListNode reverse(ListNode head){
        if( head == null || head.next == null){
            return head;
        }
        ListNode res =reverse(head.next);

        head.next.next = head;
        head.next  = null;

        return res;
    }
}
