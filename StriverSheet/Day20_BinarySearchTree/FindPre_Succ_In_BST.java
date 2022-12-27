package StriverSheet.Day20_BinarySearchTree;
// Problem: https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
// Problem Statement:
// 1.  The predecessor of a node in BST is that node that will be visited just before the given node in the inorder traversal of the tree. If the given node is visited first in the inorder traversal, then its predecessor is NULL.
// 2. The successor of a node in BST is that node that will be visited immediately after the given node in the inorder traversal of the tree. If the given node is visited last in the inorder traversal, then its successor is NULL.

// As a result: Need to set the values in the below class 'Res'


// Read solution spproach than seeing the below GFG link:
// https://www.geeksforgeeks.org/inorder-predecessor-successor-given-key-bst/


// Approach: Do InOrder traversal - 
// In InOrder, root is at the middle of 2 recursive calls. We keep updating 'pre' and 'succ' in each call such that :
// 1) Update 'pre' (number just less than given 'key' in the tree) if root.data < key  
// 2) Update 'succ' (number just more than given 'key' in the tree) if root.data < key - But there will be one case to be additionally handled in succ
// If we keep updating it will go to the biggest node in the tree so we have to handle it.
// So we update only if [current coming root node < current 'succ' node] (becuase we have to find immediately bigger child than key)

class Res {
    TreeNode pre = null;
    TreeNode succ = null;
}

public class FindPre_Succ_In_BST {

    public static void findPreSuc(TreeNode root, Res p, Res s, int key) {
        if (root == null) {
            return;
        }
        findPreSuc(root.left, p, s, key);

        if (root != null && root.val < key) {// remember comparision is with root and not root.left (InOrder traversal)
            p.pre = new TreeNode(root.val);
        }
        if (root != null && root.val > key) {
            TreeNode succNode = s.succ;
            if (succNode == null || root.val < succNode.val)
                s.succ = new TreeNode(root.val);
        }

        findPreSuc(root.right, p, s, key);

    }

    public static void main(String[] args) {

        TreeNode root = TreeNode.PopulateBST();
        Res p = new Res();
        Res s = new Res();
        findPreSuc(root, p, s, 37);
        System.out.println(p.pre.val);
        System.out.println(s.succ.val);

    }

}
