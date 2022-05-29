package GettingStartedBasics.BinaryTree;

public class ConstructTreeFromPreOrder {

    // Leet code 1008
    // Solution Video: Codebix
    // 2 Approaches followed

    // Aproach 1: NOT passing on Leetcode
    // https://www.youtube.com/watch?v=W4kh0WsTHQ0

    // Aporach 2: PAssing on Leetcode
    // Code is little differnt becuase of Leetcode test cases but follow same
    // approach
    // Solution code:
    // https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/discuss/2034181/Java-or-Recursive-or-100-Faster-or-Easy-to-understand

    

    // Approach 1
    public static Node buildTree(int[] preorder) {

        // Apporach 1
        // Node root = buildTreeHelper_Approach1(preorder, 0, preorder.length);

        // Apporach 2:
        Node root = buildTreeHelper_approach2(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return root;
    }

    // Helper for Apporach 1
    public static Node buildTreeHelper_Approach1(int[] preorder, int start, int end) {
        // if start and end cross each other, return null
        if (start >= end) {
            return null;
        }
        // create root node with value as current value of 'start'
        Node root = new Node(preorder[start], null, null);

        // traverse preOrder array till you find a value which is greater than current
        // root node
        // because all values which are less than current root will form the left
        // subtree and greater ones will form node's right subtree
        int i = start;
        while (i <= preorder.length - 1 && root.val > preorder[i]) {
            i++;
        }

        // populate left and right subtree recursively
        root.left = buildTreeHelper_Approach1(preorder, start + 1, i - 1);
        root.right = buildTreeHelper_Approach1(preorder, i + 1, end);
        return root;
    }

    // Helper for Approach 2
    // Global variable
    static int i = 0;

    public static Node buildTreeHelper_approach2(int[] preorder, int minVal, int maxVal) {
        if (i == preorder.length
                || preorder[i] < minVal
                || preorder[i] > maxVal) {
            return null;
        }

       
        int val = preorder[i++];
        
        Node root = new Node(val, null, null);

        root.left = buildTreeHelper_approach2(preorder, minVal, val);
        root.right = buildTreeHelper_approach2(preorder, val, maxVal);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 8, 5, 1, 7, 10, 12 };
        Node root = buildTree(preorder);

        // validating the result
        PrintTreePreOrder(root);

    }

    private static void PrintTreePreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " -> ");
        if (root.left != null) {
            PrintTreePreOrder(root.left);
        }

        if (root.right != null) {
            PrintTreePreOrder(root.right);
        }

    }

    public static class Node {
        int val;
        Node left;
        Node right;

        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
