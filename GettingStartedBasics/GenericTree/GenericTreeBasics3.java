package GettingStartedBasics.GenericTree;

import java.lang.reflect.Array;
import java.util.ArrayList;

///Generic Tree Pepcoding Playlist 
// https://www.youtube.com/watch?v=YnufWAWOfI8&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_

public class GenericTreeBasics3 {

    // Are trees similar
    // Quesiton:
    // https://www.youtube.com/watch?v=rumfdyFR-_A&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=33
    // Solution :
    // https://www.youtube.com/watch?v=y_PIhsd9vt0&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=34

    // In this question, data of nodes se farq nahi padta...tree ka shape same hona
    // chhaiye
    private static boolean AreTreesSimilar(Node root1, Node root2) {
        if (root1.children.size() != root2.children.size()) {
            return false;
        }
        for (int i = 0; i < root1.children.size(); i++) {
            Node c1 = root1.children.get(i);
            Node c2 = root2.children.get(i);
            return AreTreesSimilar(c1, c2);
        }
        return true;
    }

    // Question:
    // https://www.youtube.com/watch?v=GfEQs3qhMws&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=35

    // Solution Video:
    // https://www.youtube.com/watch?v=v2MqQoma9uc&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=36

    // In this question, data of nodes se farq nahi padta...tree ka shape same hona
    // chhaiye
    private static boolean AreTreesMirror(Node root1, Node root2) {
        if (root1.children.size() != root2.children.size()) {
            return false;
        }

        int len1 = root1.children.size();

        for (int i = 0, j = len1 - 1; i < j; i++, j--) {
            Node c1 = root1.children.get(i);
            Node c2 = root1.children.get(j);
            return AreTreesMirror(c1, c2);
        }
        return true;

    }

    // Trees will be symetric if they are mirror of each other
    private static boolean AreTreesSymmetric(Node root1, Node root2) {
        return AreTreesMirror(root1, root2);
    }

    // You have to find Predecessor and Successor of a given node as in PreOrder
    // traversal
    // E.g. in the "DistanceBetweenNodes.png"..
    // For 70, 30 is the predecessor and 80 is successor in PreOrder
    private static void FindPredecessorSuccessor(Node root, int val) {

        // To Do
        return;
    }

    // Solution Video:
    // https://www.youtube.com/watch?v=I1rAT8hRnWI&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=43

    // Ciel - Smallest amoung larger elements ...matlab Given element se bade saare
    // elements mai se sabse chota wala element

    // Floor - Largest amoung smaller elements ...matlab Given element se chote
    // saare
    // elements mai se sabse bada wala element

    // We use global variable in this solutin..
    static int ceil = Integer.MAX_VALUE;
    static int floor = Integer.MIN_VALUE;

    private static void FindFloorAndCeilOfAnElement(Node root, int data) {
        if (root.val > data) { // wahi elements relevant hain jo data se bade hain
            if (root.val < ceil) {
                ceil = root.val;
            }
        }

        if (root.val < data) { // wahi elements relevant hain jo data se chote hain
            if (root.val > floor) {
                floor = root.val;
            }
        }

        // recursive call
        for (Node n : root.children) {
            FindFloorAndCeilOfAnElement(n, data);
        }

    }

