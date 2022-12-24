package StriverSheet.Day18;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// LC : 103 https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

// Solution simple: https://takeuforward.org/data-structure/zig-zag-traversal-of-binary-tree/

// Same as 'Level Order' with one additional 'if' conditon while adding to subResult as highlighted below
public class ZigzagLevelOrderTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            List<List<Integer>> emptyResult = new ArrayList<>();
            return emptyResult;
        }

        List<List<Integer>> result = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean direction = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> subResult = new ArrayList<>();

            for (int i = 0; i < len; i++) {

                TreeNode current = queue.poll();

                // This code is same as Level order Traversal except the if condition below
                // while adding to SubResult
                if (direction == true)
                    subResult.add(current.val); // This will add to the end of the arrayList
                else
                    subResult.add(0, current.val);// this will add to the front

                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }

            }
            direction = !direction;
            result.add(new ArrayList<>(subResult));
        }
        return result;

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
