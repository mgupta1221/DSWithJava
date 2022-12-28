package StriverSheet.Day21;

import java.util.*;

// Problem: LC 297 https://leetcode.com/problems/serialize-and-deserialize-binary-tree

public class Searliaze_DeSerialize_BST {

    public static String serialize(TreeNode root) {

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        ArrayList<String> resultInArray = new ArrayList<>();

        while (st.size() > 0) {
            TreeNode currentNode = st.pop();

            if (currentNode == null) {
                resultInArray.add("null");// THIS IS IMPORTANT
            } else {
                // System.out.println(currentNode.val);
                resultInArray.add(String.valueOf(currentNode.val));
                st.push(currentNode.right);
                st.push(currentNode.left);
            }
        }
        return String.join(",", resultInArray);
    }

    // // Decodes your encoded data to tree.
    static int p = 0;

    public static TreeNode deserialize(String data) {
        String[] arrStr = data.split(",");
        return deSerializeHelper(arrStr);
    }

    public static TreeNode deSerializeHelper(String[] str) {

        if (str[p].equals("null") == true) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(str[p]));
        p++; // getting next node for LEFT child
        node.left = deSerializeHelper(str);
        p++; // getting next node for RIGHT child
        node.right = deSerializeHelper(str);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();

        String result = serialize(root);

        System.out.println(result);
        TreeNode root1 = deserialize(result);
        System.out.println(root1.left.val);
        System.out.println(root1.right.val);
    }
}