    private static int KthLargestElement(Node root, int k) {

        int currentMax = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            FindFloorAndCeilOfAnElement(root, currentMax);
            currentMax = floor; // ab floor mai first largest aa jayega..first iteration
                                // ke baad..aur next call
                                // is element pe lagegi aur floor firse nikala jayega..tab second largest aa
                                // jayega
            floor = Integer.MIN_VALUE;// floor ko reset har baar karna hai kyunki floor nikaalne ke liye floor ki ye
                                      // value logic mai chahiye
        }
        return currentMax;
    }

    // Solution video:
    // https://www.youtube.com/watch?v=tDx3PPwgSxs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=47

    // Trick Diagram : maxSumOfSubtree.png
    // Sum with max sum is 30 in the diagram and maxSum is 140

    // In this we are using Global variable and not returning real result from the
    // function but instead return maxSum(due to recursive calls inside)
    static int maxSumNode;
    static int maxSumOfSubtree = Integer.MIN_VALUE;

    // isme hum return maxSum karenge
    private static int MaxSumSubtree(Node root) {
        // if (root == null) {
        // return 0;
        // }
        int sum = 0;
        for (Node child : root.children) {
            sum += MaxSumSubtree(child);// Get sum of child nodes...for leaf nodes loop will not iterate
        }
        sum += root.val; // add node itself to the sum of child nodes
        if (sum > maxSumOfSubtree) {
            maxSumOfSubtree = sum; // keep getting maxSum of subtrees
            maxSumNode = root.val; // Node for which sum is maximum
        }
        return sum; // due to recursion we have to return maxSum of the subtree of a node(including
                    // itself)
    }

    // Diameter of a tree is the maximum distance(or maximum no of edges) between
    // any 2 nodes of the tree
    // Solution Video:
    // https://www.youtube.com/watch?v=GIA2cZgOdwg&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=49

    // Solution approach: We will find the first 2 most deepest path from first
    // childrens of the root and add 2 to them to find the longest path between any
    // 2 nodes and than add 1 to connect the root too.
    static int diamter_of_tree = 0;

    // ye fuction height of a node return karega, diameter global variable se milega
    // recurion ki wajah se height return karni hogi
    private static int DiameterOfTree(Node root) {
        int height = -1;

        int deepest_childHeight = -1;
        int second_deepest_childHeight = -1;

        for (Node child : root.children) {
            height = DiameterOfTree(child);

            if (height > deepest_childHeight) { // If greater than largest update deepest and second_deepest
                second_deepest_childHeight = deepest_childHeight;
                deepest_childHeight = height;

            } else if (height > second_deepest_childHeight) {// If ONLY greater than secnd deepest, update second
                                                             // deepest only
                second_deepest_childHeight = height;
            }
        }
        // ab jab deepest aur second deepest mil gaye hain...
        // to total depth hogi = deepest + secondDeepest + 2
        // ye max value diameter mai store karte rahenge..ye final diamter hoga is iteration ka
        diamter_of_tree = Math.max(diamter_of_tree, deepest_childHeight + second_deepest_childHeight + 2);
        deepest_childHeight++; // node ki height = deepest child ki height se 1 jyada hoti hai
        return deepest_childHeight; // return height hogi but result diamter mai store ho rha hai

    }

    public static void main(String[] args) {

        Node root = PopulateTreeHelper();
        Node nodeCopy = new Node(root); // making a copy

        // nodeCopy.children.add(new Node(55));

        // boolean result = AreTreesSimilar(root, nodeCopy);
        // System.out.println(result);

        // boolean result = AreTreesMirror(root, nodeCopy);
        // System.out.println(result);

        // boolean result = AreTreesSymmetric(root, nodeCopy);
        // System.out.println(result);

        // To Do
        // FindPredecessorSuccessor(root, 70);
        // System.out.println(result);

        // FindFloorAndCeilOfAnElement(root, 60);
        // System.out.println(ceil);
        // System.out.println(floor);

        // int result = KthLargestElement(root, 3);
        // System.out.println(result);

        // MaxSumSubtree(root);
        // System.out.println(maxSumOfSubtree);

        DiameterOfTree(root);
        System.out.println(diamter_of_tree);
    }

    private static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            val = data;
        }

        // Cloning an object so that if changes are madein 1 , other should not get
        // affected
        public Node(Node another) {
            // For non primitives properties (like array, object),
            // always create new object like we did not below for arraylist children below
            ArrayList<Node> newChildren = new ArrayList<>();
            for (Node n : another.children) {
                newChildren.add(n);
            }
            this.children = newChildren; // you can access
        }
    }
    // Helper to print and check the graph

    private static void InOrderTraversal(Node root) {
        if (root == null)
            return;

        for (int i = 0; i < root.children.size() - 1; i++) {
            InOrderTraversal(root.children.get(i));
        }
        System.out.print(root.val + " "); // printing root
        if (root.children.size() > 0) {
            InOrderTraversal(root.children.get(root.children.size() - 1));
        }
    }

    // Helper to build tree
    public static Node PopulateTreeHelper() {
        Node root = new Node(10);
        Node child1 = new Node(20);
        Node child2 = new Node(30);
        Node child3 = new Node(40);

        Node child4 = new Node(50);
        Node child5 = new Node(60);
        Node child6 = new Node(70);
        Node child7 = new Node(80);
        Node child8 = new Node(90);
        Node child9 = new Node(100);
        Node child10 = new Node(110);
        Node child11 = new Node(120);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        child1.children.add(child4);
        child1.children.add(child5);

        child2.children.add(child6);
        child2.children.add(child7);
        child2.children.add(child8);

        child3.children.add(child9);

        child7.children.add(child10);
        child7.children.add(child11);

        return root;
    }

}
