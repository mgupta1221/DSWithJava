package StriverSheet.Day17_BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

// Problem: https://takeuforward.org/data-structure/preorder-inorder-postorder-traversals-in-one-traversal/
// Problem Description: 

// We need to write a function allTraversals()which returns us three lists of a preorder, inorder and postorder traversals
// of the tree at the same time.We are not allowed to write separate codes for each traversal.We want all traversals
// in a single piece of code,in a single instance.

// Solution :
// We take a stack data structure and push a pair<val, num> to it. Here Val is the value of the root node and
// num the visit to the node. Initially, the num is 1 as we are visiting the root node for the first time. We also 
// create three separate lists for preorder, inorder and postorder traversals. Then we set an iterative loop to run till 
// the time our stack is non-empty.

// Case When num==1
// This means that we are visiting the node for the very first time, therefore we push the node value to our preorder list.
// Then we push the same node with num=2(for Case 2). After this, we want to visit the left child. 
// Therefore we make a new pair Y(<val, num>) and push it to the stack (if left child exists). 

// Case When num==2
// This means that we are visiting the node for the second time, therefore on our second visit to the node. 
// we push the node value to our inorder list. Then we push the same node with num=3( for Case 3). 
// After this, we want to visit the right child. Therefore as in the first case, we check 
// if there exists a right child or not. If there is, we push the right child and num value=1 as a pair to our stack.

// Case 3 When num==3
// This means that we are visiting the node for the third time. Therefore we will push that node’s value
// to our postorder list. Next, we simply want to return to the parent so we will not push anything else to the stack.

class NodeWithOrder {
    TreeNode node;
    int Order;

    public NodeWithOrder(TreeNode node, int order) {
        this.node = node;
        this.Order = order;
    }
}

public class Pre_In_Post_In_One_Traversal {

    public static void allTraversalInOneMethod(TreeNode root,
            List<Integer> pre,
            List<Integer> in,
            List<Integer> post) {

        Stack<NodeWithOrder> st = new Stack<>();
        st.push(new NodeWithOrder(root, 1));

        while (!st.isEmpty()) {
            NodeWithOrder current = st.pop();
            // pre Order case
            // add element to preOrder list
            // increment 1 to 2
            // push the left side of the tree
            if (current.Order == 1) {
                pre.add(current.node.val);
                current.Order++; // adding it back to queue with Order 2
                st.push(current);
                // moving its left child with Order 1 for processing
                if (current.node.left != null) {
                    st.push(new NodeWithOrder(current.node.left, 1));
                }
            }
            // In order case
            // add element to inOrder list
            else if (current.Order == 2) {
                in.add(current.node.val);
                current.Order++; // adding it back to queue with Order 2
                st.push(current);
                // moving its right child with Order 1 for processing
                if (current.node.right != null) {
                    st.push(new NodeWithOrder(current.node.right, 1));
                }
            } else {
                post.add(current.node.val);
            }

        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.PopulateBinaryTree();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();

        allTraversalInOneMethod(root, pre, in, post);

        System.out.print("PreOrder: ");
        for (int num : pre) {
            System.out.print(num + ", ");
        }
        System.out.println();
        System.out.print("In Order: ");
        for (int num : in) {
            System.out.print(num + ", ");
        }
        System.out.println();
        System.out.print("Post Order: ");
        for (int num : post) {
            System.out.print(num + ", ");
        }

    }
}
