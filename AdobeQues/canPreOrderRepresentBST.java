package AdobeQues;

import java.util.Stack;

//New

// https://practice.geeksforgeeks.org/problems/preorder-traversal-and-bst4006/1
// Leetcode 255

// Approach: Using Stack
// Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree.
// If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes, 
// so just push the new one onto the stack. But before that, pop all smaller ancestor values, as we must now be in their
// right subtrees (or even further, in the right subtree of an ancestor). Also, use the popped values as a lower bound( initially MIN) , 
// since being in their right subtree means we must never come across a smaller number anymore.

public class canPreOrderRepresentBST {

    static int canRepresentBST(int arr[], int N) {
        Stack<Integer> st = new Stack<>();
        int root = Integer.MIN_VALUE;

        for (int num : arr) {
            if (root > num) {
                return 0;
            }

            while (!st.isEmpty() && num > st.peek()) {
                root = st.pop(); // this mean popping all elements falling in Left-SubTree of 'num'. If we dont
                                 // come inside this means, 'num' is still on left side of current root element
                                 // so will be directly pushed into stack. Aur jo last mai pop hua hoga wo hi
                                 // 'root' hoga. Next element isse chhota nahi aana chahiye kyunki ab hum root ke
                                 // right subtree mai move kar gaye hain- warna ye PreOrder sequence nahi hoga -
                                 // Ye upar wali 'if' condition mai check kara hai.
                                 // Basically left tree se right tree mai move karte time pop() karna hai aur
                                 // root ko preserve kar lena hai..kyunki iske baad loop mai root se choti value
                                 // nahi aani chahiye
            }

            st.push(num); // this is like pushing left subtree elements
        }
        return 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, 3 };
        int result = canRepresentBST(arr, arr.length);
        System.out.println(result);

    }
}
