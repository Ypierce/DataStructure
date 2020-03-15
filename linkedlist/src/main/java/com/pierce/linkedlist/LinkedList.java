package com.pierce.linkedlist;

public class LinkedList<E> {

    private class Node{
        private E e;
        private Node next;

       public Node(E e,Node next){
           this.e = e;
           this.next = next;
       }

       public Node(E e){
           this(e,null);
       }

       public Node(){
           this(null, null);
       }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
       // return size == 0;
    }

/*    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;

        //head = new Node(e,head);
        size++;
    }*/

    public void add(int index,E e){
        if(index<0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
/*        if(index == 0){
            this.addFirst(e);
        }else{*/
        Node prev = dummyHead;
        for(int i = 0;i<index;i++){
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;

//            prev.next = new Node(e,prev.next);
        size++;

    }

    public void addFirst(E e){
        add(0,e);
    }

    public void addLast(E e){
        add(size,e);
    }

    public E get(int index){
        if(index<0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i = 0;i<size;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size);
    }


    public void set(int index,E e){
        if(index<0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        Node cur = dummyHead.next;
        for(int i =0;i< size;i++){
            cur = cur.next;
        }
        cur.e = e ;
    }

    public boolean contains(E e){
        Node cur = dummyHead.next;
        while (cur != null){
            if(e.equals(cur)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index){
        if(index<0 || index > size){
            throw new IllegalArgumentException("Add failed.Illegal index");
        }
        Node prev = dummyHead;
        for( int i =0;i<index;i++){
            prev = prev.next;
        }
        Node node = prev.next;
        prev.next = node.next;
        node.next = null;
        size--;
        return node.e;
    }

    public E removeFirst(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Node cur = dummyHead.next; cur!= null; cur = cur.next){
            builder.append(cur+"->");
        }
        builder.append("NULL");

        return builder.toString();
    }
}
