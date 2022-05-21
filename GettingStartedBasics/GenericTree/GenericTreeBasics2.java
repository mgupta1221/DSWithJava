package GettingStartedBasics.GenericTree;

import java.util.ArrayList;

///Generic Tree Pepcoding Playlist 
// https://www.youtube.com/watch?v=YnufWAWOfI8&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_

public class GenericTreeBasics2 {

    private static class Node {
        int val;
        ArrayList<Node> children = new ArrayList<>();

        Node(int data) {
            val = data;
        }
    }

    // find mirror of a tree
    private static void GetMirrorOfTree(Node root) {
        if (root == null)
            return;

        // recur for each child
        for (int i = 0; i < root.children.size(); i++) {
            GetMirrorOfTree(root.children.get(i));
        }

        int n = root.children.size();
        // Reverse the order of the elements in the children
        // 'i' variable will hold left most child, j will hold right most child and we
        // keep swapping
        for (int i = 0, j = n - 1; i < j; i++, j--) {
            Node temp1 = root.children.get(i);
            Node temp2 = root.children.get(j);

            root.children.set(i, temp2); // set temp 2 at index i
            root.children.set(j, temp1);
        }

    }

    // Remove all leaf nodes of tree
    // Explanation
    // https://www.youtube.com/watch?v=uPOfEn_qHRY
    private static void RemoveLeaves(Node root) {
        if (root == null) {
            return;
        }

        if (root.children.size() == 0) {
            return;
        }

        // We will run the loop for a node's children and REMOVE te CHILD which does not
        // have further children

        // Notice we have to remove children one by one , not directly like :
        // node.children=null;
        // but like below
        // node.children.remove(child);

        // Notice we are running the loop from n-1 to 0 (not 0 to n-1)
        // Say we are going from left to right and If we remove one element than Nodes
        // will shift left so the indexes which change and few elements will be missed
        // But if go from right to left, elements will not be misse don rmeoval of node

        // Detailed Reason : https://www.youtube.com/watch?v=Us32OuAMzfQ
        // see above video from 15 mins to see why we ran the loop in reverse

        // Also, notice we are removing Leafs in preOrder- NOT PostOrder becuase problem
        // in PostOrder is if we remove leaves while coming back to Parent Node, that
        // leaf whose children were removed will also be removed
        // Reason:
        // https://www.youtube.com/watch?v=0PBC_EEBHGg&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=21

        // Tip : if you use loop like for(Child c: root.children)
        // it will throw an error
        for (int i = root.children.size() - 1; i >= 0; i--) {
            Node child = root.children.get(i);
            if (child.children.size() == 0) {
                root.children.remove(child);
            }
        }
        for (Node child : root.children) {
            RemoveLeaves(child);
        }
    }

    // Find an element in a tree
    // Explanation:
    // https://www.youtube.com/watch?v=dWri78Z4khs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=26

    // See Trick Diagram: FindElement.png
    // Only half Euler tree is trevered
    // The moment value is found other children are not traversed
    // and control return from that node to its parent, its parent....till root

    // Same logic is used in Printing RootToNode path question below
    private static Node FindElement(Node root, int val) {
        if (root.val == val) {
            return root;
        }
        for (Node child : root.children) {
            Node res = FindElement(child, val);
            if (res.val == val) {
                return res;
            }

        }
        // agar kahi nahi mila
        return new Node(-1);
    }

    // Print Node to root path
    // Explanation:
    // https://www.youtube.com/watch?v=oEBwL5pHzTs&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=28
    private static ArrayList<Integer> NodeToRootPath(Node root, int data) {

        // agar node khud hi barabar to wo ek hi value return karega...khud ko hi return
        // karega
        if (root.val == data) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(root.val);
            return arr;
        }

