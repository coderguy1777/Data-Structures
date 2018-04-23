/*
 * A Program that searches through an array of numbers and puts them in order via a binary search 
 * tree.
 * By @Jordan Hill
 * Period: C
 * 4/23/18
 */
import java.io.*;
import java.util.Scanner;

public class BSTprojectDS <T> {
    int[][] BSTNodeArray = new int [10000][10000];
    BSTNode root;
    BSTNode curr;
    BSTNode prevL;
    BSTNode prevR;
    BSTNode parentL;
    BSTNode parentR;
    BSTNode Leftcurr;
    BSTNode Rightcurr;
    public void insert(T insertMe) {
        if (root == null) {
            root = new BSTNode();
            root.set(insertMe);
        } else {
            insert_re(root, insertMe);
        }
    }

    public void printTree(T print){
        Scanner scan; 
        scan = new Scanner(System.in);
        String Printer = scan.nextLine();
        BSTNode prev = curr;
        BSTNode prevL = curr;
        BSTNode prevR = curr;
        BSTNode parentL = prevL;
        BSTNode parentR = prevR;
        for(int currentnode = 0; currentnode < Printer.length(); currentnode++) {
            if(prevR.getc().compareTo(print)  != 0 && prevR.getc().compareTo(print) > 0) {
                System.out.println(prevL.getc());
                if(prevR.getc().compareTo(print) == 0 && prevR.getc().compareTo(print) < 0) {
                    System.out.println(prevR.getc());
                }
   
            
            }
        }
       
      
    }
    
    public static void BSTTree() {
        
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

    public class BSTNode {
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
}