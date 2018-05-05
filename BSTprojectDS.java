/*
 * A Program that reads a series of Nodes from a class that then sorts them
 * it into a BST Tree, and then divides it into two halves, via two Traversals
 * through the tree and uses in order print to do so. 
 * By @Jordan Hill
 * Period: C
 */
import java.io.*;
import java.util.*;
public class BSTprojectDS<T extends Comparable<T>> {
    //Nodes the BST uses to sort itself. 
    BSTNode<T> root;
    BSTNode<T> parent;
    BSTNode<T> curr;
    
    /*
     * This here is the Main BSTNode<T> class
     * that the BST uses to sort the tree when the 
     * BST Tree itself is traversed. 
     */
    public class BSTNode <T extends Comparable<T>>{
        T value;
        public BSTNode(T n) {
            value = n;
        }

        public BSTNode() {
            value = null;
        }

        public T get() { return value; }

        public void set(T n) { value = n; }

        public BSTNode right = null;
        public BSTNode left = null;
        public BSTNode parent = null;
        public int position = 0;
    }
    
    /*
     * The First Parameter of this method is checking the Node element that it is about to insert
     * The Second Parameter of this method is inserting the Node into the BST TRee
     * The Return value of this method is the value declared at the start of the method in the (), n
     * inserts that into the BST Tree. 
     */
    public void insert(T n) {
        if(root == null) {
            root = new BSTNode<T>(n);
        }
        else {
            curr = root;
            insert_re(n);
        }
    }
    
    /*
     * This Method makes the BST Tree Perfectly Balanced once it is sorted. 
     */
    public void balance() {
        ArrayList<T> list = new ArrayList<T>();
        list = addAll(list, root);
        Collections.sort(list);
        root = null;
        balance_re(list);
        curr = root;
    }
    
    /*
     * The First parameter of this method is making an arraylist to store the nodes in from the sorted nodes that came
     * from the BSTInsert class 
     * The Second Parameter of this method is putting the ArrayList of Nodes that are sorted into the right spots by using strings. 
     * The Return Value of this method is the printed out BST Tree sorted and balanced. 
     */

    public void printTree() {
        ArrayList<String> list = new ArrayList<String>();
        list = printTree_re(list, root);
        for(String spot : list)  {
            System.out.println(spot);
        }
    }
    
    /*
     * This Method helps format the tree as well, by using spaces to place null parts of the tree spaced out, and 
     * not interfering with the formating of the main BST Tree. 
     */
    private String inOrderprintTree_re(String parent, BSTNode n) {
        if(n.left != null) {
            parent += inOrderprintTree_re("", n.left);
        }
        parent = parent + n.get() + '\t';
        if(n.right != null) {
            parent += inOrderprintTree_re("", n.right);
        }
        return parent;
    }
    
    /*
     * This Method works along side the first Exists method, but is privated so it only checks for the 
     * existance of the node, and adds "Null" to the spots on the tree where it equals it and makes it null,
     * and if it doesn't, puts in the Node checked into the spot on the main BST Tree. 
     */
    private boolean exists_re(T n, BSTNode<T> checkMe) {
        boolean existance = false;
        if(checkMe == null) {
            existance = false;
        }
        else if(checkMe.get().compareTo(n) == 0) {
            existance = true;
        }
        else if(checkMe.get().compareTo(n) < 0) {
            existance = exists_re(n, checkMe.right);
        }
        else if(checkMe.get().compareTo(n) > 0) {
            existance = exists_re(n, checkMe.left);
        }
        return existance;
    }
    
    /*
     * Another Insert Method used for putting in the nodes, via Curr, and moving down until the BSTInsert Class has been sorted
     * and all the Nodes are int he proper position using the BSTNode curr to do so, and mainly helps with inserted the Nodes into the BST 
     * properly and sorted properly also to prevent any exceptions with null due to improper placement of the Node within the BST itself. 
     */
    private void insert_re(T n) {
        if(n.compareTo(curr.value) < 0) {
            if(curr.left == null) {
                curr.left = new BSTNode<T>(n);
                curr.left.position = curr.position + 1;
                curr.left.parent = curr; 
            } else {
                curr = curr.left;
                insert_re(n);
            }

        } else if(n.compareTo(curr.value) > 0) {
            if(curr.right == null) {
                curr.right = new BSTNode<T>(n);
                curr.right.position = curr.position + 1;
                curr.right.parent = curr;
            } else {
                curr = curr.right;
                insert_re(n);
            }
        }
    }
    
    /*
     * A Recursive method that helps balance the BST Tree into two halves that are one BST Tree as a whole, but are 
     * divided into the two halves as specified in the project description via recursion in this case. 
     */
    private void balance_re(List<T> list) {
        if(list.size() >= 3) {
            insert(list.get(list.size() / 2));
            balance_re(list.subList(0, list.size() / 2));
            balance_re(list.subList(list.size() / 2 + 1, list.size()));
        }
        else if(list.size() == 2) {
            Collections.sort(list);
            insert(list.get(0));
            insert(list.get(1));
        }
        else if(list.size() == 1) {
            insert(list.get(0));
        }
    }
    
    /*
     * This method here is the backbone of the print method, and adds -- to signify branches, along
     * with formatting the tree when it is printed in the terminal window. 
     */
    private ArrayList<String> printTree_re(ArrayList<String> sublist, BSTNode<T> branch) {
        String Holder = "";
        for(int n = 0; n < branch.position; n++) {
            Holder += " "; 
        }
        Holder += "-- ";
        Holder += branch.get();
        sublist.add(Holder);
        if(branch.left != null) {
            sublist = printTree_re(sublist, branch.left);
        }
        else if(branch.left == null && branch.right != null) {
            Holder = "";
            for(int n = 0; n < branch.position + 1; n++) {
                Holder += '\t';
            }
            Holder += "-- null";
            sublist.add(Holder);
        }

        if(branch.right != null)  {
            sublist = printTree_re(sublist, branch.right);
        } else if(branch.right == null && branch.left != null) {
            Holder = "";
        }

        for(int n = 0; n < branch.position + 1; n++) {
            Holder += '\t';
        }
        Holder += "-- null";
        sublist.add(Holder);
        return sublist;
    }
    
    /*
     * This Method here makes sure that the left nodes of the left branches of the BST Tree, 
     * along with the right, don't get printed as Null for certain parts of the BST tree, where they
     * are not equal to null. 
     */
    private ArrayList<T> addAll(ArrayList<T> list, BSTNode<T> parent) {
        list.add(parent.get());
        if(parent.left != null) {
            addAll(list, parent.left);
        }

        if(parent.right != null) {
            addAll(list, parent.right);
        }
        return list;
    }
    
    //Some basic elements to help format the BST Tree
    public BSTprojectDS() {
        root = null;
    }
    
    //Same as the element commented above. 
    public BSTprojectDS(T n) {
        root.set(n);
    }
    
    /*
     * The First parameter of this method is checking for the existance of a node to use in the BST.
     * The Second Parameter of this Method is Checking for the existance of that Specific node. 
     * The Return value of this method is whether or not the node exists or not within the BST. 
     */
    public boolean exists(T checkMe) {
        return exists_re(checkMe, root);
    }
    
    /*
     * The First parameter of this method is for the tree to be set to be traversed before printing
     * The Second Parameter of this method is traversing the tree via inorderprint.
     * The Return value of this method is the tree printed with the use of inorderprint. 
     */
    public void inOrderPrint() {
        System.out.print(inOrderprintTree_re("\t", root));
    }

}