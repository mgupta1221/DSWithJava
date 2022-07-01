package GettingStartedBasics.BinaryTree;

// Question Leetcode 572 : 
// With Approach 1 : 
// https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
// Note: Solution is not working here, but executed fine on Leetcode

// Approach 2(Optimized) is in separate file

public class FindTreeIsSubtreeOfOther_Approach1 {

    // assuming root2 is the subtree to be checked and root1 is main tree
    private static boolean isSubTree(Node root1, Node root2) {

        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }

        // if trees comes identical than return , ELSE check for left and right children
        if (isTreeIdentical(root1, root2) == true) {
            return true;
        }

        return isSubTree(root1.left, root2)
                || isSubTree(root1.right, root2);

    }

    private static boolean isTreeIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.val == root2.val
                && isTreeIdentical(root1.left, root2.left)
                && isTreeIdentical(root1.right, root2.right);

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