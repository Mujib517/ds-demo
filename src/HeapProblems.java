import com.sun.javafx.css.parser.LadderConverter;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapProblems {

    public static PriorityQueue<Integer> minKElems(int[] arr, int k) {
        // max PQ
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if (maxHeap.size() < k) {
                maxHeap.add(arr[i]);
            } else {
                if (maxHeap.peek() > arr[i]) {
                    maxHeap.poll();
                    maxHeap.add(arr[i]);
                }
            }
        }

        return maxHeap;
    }


    public static void runningMedian(int[] arr) {
        PriorityQueue<Integer> lowers =
                new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> highers =
                new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            addElement(arr[i], lowers, highers);
            balanceHeaps(lowers, highers);
            printMedian(lowers, highers);
        }
    }

    private static void addElement(int k, PriorityQueue<Integer> lowers,
                                   PriorityQueue<Integer> highers) {
        if (lowers.size() == 0 || lowers.peek() > k) lowers.add(k);
        else highers.add(k);
    }

    private static void balanceHeaps(PriorityQueue<Integer> lowers,
                                     PriorityQueue<Integer> highers) {

        PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;

        if (bigger.size() - smaller.size() > 1) smaller.add(bigger.poll());
    }

    private static void printMedian(PriorityQueue<Integer> lowers,
                                    PriorityQueue<Integer> highers) {

        PriorityQueue<Integer> bigger = lowers.size() > highers.size() ? lowers : highers;
        PriorityQueue<Integer> smaller = lowers.size() > highers.size() ? highers : lowers;

        if (smaller.size() == bigger.size()) {
            double median = ((double) bigger.peek() + smaller.peek()) / 2;
            System.out.println(median);
        } else {
            System.out.println(bigger.peek());
        }
    }
}
