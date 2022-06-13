package GettingStartedBasics.BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class Serialize_Deserialize_BinaryTree {

    // LC: 297. Serialize and Deserialize Binary Tree/

    // Solution GFG
    // https://www.geeksforgeeks.org/serialize-deserialize-binary-tree/

    // To seralize, we use DFS
    // For Deserialize, we use Global variable n which we use as a index for Splitting string
    public static String serialize(TreeNode node) {

        Stack<TreeNode> st = new Stack<>();
        st.push(node);

        ArrayList<String> resultInArray = new ArrayList<>();

        while (st.size() > 0) {
            TreeNode currentNode = st.pop();

            // Node is not there than insert "null"
            if (currentNode == null) {
                resultInArray.add("null");// THIS IS IMPORTANT
            } else {
                resultInArray.add(String.valueOf(currentNode.val));
                st.push(currentNode.left);
                st.push(currentNode.right);
            }
        }
        return String.join(",", resultInArray);
    }

    static int n = 0;

    public static TreeNode deSerialize(String str) {
        String[] arrStr = str.split(",");
        return deSerializeHelper(arrStr);
    }

    public static TreeNode deSerializeHelper(String[] str) {

        // Below is the Right way to check "null" as a String
        if (str[n].equals("null") == true) {
            return null;
        }

        // This below one would NOT WORK
        // if (str[n] == "null") {
        // return null;
        // }

        TreeNode node = new TreeNode(Integer.parseInt(str[n]));
        n++; // getting next node for LEFT child
        node.left = deSerializeHelper(str);
        n++; // getting next node for RIGHT child
        node.right = deSerializeHelper(str);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        String serialized = serialize(root);
        System.out.println("Serialized view of the tree:");
        System.out.println(serialized);
        System.out.println();

        // Let us deserialize the stored tree into root1
        // TreeNode t = deserialize(serialized);

        // System.out.println(
        // "Inorder Traversal of the tree constructed from serialized String:");
        // inorder(t);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

}
