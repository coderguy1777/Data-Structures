/*
 * A Program that searches through an array of numbers and puts them in order via a binary search 
 * tree.
 * By @Jordan Hill
 * Period: C
 * 4/23/18
 */

import java.io.*;
import java.util.Scanner;
import java.util.*;
public class BSTprojectDS<T extends Comparable<T>> {
    BSTNode<T> root;
    BSTNode<T> curr;
    BSTNode<T> parent; 
    public BSTprojectDS() {
        root = null;
    }

    public BSTprojectDS(T n) {
        root.set(n);
    }

    public void insert(T insertMe) {
        if (root == null) {
            root = new BSTNode();
            root.set(insertMe);
        } else {
            insert_re(root, insertMe);
        }
    }

    public void printTree(T print){
        ArrayList<String> list = new ArrayList<String>();
        for(String a : list){
            System.out.println(a);
        }

    }

    public void balance(T balance) {
        ArrayList<T> list = new ArrayList<T>();
        list = addAll(list, root);
        if(list != null) {
            addAll(list, root);
            ArrayList<T> balancer = new ArrayList<T>();
            balancer = addAll(list, curr);
            if(balancer != null) {
                ArrayList<T> Total = new ArrayList<T>();
                Total = addAll(balancer, root);
                System.out.println(Total);
                while(balancer != null && list != null) {
                    System.out.println("These Numbers cannot be compared.");
                    break;
                }
            }
        }
    }

    private void insert_re(BSTNode n, T ins) {
        if (n.getc().compareTo(ins) > 0) {
            if (n.getLeft() == null) {
                n.setLeft(new BSTNode());
                n = n.getLeft();
                n.set(ins);
            } else {
                insert_re(n.getLeft(),ins);
            }
        } else {
            if (n.getRight() == null) {
                n.setRight(new BSTNode());
                n = n.getRight();
                n.set(ins);
            } else {
                insert_re(n.getRight(),ins);
            }

        }
    }

    public void inOrderPrint() {
        inOrderPrint_re(root);
    }

    private void inOrderPrint_re(BSTNode n) {
        if (n == null) { return; }
        inOrderPrint_re(n.getLeft());
        System.out.println(n.get());
        inOrderPrint_re(n.getRight());
    }

    public boolean exists(T checkMe) {
        BSTNode curr = root;
        while (curr != null) {
            if (curr.getc().compareTo(checkMe) == 0) {
                return true;
            } else if (curr.getc().compareTo(checkMe) > 0) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
        }
        return false;
    }

    public class BSTNode<T> {
        T value;
        BSTNode left;
        BSTNode right;
        public T get() { return value; }

        public Comparable getc() { return (Comparable) value; }

        public void set (T val) { value = val; }

        public BSTNode getLeft() { return left; }

        public void setLeft(BSTNode par) { left = par; }

        public BSTNode getRight() { return right; }

        public void setRight(BSTNode par) { right = par; }
    }

    private ArrayList<T> addAll(ArrayList<T> list, BSTNode<T> node) {
        list.add(node.get());
        if(node.left != null){
            addAll(list, node.left);
        }
        if(node.right != null) {
            addAll(list, node.right);
        }
        return list;
    }
}

