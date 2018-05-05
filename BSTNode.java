/*
 * A BST Node Class that works with BST Nodes.
 * By Jordan Hill
 * 4/17/2018
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