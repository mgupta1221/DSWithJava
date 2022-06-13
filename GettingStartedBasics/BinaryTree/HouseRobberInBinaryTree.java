package GettingStartedBasics.BinaryTree;

// LC - 337

// https://leetcode.com/problems/house-robber-iii/

// Solution is same as Housr Robber problem where we maintain 2 vars: Include and Exclude. 
// See "Count_MaxSumOfNonAdjElements.java" in "PepLevelUp/DP" folder

// here we are creating a class to maintain both Include and Exclude values of a Node together.

// If the current node is included than its left and right child will be excluded becuase of 
// adjacency so we will take their exclude values . Similarly if we exclude the current node than 
// we will consider both Include and Exclude nodes of the left and right
// child- such that max of left and max Of right node

public class HouseRobberInBinaryTree {

    public class House {
        public int include;
        public int exclude;
    }

    public int rob(Node root) {
        House resultHouse = HouseRobberHelper(root);
        return Math.max(resultHouse.include, resultHouse.exclude);
    }

    public House HouseRobberHelper(Node root) {
        if (root == null) {
            return new House();
        }
        // recursive call for left and right
        House leftHouse = HouseRobberHelper(root.left);
        House rightHouse = HouseRobberHelper(root.right);

        // Now create answr for current node
        House house = new House();

        // if current node is included than children has to be excluded
        house.include = leftHouse.exclude + rightHouse.exclude + root.val;

        house.exclude = Math.max(leftHouse.include, leftHouse.exclude) +
                Math.max(rightHouse.include, rightHouse.exclude);

        return house;

    }

    public static void main(String[] arg) {

    }

    public class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
