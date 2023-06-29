package StriverSheet.Day17_BinaryTree;

// Refer TreeImageForReference.png in this folder
public class TreeNode {
    int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode PopulateBinaryTree() {
        TreeNode root = new TreeNode(50, null, null);
        TreeNode child1 = new TreeNode(25, null, null);
        TreeNode child2 = new TreeNode(75, null, null);
        TreeNode child3 = new TreeNode(12, null, null);
        TreeNode child4 = new TreeNode(37, null, null);
        TreeNode child5 = new TreeNode(30, null, null);
        TreeNode child7 = new TreeNode(45, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;

        return root;
    }

    public static void PrintTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        if (root.left != null)
            System.out.print("Left Child: " + root.left.val + " ,");
        if (root.right != null)
            System.out.print("Right Child: " + root.right.val + " ");
        System.out.println();
        PrintTree(root.left);
        PrintTree(root.right);

    }

}