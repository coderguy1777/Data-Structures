public class Node {
   /*
    * nodes usually store an integer value of some sort. 
    * You are allowed to refer to an instance of a class within itself.
    * next within this code is not a keyword, but rather a pointer to another node.
    * 
    * 
    */
   int value;
   Node next;
   
   public int get() { return value;}
   public int set(int v) {value = v;}
   public Node getNext() { return next; }
   public int setNext (Node n) {next = n;}
   
}