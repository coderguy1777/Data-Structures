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
    BSTNode<T> node;
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

    public void balance() {
        ArrayList<T> list = new ArrayList<T>();
        list = addAll(list, root);
        Collections.sort(list);
        root = null;

        curr = root;
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

    private ArrayList<String> printChecker(ArrayList<String> list, BSTNode<T> parent){
        String holder = "";
        for(int i = 0; i < parent.depth; i++) {
            holder += " ";
        }
        holder += "├─";
        holder += node.get();
        list.add(holder);
        if(node.left != null) {
            list = printChecker(list, node.left);
        }
        else if(parent.left == null && parent.right != null) {
            holder = "";
            for(int i =0; i < parent.depth + 1; i++) {
                holder += "├─ null";
                list.add(holder);
            }
        }
        if(parent.right != null) {
            list = printChecker(list, parent.right);
        }
        else if(parent.right == null && parent.left != null) {
            holder = "";
            for(int i = 0; i < parent.depth + 1; i++) {
                holder += '\t';
            }

            holder += "├─ null";
            list.add(holder);
        }
        return list;
    }

    public class BSTNode<T> {
        T value;
        BSTNode left;
        BSTNode right;
        public int depth = 0;
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
        if(parent.left != null){
            addAll(list, parent.left);
        }
        if(parent.right != null) {
            addAll(list, parent.right);
        }
        return list;
    }
}

