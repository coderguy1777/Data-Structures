import java.io.*;
import java.util.Scanner;
/*
 * Stack Class
 * By @Jordan Hill
 * Period: C
 * 2/21/18
 */
public class Stack  {
    Node topnode = new Node(0);

    public void push(Node ayy) {
        ayy.setNext(topnode);
        topnode = ayy;
    }
    public Node hat() {
        if(topnode == null) {
            return null;
        }
        Node bottom = topnode;
        topnode = topnode.getNext();
        bottom.setNext(null);
        return bottom;
    }
    public Node ayyy() {
        return topnode;
    }
}

       