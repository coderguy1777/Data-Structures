/*
 * Program by @Jordan Hill
 * This Program is called InfiniteAdder, and takes two numbers 
 * from two seperate .txt files, the first one being num1 and the second
 * being num2. It then adds these two numbers of these .txt from the 
 * linked lists they were in, and then adds them into a doubly linked list, 
 * and prints out the end result.
 */

import java.io.*;
import java.util.Scanner;
public class InfiniteAdder {
    /*
     * The First Parameter of this method is to scan the file and use scan1 and scan2 to find the files num1 and num2.
     * The Second Parameter of this method is those files being read by the serious of Digits head, and head2, and goes through both before doing the return value. 
     * Once the Program goes through both linked lists, it adds them together, and that makes the return value a doubly linked list and adds both of the numbers
     * from both .txt files within that list, and making the return value of this method, the doubly linked list with both .txt files added together. 
     */
    public static void main (String[]args) {
        try{
            Scanner scan1;
            Scanner scan2;
            scan1 = new Scanner(new BufferedReader(new FileReader("num1.txt")));
            scan2 = new Scanner(new BufferedReader(new FileReader("num2.txt")));
            
            Digit head = new Digit();
            head.setDigit(scan1.nextInt());
            Digit curr = head;
            Digit prev = curr;
            
            Digit head2 = new Digit();
            head2.setDigit(scan2.nextInt());
            Digit curr2 = head2;
            Digit prev2 = curr2;
            
            while(scan1.hasNext()) {
                curr.setNext(new Digit());
                curr = curr.getNext();
                curr.setDigit(scan1.nextInt());
                curr.setPrev(prev);
                prev = curr; 
            }
            
            Digit tail = curr;
            
            while(scan2.hasNext()) {
                curr2.setNext(new Digit());
                curr2 = curr2.getNext();
                curr2.setDigit(scan2.nextInt());
                curr2.setPrev(prev2);
                prev2 = curr2; 
            }
            Digit tail2 = curr2;
            
            curr = head;
            curr2 = head2;
            
            while(curr != null && curr2 != null) {
                System.out.println(curr.getDigit() + curr2.getDigit());
                curr = curr.getNext();
                curr2 = curr2.getNext();
            }
            
        } catch (IOException e) {
            System.out.print(e);
            System.exit(0);
        }
    }
}