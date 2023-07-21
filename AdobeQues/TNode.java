package AdobeQues;

// Refer TreeImageForReference.png in this folder
public class TNode {
    public int val;
    public TNode left;
    public TNode right;

    TNode() {
    }

    TNode(int val) {
        this.val = val;
    }

    public TNode(int val, TNode left, TNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TNode PopulateBinaryTree() {
        TNode root = new TNode(50, null, null);
        TNode child1 = new TNode(25, null, null);
        TNode child2 = new TNode(75, null, null);
        TNode child3 = new TNode(12, null, null);
        TNode child4 = new TNode(37, null, null);
        TNode child5 = new TNode(30, null, null);
        TNode child7 = new TNode(45, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        child4.left = child5;

        child2.left = child7;

        return root;
    }

    public static void PrintTree(TNode root) {
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