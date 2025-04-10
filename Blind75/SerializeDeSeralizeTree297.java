package Blind75;

import java.util.ArrayList;

import AdobeQues.TNode;

public class SerializeDeSeralizeTree297 {

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    public static void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null,");
            return;
        }
        sb.append(root.val + ",");
        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        // We have to maintin state of curetn index in recursive calls.
        // Java is call by reference, either we have to use a GLOBAL integer variable
        // outside function, or, use an ArrayList or array like this
        int[] n = { 0 };
        return deserializeHelper(strs, n);

    }

    public static TreeNode deserializeHelper(String[] strs, int[] n) {
        if (strs[n[0]].equals("null") || strs[n[0]].equals("")) {
            n[0]++; // this is important, in case of null also as we have to move forward to next
                    // index, else it will stop on first null
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(strs[n[0]]));
        n[0]++;
        node.left = deserializeHelper(strs, n);
        node.right = deserializeHelper(strs, n);
        return node;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        ArrayList<Integer> arrayList = new ArrayList<>();

        String strResult = serialize(root);

        TreeNode root2 = deserialize(strResult);
        TreeNode.PrintTree(root2);
    }
}
