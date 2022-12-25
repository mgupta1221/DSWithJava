package StriverSheet.Day19;

import java.util.HashMap;

public class CreateTreeFrom_In_And_PreOrder {

    // Problem: LC 105
    // https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

    // Solution video: https://www.youtube.com/watch?v=0r_cx1c8Z1A
    // (This video is of Post Order but same logic is for Pre-Order too )
    // Listen from : 5:32

    // Approach:
    // IMPORTANT : [REFER the image CreateTreeFromGivenTraversals.png]
    // Step 1: We create root from first node of preOrder and need to define its
    // Left and Right node
    // Step 2: For left - We first find the index of root node in InOrder becuase we
    // already know that everything on the left will form the left subtree of the
    // root.
    // We have to define the new 'InOrder' and 'PreOrder' array for this new left
    // node to be passed to the recursive call as indexes ('start' and 'end' index
    // of both 'InOrder' and 'PreOrder' for this left node)

    // Step 3: To Define InOrder and PreOrder array -
    // For LEFT child:
    // a) For defining InOrder array indexes for Left child - it is from
    // 'StartInOrderIndex' till (rootIndex-1) -
    // Note : This step is same for PreOrder and PostOrder solution both

    // b) For defining PreOrder indexes for Left child (For '9' in the given
    // example) - it is from
    // 'StartPreOrderIndex+1' till (all elements to the left of rootIndex in
    // InOrder)
    // i.e. (StartPreOrderIndex + (rootIndex-StartInOrderIndex) ,

    // NOW for RIGHT Child:
    // c) For defining InOrder for Right child - it is from '(rootIndex + 1)' till
    // (EndInOrderIndex),
    // b) For defining PostOrder for Right child - it is from
    // 'StartPreOrderIndex + (rootIndex-StartInOrderIndex) + 1' till
    // EndPreOrderIndex ,

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = buildTreeHelper(preorder, inorder, map, 0, inorder.length - 1, 0, preorder.length - 1);
        return root;
    }

    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder, HashMap<Integer, Integer> map,
            int startIn, int endIn, int startPre, int endPre) {
        if (startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);

        int rootIndex = map.get(root.val);
        int leftTreeSize = rootIndex - startIn;

        root.left = buildTreeHelper(preorder, inorder, map, startIn, rootIndex - 1, startPre + 1,
                startPre + leftTreeSize);
        root.right = buildTreeHelper(preorder, inorder, map, rootIndex + 1, endIn, startPre + leftTreeSize + 1, endPre);

        return root;

    }

    public static void main(String[] args) {

        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = buildTree(preorder, inorder);
        TreeNode.PrintTree(root);

    }

}
