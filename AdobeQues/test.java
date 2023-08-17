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

    public static void serialize(TNode root, ArrayList<Integer> A) {

    }

    public static TNode deSerialize(ArrayList<Integer> A) {

    }

    public static void main(String[] args) {
        TNode root = TNode.PopulateBinaryTree();
        ArrayList<Integer> A = new ArrayList<>();
        serialize(root, A);

        TNode root2 = deSerialize(A);
        TNode.PrintTree(root2);
    }
}
