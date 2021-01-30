import apple.laf.JRSUIUtils;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{8, 18, 4, 5, 15, 10, 11, 20};

        PriorityQueue<Integer> heap = new PriorityQueue();

        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }

        while (!heap.isEmpty()) System.out.println(heap.poll());
    }

}
