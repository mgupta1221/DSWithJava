package AdobeQues;

// 
public class DeleteNodeInBST {

    public static TNode deleteNode(TNode root, int X) {

        if (root == null) {
            return null;
        }
        // case 1:
        if (root.val < X) {
            // Notice we have to assign the result of deleteNote() function(not just call
            // func)
            root.right = deleteNode(root.right, X);
        }
        // case 2:
        else if (root.val > X) {
            root.left = deleteNode(root.left, X);
        }
        // case 3: When root has both left and right child
        else {
            // case 3.1:
            if (root.left == null && root.right == null) {
                return null;
            }
            // case 3.2:
            if (root.left == null) {
                return root.right;
            }
            // case 3.3:
            if (root.right == null) {
                return root.left;
            }
            // case 3.4:
            // We will replace the node to be deleted with either left child of
            // rightChild(if exists), or, with rightChild
            TNode nodeToBePlaced = null;
            TNode rightChild = root.right;
            if (rightChild.left != null) {
                nodeToBePlaced = rightChild.left;
            } else {
                nodeToBePlaced = rightChild;
            }
            root.val = nodeToBePlaced.val;
            root.right = deleteNode(root.right, nodeToBePlaced.val);//deleting the replaced node
        }
        return root;

    }

    public static void main(String[] args) {
        TNode T = TNode.PopulateBinaryTree();

        TNode resultRoot = deleteNode(T, 30);
        TNode.PrintTree(resultRoot);
    }

}
