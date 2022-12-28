package StriverSheet.Day21;

import java.util.Stack;

// Problem :  https://leetcode.com/problems/binary-search-tree-iterator/

// class BSTIterator {

//     public BSTIterator(TreeNode root) {

//     }

//     public int next() {

//     }

//     public boolean hasNext() {

//     }
// }

// Solution : Solution is logic based, Implemented using Stack 
// Step: 1: In constructor : Push all left-side children iteratively in stack
// Step  2: For next(): pop() the top element. Get the "right node" of this top element and push all its "left-side" children.
// Step  3: For hasNext() : if stack is Empty than false else true

// Ye InOrder traversal ka way hai...pehle saare left-wale nodes stack mai daal do...fir 1-by-1 pop() karo..aur uske
// right element ke saare left children stack mai daal do...fir pop() and repeat

public class BST_Iterator {
    Stack<TreeNode> st = new Stack<>();

    public BST_Iterator(TreeNode root) {
        while (root != null) {
            st.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode rightNode = st.peek().right;
        int nextElement = st.pop().val;
        while (rightNode != null) {
            st.push(rightNode);
            rightNode = rightNode.left;
        }
        return nextElement;

    }

    public boolean hasNext() {
        return (!st.isEmpty());
    }

    public static void main(String[] args) {

        TreeNode root = TreeNode.PopulateBST();
        BST_Iterator bst = new BST_Iterator(root);
        int result = bst.next();
        System.out.println(result);
        result = bst.next();
        System.out.println(result);
        result = bst.next();
        System.out.println(result);
    }

}
