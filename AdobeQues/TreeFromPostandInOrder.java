package AdobeQues;

import java.util.HashMap;

// Leet code 105
// Solution video:
// https://www.youtube.com/watch?v=FBpQEQkQ1No

// Approach:
// PreOrder start with root than go left and than right
// so we can get the root from PreOrder array

// Now if we see InOrder array, all left subtree elements of root will on the
// left side of the root in the InOrder array and all right subtree elements
// will be
// on the right side of the root element E.g. 3 is the root [9] is on the left
// side of 3 and [15,20, 7] are on the
// right side in InOrder array

// So using this approach, we will get all roots from the PreOrder array and
// left and right subtree from InOrder array recursively.
// We will use 'start' and 'end' variable to populate left and right nodes of
// root node recursively.

// strat and end belongs to Inorder array

public class TreeFromPostandInOrder {
    static int postIndex = 0;

    static HashMap<Integer, Integer> map = new HashMap<>();

    public static TNode buildTree(int in[], int post[], int n) {
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        postIndex = post.length - 1;
        return buildTreeHelper(in, post, 0, in.length - 1);
    }

    public static TNode buildTreeHelper(int[] in, int post[], int start, int end) {
        if (start > end)
            return null;

        TNode parent = new TNode(post[postIndex--], null, null);

        // if this node has no children than return- start and end are equal means Leaf
        // node
        if (start == end) {
            return parent;
        }

        int nodeIndex = map.get(parent.val);

        // THIS IS IMPORTANT- YOU HAVE TO POPULATE RIGHT NODE FIRST. If PreOrder would
        // have been given in ques , we will populate Left child first
        parent.right = buildTreeHelper(in, post, nodeIndex + 1, end);
        parent.left = buildTreeHelper(in, post, start, nodeIndex - 1);

        return parent;
    }

    public static void main(String[] args) {
        int[] postorder = { 9, 15, 7, 20, 3 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TNode root = buildTree(inorder, postorder, inorder.length);

        // validating the result
        PrintTreeInPostOrder(root);

    }

    private static void PrintTreeInPostOrder(TNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            PrintTreeInPostOrder(root.left);
        }
        if (root.right != null) {
            PrintTreeInPostOrder(root.right);
        }
        System.out.print(root.val + " -> ");

    }
}
