import java.util.Scanner;
import java.io.*;
public class SuperDuperCadafraglisticNodeFun {
    /*
     * The Main method of this Program when called goes into the file
     * (nums.txt), and begins to grab integers and pulls them out. Then
     * once that is done, the nodes are set up, then from there makes all '
     * the ints stored into nodes, and has them take on values of those
     * nodes, with the linked list being setup with the haha node pointing at
     * lolz node, and then the return value being the printed array, but
     * now in the form of a linked list.
     */
    public static void main(String [] args) {
        try {
            Scanner scan;
            scan = new Scanner(new BufferedReader(new FileReader("nums.txt")));
            Node lolz = new Node(scan.next());
            Node haha = lolz;
            while(scan.hasNext()) {
                lolz.setNext(new Node(scan.next()));
                lolz = lolz.getNext();
            }
            while(haha.getNext() != null) {
                System.out.print(haha.get() + " ");
                haha = haha.getNext();
            }
            System.out.print(haha.get() + " ");
        } catch (Exception e) {
            System.out.println("is.");
        }
    }
}