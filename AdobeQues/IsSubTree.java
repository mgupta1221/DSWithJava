package AdobeQues;


// Prblem: https://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/

public class IsSubTree {

    public static boolean isSubtree(TNode T, TNode S) {
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }

        if (isTreeIdenticalHelper(T, S)) {
            return true;
        }
        return isSubtree(T.left, S) || isSubtree(T.right, S);
    }

    public static boolean isTreeIdenticalHelper(TNode T, TNode S) {

        if (S == null && T == null) {
            return true;
        }
        if (S == null || T == null) {
            return false;
        }

        return T.val == S.val && isTreeIdenticalHelper(T.left, S.left) &&
                isTreeIdenticalHelper(T.right, S.right);
    }

    public static void main(String[] args) {
        TNode T = TNode.PopulateBinaryTree();

        TNode S = new TNode(25, null, null);
        TNode child3 = new TNode(12, null, null);
        TNode child4 = new TNode(37, null, null);
        TNode child5 = new TNode(30, null, null);
        S.left = child3;
        S.right = child4;
        child4.left = child5;

        Boolean result = isSubtree(T, S);
        System.out.println(result);

    }
}
