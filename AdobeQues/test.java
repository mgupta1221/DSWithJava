package AdobeQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import StriverSheet.Day17_BinaryTree.TreeNode;
import StriverSheet.Day6.Node;

public class test {

    static ArrayList<Integer> factorial(int n) {

        ArrayList<Integer> result = new ArrayList<>();

        int carry = 0;
        result.add(1);
        for (int i = 2; i <= n; i++) {
            carry = 0;
            for (int j = result.size() - 1; j >= 0; j--) {
                int prod = (result.get(j) * i) + carry;
                result.set(j, prod % 10);
                carry = prod / 10;
            }
            if (carry > 0) {
                result.add(0, carry);
                carry /= 10;

            }
        }
        return result;

    }

    public static void main(String[] args) {
        String s1 = "15";
        String s2 = "2";
        ArrayList<Integer> result = factorial(5); // 1,2,3,4
        for (Integer inte : result) {
            System.out.println(inte);
        }

    }

    public static TreeNode PopulateBinaryTree() {
        TreeNode root = new TreeNode(100, null, null);
        TreeNode child1 = new TreeNode(30, null, null);
        TreeNode child2 = new TreeNode(40, null, null);
        TreeNode child3 = new TreeNode(10, null, null);
        TreeNode child4 = new TreeNode(20, null, null);

        root.left = child1;
        root.right = child2;

        child1.left = child3;
        child1.right = child4;

        return root;
    }
}
