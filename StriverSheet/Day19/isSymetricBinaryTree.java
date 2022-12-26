package StriverSheet.Day19;

// Problem : LC: 101 https://leetcode.com/problems/symmetric-tree/
// check whether it is a mirror of itself 
// Note that values of nodes are also important

public class isSymetricBinaryTree {

    public static boolean isSymmetric(TreeNode root) {

        if (root == null)
            return true;

        return isSymmetricHelper(root.left, root.right);

    }

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        if (left == null && right == null)
            return true;
        if (left == null || right == null) {
            return false;
        }

        // see diagram in quesiton to understand this
        return (left.val == right.val &&
                isSymmetricHelper(left.left, right.right) &&
                isSymmetricHelper(left.right, right.left));

    }

    public static void main(String[] args) {
        TreeNode root = PopulateBinaryTree();
        boolean result = isSymmetric(root);
        System.out.println(result);
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
