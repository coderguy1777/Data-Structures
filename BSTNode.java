import java.util.Scanner;
import java.io.*;
public class BSTNode <T> {
    T value;
    BSTNode LeftNode;
    BSTNode RightNode;
    BSTNode currentNode;
    public BSTNode(T val) {
        value = val;
    }

    public T get() {
        return val;
    }

    public void set (T v) {
        value = v;
    }

    public BSTNode getLeft() {
        return LeftNode;
    }
    
    public BSTNode getRight() {
        return RightNode;
    }
    
    public void setLeft(BSTNode currentnode) {
        LeftNode = currentnode;
    }
    
    public void setRight(BSTNode currentnode) {
        RightNode = currentnode;
    }
    
    public Comparable getc() {
        return (Comparable) val;
    }
    public void inputgetc(){
        if(input.getc().compareTo(LeftNode.getc()) >= 0) {
            return LeftNode;
        }
        else if(input.getc().compareTo(RightNode.getc()) >= 0) {
            return RightNode;
        }
        else {
            return v;
        }
    }
    
}