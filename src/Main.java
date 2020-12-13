public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 0};
        // LHS = RHS
        int[] res = seggregate2(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println(a + " " + b);
    }

    static void printDigits(int n) {

        while (n > 0) {
            int digit = n % 10;
            System.out.print(digit + " ");
            n = n / 10;
        }
    }

    static int sumOfDigits(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum = sum + digit;
            n = n / 10;
        }

        return sum;
    }

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static int findMin(int arr[], int n) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
            res = Math.min(res, arr[i]);
        return res;
    }

    static int squareSum(int[] arr) {
        int sum = 0;
        // loop variant
        int i = 0;
        while (i < arr.length) {
            sum = sum + (arr[i] * arr[i]);
        }
        return sum;
    }

    static int[] seggregate(int[] arr) {
        int zeros = 0;
        int ones = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) ++zeros;
            else ++ones;
        }

        int i = 0;
        while (zeros > 0) {
            arr[i] = 0;
            ++i;
            --zeros;
        }

        while (ones > 0) {
            arr[i] = 1;
            --ones;
            ++i;
        }
        return arr;
    }

    // O(N)
    static int[] seggregate2(int[] arr) {
        int p1 = 0, p2 = arr.length - 1;

        while (p1 < p2) {
            if (arr[p1] == 0) ++p1;
            if (arr[p2] == 1) --p2;
            if (arr[p1] == 1 && arr[p2] == 0) {
                int temp = arr[p1];
                arr[p1] = arr[p2];
                arr[p2] = temp;

                ++p1;
                --p2;
            }
        }

        return arr;
    }
}
