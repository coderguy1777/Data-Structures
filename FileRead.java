
import java.util.Scanner;
import java.io.*;
public class FileRead {
    public static void main(String [] args) {
        try {
            Scanner scan; 
            scan = new Scanner(new BufferedReader(new FileReader("nums.txt")));
            
            Node head = new Node(scan.nextInt());
            Node curr = head;
            while(file.hasNext()) {
                curr.setNext(new Node(scan.nextInt()));
                curr = curr.getNext();
            }
            curr = head;
            while(curr != null) {
                System.out.println(curr.get());
                curr = curr.getNext();
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
/*
 * inside of a try block if anything happens, such as an exception, like file not found, unexpected file format.
 * If that happens, the Exception is used by java.
 * e.getMessage()) will print the problem with the Exception, such as file not found.
 * e.printStackTrace() will point out mumbo jumbo and where the Exception is on a line of code
 * To start a linked list when scanning the file, a head is needed. 
 * file.nextInt() will be responsible for storing a number from the file, and then printing out the first number
 * from the file in the stored node. 
 * while(file.hasNext()) will return with stuff until you are at the end of the file in the loop
 * curr.setNext will read the next number and continue to read the file and store a numbere in that Node. 
 * curr = head; with this file will print it until it ends, and loop again.
 */