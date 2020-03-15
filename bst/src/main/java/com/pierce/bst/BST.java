package com.pierce.bst;

import java.util.Stack;

public class BST <E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node right,left;

        public Node(E e){
            this.e = e;
            right = null;
            left = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size =0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
/*        if(root ==null){
            root = new Node(e);
            size++;
        }
        else {
            add(root,e);
        }*/
        root = add(root,e);
    }

    private Node add(Node node,E e){
/*        if(e.equals(node.e)){
            return;
        }else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }*/

        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) <0){
            node.left = add(node.left,e);
        }else if(e.compareTo(node.e) >0){
            node.right = add(node.right,e);
        }

        return node;
    }

    public boolean contains(E e){
        return contains(root,e);
    }
    private boolean contains(Node node,E e){
        if(node == null){
            return false;
        }
        if(e.equals(node.e)){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else{
            return contains(node.right, e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }
    public void preOrderNR(){
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();
            System.out.println(node.e);
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //二分搜索树释放内存
    private void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        inOrder(node.right);
        System.out.println(node.e);
    }
}
