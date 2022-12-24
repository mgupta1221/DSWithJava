package StriverSheet.Day18;

// Problem: LC 100 https://leetcode.com/problems/same-tree/ 
public class IfTreesAreIdentical {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return (p.val == q.val) && (isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }

    public static void main(String[] args) {

        // Creating Tree 1
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

        // Creating Tree 2
        TreeNode root2 = new TreeNode(50, null, null);
        child1 = new TreeNode(25, null, null);
        child2 = new TreeNode(75, null, null);
        child3 = new TreeNode(12, null, null);
        child4 = new TreeNode(37, null, null);
        child5 = new TreeNode(30, null, null);
        child7 = new TreeNode(40, null, null);// chnaged this node only from Tree 1

        root2.left = child1;
        root2.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;

        Boolean result = isSameTree(root, root2);
        System.out.println(result);
    }
}
