package StriverSheet.Day21;

import java.util.Stack;

class BST_Iterator1 {
    Stack<TreeNode> st;
    boolean reverse = false;

    public BST_Iterator1(TreeNode root, boolean reverse) {
        this.reverse = reverse;
        st = new Stack<>();
        while (root != null) {
            st.push(root);
            if (reverse)
                root = root.right;
            else {
                root = root.left;
            }
        }
    }

    public int next() {
        int nextElement = st.peek().val;
        // if 'reverse' - Descending InOrder traversal
        if (reverse) {
            TreeNode leftNode = st.peek().left;
            st.pop();
            while (leftNode != null) {
                st.push(leftNode);
                leftNode = leftNode.right;
            }
        } else {
            TreeNode rightNode = st.peek().right;
            st.pop();
            while (rightNode != null) {
                st.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return nextElement;
    }

    public boolean hasNext() {
        return (!st.isEmpty());
    }

}

public class Pair_With_Given_Sum_Apporach3 {

    // Problem : LC 653 https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

    // Solution: Approach 3: Using BST Iterator approach.

    // Important: First see how BST iterator works(BST_Iterator.java) which does in
    // Order trraversal using Stack.
    //

    public static boolean findTarget_approach3(TreeNode root, int k) {

        BST_Iterator1 iterator1 = new BST_Iterator1(root, false); // In Order taraversal in 'ascending' order of nodes
        BST_Iterator1 iterator2 = new BST_Iterator1(root, true); // In Order taraversal in 'descending' order of nodes

        int item1 = iterator1.next();
        int item2 = iterator2.next();
        while (item1 < item2) {
            if (item1 + item2 == k) {
                return true;
            } else if (item1 + item2 > k) {
                item2 = iterator2.next();
            } else {
                item1 = iterator1.next();
            }
        }
        return false;

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBST();

        boolean result = findTarget_approach3(root, 115); // Approach 3
        System.out.println(result);

    }

}
