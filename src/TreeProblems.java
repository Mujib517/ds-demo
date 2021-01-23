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
}
