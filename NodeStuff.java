public class NodeStuff {
   public static void main(String[]args) {
       Node head = new Node();
       head.set(3);
       
       head.setNext(new Node());
       head.getNext().set(7);
       
       Node curr = head;
       curr = curr.getNext();
       curr.setNext(new Node());
       curr = curr.getNext();
       curr.set(10);
       
       
       curr = head;
       while(curr.get() != 7) {
           curr = curr.getNext();
    }
    
    Node insert = new Node();
    insert.set(13);
    insert.setNext(curr.getNext());
    curr.setNext(insert);
    

}
}

/*
 * Node head is set to 3 as the value it stores when this code runs. 
 * This code works by head pointing at a new node.
 * What head points to is the set number, which is three, that is stored in the node. 
 * head.setNext sets the next value that is stored inside the node, mainly working as
 * being 3. , and then goes down and creates a new node that it is pointing to. 
 * head.getNext() is the value that the node head refers to from setNext, and getNext sets the value stored in the node
 * setNext is 7, getNext being what stores the integer value of that node. 
 * the Line Node curr, equals the same number that the node head is set to, because curr and head are the two
 * same pointers referring to the same node, making the value both set = 3
 * Curr.getNext cancels the path to the node Head is connected to, and curr.getNext makes the pointer 
 * curr refer to the Node head.getNext, which makes both values equal 7, as curr uses curr.getNext 
 * refers to the the node head.setNext, like head.getNext(), making both pointers equal to 7.
 * Using curr.getNext(), we can now make new nodes. 
 * curr.setnext make the node thatb stores 7 create a new node, and also cancels out curr pointing to 7
 * what it does now is it points to the node that was created by curr.set, which is 10. 
 * At the end of the chain of created nodes that contains all the pointers, the pointer will be equal to null. 
 * If the pointer does not point at anything, it will equal null, mainly because curr and head are not pointing at anything, and
 * the code now becomes a thing. 
 * This now becomes a linear list of nodes with the descending chain, this data structure is called, a linked list. 
 * Linked lists are useful in certain ways. 
 * curr = head loops the list, and goes back to the top of the chain, and starts the chain over the value of 3. 
 * curr.get will be printed 3, then curr.getNext will go through the list up to 10
 * when curr.getNext points to 10, it cannot move onto anything else since no new pointers are there,
 * therefore breaking the loop, and then just printing out null.
 * traversing the whole list is very easy to do with nodes within a linked list. 
 * when you set next to a new node, it creates a new node and sets the pointer to point to that new node. 
 * When the new loop finishes of while(curr.get != 7) is running, it runs up to 7, and the loop ends at 7 with 
 * the value of 7, and ends the loop and restarts the loop.
 * At the end of the loop, it points to the value of 7. 
 * the new node, insert.set(13);, points to the new node that is floating by itself, containing the stored number, 13
 * curr.getNext is the pointer pointing at the 7, and with the new line of code, insert.setNext, 13 now points at the ten
 * curr.setNext deletes the chain of 7 pointing to 10, and now 7 points at the node 13, and 13 
 * has now been inserted into the linked chain. 
 * Remember,"When i set a pointer equal to another pointer, it equals the same thing as they are both pointing at the same thing."
 */