package StriverSheet.Day18;

import java.util.List;

public class ZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        List<List<Integer>> result = zigzagLevelOrder(root);

        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

}
