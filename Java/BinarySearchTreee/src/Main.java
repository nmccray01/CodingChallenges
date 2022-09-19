public class Main {

    public static void main(String[] args){
        int[] arr = {4, 7, 1, 8, 12, 5, 11, 2, 9};
        BinarySearchTree tree = new BinarySearchTree(arr);
        tree.printBST();
        System.out.println("\n" + tree.isBalanced());
        tree.balanceBST();
        System.out.println(tree.isBalanced());
    }


}
