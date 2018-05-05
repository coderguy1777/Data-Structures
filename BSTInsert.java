public class BSTInsert {
    public static void main(String[] args) {
        BSTprojectDS<Integer> bst = new BSTprojectDS<Integer>();
        bst.insert(0);
        bst.insert(9);
        bst.insert(8);
        bst.insert(2);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        bst.insert(1);
        bst.printTree();
        System.out.println(bst.exists(2));
        System.out.println(bst.exists(2));
        bst.balance();
        bst.printTree();
    }
}