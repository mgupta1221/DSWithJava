package StriverSheet.Day21;

// Refer TreeImageForReference.png in this folder
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

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

    public static TreeNode PopulateBST() {
        TreeNode root = new TreeNode(50, null, null);
        TreeNode child1 = new TreeNode(25, null, null);
        TreeNode child2 = new TreeNode(75, null, null);
        TreeNode child3 = new TreeNode(12, null, null);
        TreeNode child4 = new TreeNode(37, null, null);
        TreeNode child5 = new TreeNode(30, null, null);
        TreeNode child7 = new TreeNode(65, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;

        return root;
    }

    public static TreeNode PopulateBST2() {
        TreeNode root = new TreeNode(4, null, null);
        TreeNode child1 = new TreeNode(2, null, null);
        TreeNode child2 = new TreeNode(7, null, null);
        TreeNode child3 = new TreeNode(1, null, null);
        TreeNode child4 = new TreeNode(3, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        return root;
    }

    public static TreeNode PopulateBST3() {
        TreeNode root = new TreeNode(1, null, null);
        TreeNode child1 = new TreeNode(4, null, null);
        TreeNode child2 = new TreeNode(3, null, null);
        TreeNode child3 = new TreeNode(2, null, null);
        TreeNode child4 = new TreeNode(4, null, null);
        TreeNode child5 = new TreeNode(2, null, null);
        TreeNode child6 = new TreeNode(5, null, null);
        TreeNode child7 = new TreeNode(4, null, null);
        TreeNode child8 = new TreeNode(6, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child2.left = child5;
        child2.right = child6;

        child6.left = child7;
        child6.right = child8;

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