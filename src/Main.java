import apple.laf.JRSUIUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 3, 2, 4, 1, 7, 6, 8};

        TNode result = TreeProblems.buildBST(arr);

//        TNode res = TreeProblems.insertRec(result, 30);

        TreeProblems.postOrder(result);

//        System.out.println(TreeProblems.findMax(result));
    }

}
