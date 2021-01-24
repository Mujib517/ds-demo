import java.util.LinkedList;
import java.util.Queue;

public class TreeProblems {

    // NLogN
    public static TNode buildBST(int[] arr) {
        if (arr.length == 0) return null;

        TNode root = new TNode(arr[0]);
        TNode temp = root;

        for (int i = 1; i < arr.length; i++) {
            insert(temp, arr[i]);
        }

        return root;
    }

    // LogN
    public static TNode insert(TNode root, int x) {
        TNode temp = root;
        TNode nd = new TNode(x);

        while (temp != null) {

            if (temp.data < x) {
                if (temp.right == null) {
                    temp.right = nd;
                    return root;
                }
                temp = temp.right;
            } else {
                if (temp.left == null) {
                    temp.left = nd;
                    return root;
                }
                temp = temp.left;
            }
        }

        return root;
    }

    // T(N) = 1 + T(N/2) => LogN
    public static TNode insertRec(TNode root, int x) {
        if (root == null) return null;

        if (root.left == null) {
            root.left = new TNode(x);
            return root;
        } else {
            if (root.right == null) {
                root.right = new TNode(x);
                return root;
            }
        }

        if (root.data < x) {
            return insert(root.right, x);
        } else {
            return insert(root.left, x);
        }
    }

    // LogN
    public static boolean find(TNode root, int x) {
        while (root != null) {
            if (root.data == x) return true;
            if (root.data < x) root = root.right;
            else root = root.left;
        }

        return false;
    }

    public static boolean findRec(TNode root, int x) {
        if (root == null) return false;
        if (root.data == x) return true;

        if (root.data < x) return findRec(root.right, x);
        return findRec(root.left, x);
    }

    public static int findMin(TNode root) {
        while (root.left != null) {
            root = root.left;
        }

        return root.data;
    }

    public static int findMax(TNode root) {
        TNode temp = root;
        while (temp.right != null) {
            temp = temp.right;
        }

        return temp.data;
    }

    // PreOrder traversal: Root Left Right
    public static void preOrder(TNode root) {
        if (root == null) return;

        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    // Left Root Right
    public static void inOrder(TNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

    // Left Right Root
    public static void postOrder(TNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    // O(N). Binary Tree
    public static TNode parent(TNode root, int x) {
        if (root == null || root.data == x) return null;

        if (isParent(root, x)) return root;

        TNode result = parent(root.left, x);
        if (result != null) return result;
        return parent(root.right, x);
    }

    // LogN
    public static TNode parentBST(TNode root, int x) {
        if (root == null || root.data == x) return null;

        if (isParent(root, x)) return root;
        if (root.data < x) return parentBST(root.right, x);
        return parentBST(root.left, x);
    }

    public static int height(TNode root) {
        if (root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean areSiblings(TNode root, int x, int y) {
        if (root == null) return false;

        if (areChildren(root, x, y)) return true;
        return areSiblings(root.left, x, y) ||
                areSiblings(root.right, x, y);
    }

    public static void levelOrder(TNode root) {
        if (root == null) return;

        Queue<TNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TNode nd = q.poll();
            System.out.println(nd.data);
            if (nd.left != null) q.add(nd.left);
            if (nd.right != null) q.add(nd.right);
        }
    }

    // will not work for all BSTs
    public static boolean isBST(TNode root) {
        if (root == null) return true;
        if (!isValid(root)) return false;

        return isBST(root.left) && isBST(root.right);
    }

    public static void levelOrder2(TNode root) {
        if (root == null) return;

        Queue<TNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            TNode nd = q.poll();
            if (nd != null) {
                System.out.print(nd.data + " ");
                if (nd.left != null) q.add(nd.left);
                if (nd.right != null) q.add(nd.right);
            } else if (nd == null && !q.isEmpty()) {
                q.add(null);
                System.out.println();
            }
        }

    }

    private static boolean areChildren(TNode root, int x, int y) {
        boolean cond1 = root.left != null
                && root.left.data == x
                && root.right != null
                && root.right.data == y;

        boolean cond2 = root.left != null
                && root.left.data == y
                && root.right != null
                && root.right.data == x;

        return cond1 || cond2;
    }

    private static boolean isParent(TNode root, int x) {
        return (root.left != null && root.left.data == x) ||
                (root.right != null && root.right.data == x);
    }

    private static boolean isValid(TNode root) {
        if (root.left != null && root.right != null) {
            return root.data < root.right.data && root.data >= root.left.data;
        } else if (root.left == null && root.right != null) {
            return root.data < root.right.data;
        } else if (root.left != null && root.right != null)
            return root.data >= root.left.data;
        return true;
    }
}
