import apple.laf.JRSUIUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
//        int[] arr = new int[]{5, 3, 2, 4, 1, 7, 6, 8};
//
//
//        TNode result = TreeProblems.buildBST(arr);

        TNode root = new TNode(10);
        TNode l1 = new TNode(8);
        TNode l2 = new TNode(5);
        TNode l3 = new TNode(11);
        TNode r1 = new TNode(20);


        l1.left = l2;
        l1.right = l3;
        root.left = l1;
        root.right = r1;


        System.out.println(TreeProblems.isBST(root));
    }

}