        // Root mai nai mila to children mai dhoondh lo
        for (Node child : root.children) {
            ArrayList<Integer> pathToChild = NodeToRootPath(child, data);
            if (pathToChild.size() > 0) {
                pathToChild.add(root.val);// Notice we added root here becuase its child has got an answr
                // LOGIC: jiske yahan se bhara hua arraylist aaya hai..iska matlab wahan answer
                // mil gaya hai---usme parent khud ko add karega aur return kar dega
                return pathToChild;
            }
        }
        // agar kahin nahi mila..na root mai na uske children mai
        return new ArrayList<>();
    }

    // Get 'Lowest Common Ancestor'
    // This uses NodeToRoot path solution to get the answer
    // Question Video:
    // https://www.youtube.com/watch?v=5xlRdBskWJE&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=29
    // Solution Video:
    // https://www.youtube.com/watch?v=w8rr1AYMlfw&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=30
    // Question Diagram: LowestComAncestor.png
    // E.g. Here 70 aur 110 ka LCA 30 hoga (in sample tree)
    // 70 aur 100 ka 10 hoga
    private static int LowestCommonAncestor(Node root, int data1, int data2) {
        ArrayList<Integer> nodeToRootPath1 = NodeToRootPath(root, data1); // for 60-> 60, 30 10
        ArrayList<Integer> nodeToRootPath2 = NodeToRootPath(root, data2); // for 20 -> 20 10

        int i = nodeToRootPath1.size() - 1;
        int j = nodeToRootPath2.size() - 1;

        // looping from reverse as 10..30..60 till we find first unequal(uncoomon node)
        // node
        // which is 30 and 20 in this case
        // unse pehle wali node answer hogi which is 10
        while (i >= 0 && j >= 0 && nodeToRootPath1.get(i) == nodeToRootPath2.get(j)) {
            i--;
            j--;
        }
        // moving ahead now by 1 node which is the answer
        i++;

        return nodeToRootPath1.get(i);
    }

    // Distance betwene 2 nodes
    // Question:

    // https://www.youtube.com/watch?v=1raYelrrhFM&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=31
    // Solution :
    // https://www.youtube.com/watch?v=5N5tpizDXys&list=PL-Jc9J83PIiEmjuIVDrwR9h5i9TT2CEU_&index=32

    // Question Diagram: DistanceBetweenNodes.png
    // In this example: Distance between 70 and 110 is 3

    // This uses NodeToRoot path solution to get the answer
    private static int DistanceBetweenNodes(Node root, int data1, int data2) {
        ArrayList<Integer> nodeToRootPath1 = NodeToRootPath(root, data1); // for 60-> 60, 30 10
        ArrayList<Integer> nodeToRootPath2 = NodeToRootPath(root, data2); // for 20 -> 20 10

        int i = nodeToRootPath1.size() - 1;
        int j = nodeToRootPath2.size() - 1;

        // looping from reverse as 10..30..60 till we find first unequal(uncoomon node)
        // node
        // which is 30 and 20 in this case
        while (i >= 0 && j >= 0 && nodeToRootPath1.get(i) == nodeToRootPath2.get(j)) {
            i--;
            j--;
        }
        i++;// ab ye i bata rha 70 se 30 kitna dur hai i.e. 1 [70-> 30-> 10]
        j++;// ab ye j bata rha 110 se 30 kitna dur hai i.e. 2 [110-> 80 -> 30-> 10]
        return i + j;

    }

    public static void main(String[] args) {

        Node root = PopulateTreeHelper();

        // Mirror a tree
        // InOrderTraversal(root);// this traversal is to test the mirrored tree before
        // and after
        // GetMirrorOfTree(root);
        // System.out.println();
        // InOrderTraversal(root);

        // Removing all leaves from tree
        // InOrderTraversal(root);
        // RemoveLeaves(root);
        // System.out.println();
        // InOrderTraversal(root);

        // Find Element in tree
        // Node result = FindElement(root, 50);
        // System.out.println(result.val);

        // Find Node to root path in tree
        // ArrayList<Integer> result = NodeToRootPath(root, 120);
        // for (Integer str : result) {
        // System.out.print(str + " ");
        // }

        // // LCA
        // int result = LowestCommonAncestor(root, 70, 120);// answer should be root
        // // node 10
        // System.out.println(result);

        // Distance between Nodes
        int result = DistanceBetweenNodes(root, 70, 110);// answer should be root
        // node 3
        System.out.println(result);

    }

    /// Helper to print and check the graph
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
