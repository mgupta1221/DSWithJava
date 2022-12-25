package StriverSheet.Day19;

import java.util.HashMap;

public class CreateTreeFrom_In_And_PostOrder {

    // Problem: LC 106
    // https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

    // Youutube Explanation:: See from : 5:32 minutes
    // https://www.youtube.com/watch?v=0r_cx1c8Z1A

    // Approach:
    // IMPORTANT : [REFER the image CreateTreeFromGivenTraversals.png]
    // Step 1: We create root from last node of postOrder and need to define its
    // Left and Right node
    // Step 2: For left - We first find the index of root node in InOrder becuase we
    // already know that everything on the left will form the left subtree of the
    // root. We have to define the new 'InOrder' and 'PostOrder' array for this left
    // node to be passed to the recursive call as indexes ('start' and 'end' index
    // of both 'InOrder' and 'PostOrder' for this left node)

    // Step 3: To Define InOrder and PostOrder array -
    // For LEFT child
    // a) For defining InOrder for Left child - it is from
    // 'StartInOrderIndex' till (rootIndex-1)
    // b) For defining PostOrder for Left child - it is from
    // 'StartPostOrderIndex' till (StartPostOrderIndex +
    // (rootIndex-StartInOrderIndex) - 1 ,

    // NOW for RIGHT Child
    // c) For defining InOrder for Right child - it is from '(rootIndex + 1)' till
    // (EndInOrderIndex), and
    // b) For defining PostOrder for Right child - it is from
    // 'StartPostOrderIndex + (rootIndex-StartInOrderIndex)' till
    // EndPostOrderIndex - 1 ,

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
        return root;

    }

    public static TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart,
            int postEnd, HashMap<Integer, Integer> map) {
        if (inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);

        int rootIndex = map.get(root.val);
        int leftTreeSize = rootIndex - inStart;

        root.left = buildTreeHelper(postorder, inorder, inStart, rootIndex - 1, postStart, postStart + leftTreeSize - 1,
                map);

        root.right = buildTreeHelper(postorder, inorder, rootIndex + 1, inEnd, postStart + leftTreeSize, postEnd - 1,
                map);
        return root;

    }

    public static void main(String[] args) {
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        TreeNode root = buildTree(inorder, postorder);
        TreeNode.PrintTree(root);

    }

}
