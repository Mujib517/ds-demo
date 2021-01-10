public class Recursion {

//    private static int min = Integer.MAX_VALUE;

    /**
     * Recurrence relation T(n)= T(n-1) + 1
     * T(0) = 1
     * T(10) = T(9) + 1
     * <p>
     * base condition: T(0) = 1
     * Relation: T(n)= T(n-1) + 1
     * T(n) = T(n-2)+1 + 1
     * = T(n-2)+2
     * = T(n-3)+1 + 2
     * = T(n-3)+3
     * ...
     * = T(n-k) + k
     * n-k = 0
     * n = k
     * <p>
     * = T(n-n) + n
     * = T(0) + n
     * = 1 + n
     */
    // pints n to 1
    public static void printRecursive(int n) {
        if (n == 0) return;

        System.out.println(n);
        printRecursive(n - 1);
    }

    // prints 1 to n
    public static void printRecursive2(int n) {
        if (n == 0) return;

        printRecursive2(n - 1);
        System.out.println(n);
    }

    public static void printListRec(Node head) {
        if (head == null) return;

        System.out.println(head.val);
        printListRec(head.next);
    }

    public static void printListRec2(Node head) {
        if (head != null) {
            System.out.println(head.val);
            printListRec2(head.next);
        }
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) return 1;

        return n * factorial(n - 1);
    }

    // print linked list in reverse order
    public static void printListRecRev(Node head) {
        if (head == null) return;

        printListRec(head.next);
        System.out.println(head.val);
    }

    public static int minRec(int[] arr) {
        return minRecUtil(arr, 0, Integer.MAX_VALUE);
    }

    private static int minRecUtil(int[] arr, int index, int min) {
        if (index == arr.length) return min;

        if (arr[index] < min) min = arr[index];
        return minRecUtil(arr, index + 1, min);
    }
}
