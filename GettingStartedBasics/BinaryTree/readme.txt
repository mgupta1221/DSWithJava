Order
1. Basics1
2. Basics2
3. Diameter_Approach1 and 2
4. IsBinarySearchTree
5. LargestBSTSubTree
6. IsBalancedTree
7. Contruct Tree from PostOrder/PreOrder AND Inorder
8. Contruct Tree from PreOrder
9. Contruct Tree from Inorder
10. Vertical Order Traversal(this approach si also used to solve Top View/Bototm view of the tree )




// Tree diagram for Basics1 questions: "SampleBinaryTree.png"

-> For height of the tree question, for Base condition return "-1" in case of edges , "0" in case of Nodes
E.g. For a tree with single node:
1) height as per number of nodes will be 1. 
2) but height as per number of edges will be 0. 


//Generic tree mai base case nahi jarurat thi kyunki recursion children nodes ka for loop mai tha..to leaf nodes ke liye code kabhi chalta hi nahi tha
but Binary tree mai root.left , leaf ho sakta hai isliye base case ki jarurat hai


NodeToRootPath
NodetoRootPath for Binary tree implementation is differnet compare to as done in Generic tree
We are using Global arraylist here which will be populated from inside the function.

// Check removeLeafNodes in Basics2.java

// Check Dimater of Treee-  Solved with 2 approaches:
1. Diameter_Approach1.java
2. Diameter_Approach2.java

// in Binary Search Tree calculations like "Is a tree BST", or "largest BST Subtree"
we need to caulcate min and max at each node

// Searching in a Balaneced BST is O(log n)