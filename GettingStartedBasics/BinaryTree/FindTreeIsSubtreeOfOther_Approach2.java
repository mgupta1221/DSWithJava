package GettingStartedBasics.BinaryTree;

// Question Leetcode 572 : 
// With Approach 2 (Optimized): 
// https://www.geeksforgeeks.org/check-binary-tree-subtree-another-binary-tree-set-2/?ref=rp


public class FindTreeIsSubtreeOfOther_Approach2 {

    
    private static boolean isSubTree(Node root1, Node root2) {

      

    }

    private static boolean isTreeIdentical(Node root1, Node root2) {
      

    }

    public static void main(String[] args) {
        Node root1 = PopulateBinaryTree1(); // trees are same which are given in GFG link
        Node root2 = PopulateBinaryTree2();
        boolean result = isSubTree(root1, root2);
        System.out.println(result);
    }

    public static Node PopulateBinaryTree1() {
        Node root = new Node(10, null, null);
        Node child1 = new Node(4, null, null);
        Node child2 = new Node(6, null, null);
        Node child3 = new Node(30, null, null);

        root.left = child1;
        root.right = child2;
        child1.right = child3;

        return root;
    }

    public static Node PopulateBinaryTree2() {
        Node root = new Node(26, null, null);
        Node child1 = new Node(10, null, null);
        Node child2 = new Node(3, null, null);
        Node child3 = new Node(4, null, null);
        Node child4 = new Node(6, null, null);
        Node child5 = new Node(3, null, null);
        Node child6 = new Node(30, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child2.right = child5;
        child3.right = child6;

        return root;
    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}