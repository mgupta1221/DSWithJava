package StriverSheet.Day19;

// Problem : https://practice.geeksforgeeks.org/problems/mirror-tree/1

// Convert the tree to its mirror

public class ConvertToMirror {

    public static void mirror(TreeNode node) {

        if (node == null)
            return;

        // Swap left and right child on each iteration
        TreeNode tempNode = node.right;
        node.right = node.left;
        node.left = tempNode;

        mirror(node.left);
        mirror(node.right);

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        mirror(root);
        TreeNode.PrintTree(root);
    }

    public static TreeNode PopulateBinaryTree() {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode child1 = new TreeNode(2, null, null);
        TreeNode child2 = new TreeNode(2, null, null);
        TreeNode child3 = new TreeNode(3, null, null);
        TreeNode child4 = new TreeNode(4, null, null);
        TreeNode child5 = new TreeNode(4, null, null);
        TreeNode child6 = new TreeNode(3, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child2.left = child5;
        child2.right = child6;

        return root;
    }

}
