public class Arrays {

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

    int maxProduct(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max1 = arr[i];
                maxIndex = i;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max2 && maxIndex != j) max2 = arr[j];
        }

        return max1 * max2;
    }

    int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;

        int[] res = new int[m + n];

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {

            if (arr1[i] < arr2[j]) {
                res[k] = arr1[i];
                i++;
                k++;
            } else {
                res[k] = arr2[j];
                j++;
                k++;
            }
        }

        while (i < m) {
            res[k] = arr1[i];
            i++;
            k++;
        }

        while (j < n) {
            res[k] = arr2[j];
            j++;
            k++;
        }

        return res;
    }

    // O(N)
    int maxProduct2(int[] arr) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max1) {
                max1 = arr[i];
                maxIndex = i;
            }
        }

        for (int j = 0; j < arr.length; j++) {
            if (arr[j] > max2 && maxIndex != j) max2 = arr[j];
        }

        return max1 * max2;
    }

    // O(N)
    int search(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) return i;
        }

        return -1;
    }

    public static int[] maxRight(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int maxSoFar = Integer.MIN_VALUE;
            for (int j = i + 1; j < arr.length; j++) {
                if (maxSoFar < arr[j]) maxSoFar = arr[j];
            }

            arr[i] = maxSoFar;
        }

        return arr;
    }

    // O(N)
    public static int[] maxRight2(int[] arr) {
        int n = arr.length;
        int maxSoFar = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = maxSoFar;
            if (temp > maxSoFar) maxSoFar = temp;
        }

        return arr;
    }

    // Sorting
    int findMissingNumber(int[] arr) {
        java.util.Arrays.sort(arr);

        for (int i = 0; i < arr.length - 1; i++) {
            // if(arr[i] == arr[i+1]-1) continue;
            // return i+1;
            if (arr[i] != arr[i + 1] - 1) return i + 1;
        }
        return -1;
    }

    // O(N)
    int findMissingNumber2(int[] arr) {

        int n = arr.length;
        int expectedSum = 0;
        int actualSum = 0;

        for (int i = 1; i <= n; i++) {
            expectedSum = expectedSum + i;
        }

        for (int i = 0; i < n; i++) {
            actualSum = actualSum + arr[i];
        }

        return expectedSum - actualSum;
    }

    // sum of natural numbers
    int findMissingNumber3(int[] arr) {

        int n = arr.length;

        int expectedSum = (n * (n + 1)) / 2;
        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            actualSum = actualSum + arr[i];
        }

        return expectedSum - actualSum;
    }

    void answerQueries(int[] arr, int[] start, int[] end) {
        int q = start.length;

        for (int i = 0; i < q; q++) {
            int startIndex = start[i];
            int endIndex = end[i];

            int sum = 0;
            for (int j = startIndex; j <= endIndex; j++) {
                sum = sum + arr[j];
            }

            System.out.println(sum);
        }
    }

    /*
        Time : O(Q+N)
        Space: O(N)
     */

    void answerQueries2(int[] arr, int[] start, int[] end) {
        int n = arr.length;
        int q = start.length;

        int[] cumSum = new int[n];

        for (int i = 1; i < n; i++) {
            cumSum[i] = cumSum[i] + cumSum[i - 1];
        }

        for (int i = 0; i < q; i++) {
            int sIndex = start[i];
            int eIndex = end[i];

            if (sIndex == 0) {
                System.out.println(cumSum[eIndex]);
            } else {
                int sum = cumSum[eIndex] - cumSum[sIndex - 1];
                System.out.println(sum);
            }
        }
    }

    /*
     * Time : O(Q+N)
     * Space: O(1)
     */
    void answerQueries3(int[] arr, int[] start, int[] end) {
        int n = arr.length;
        int q = start.length;

        for (int i = 1; i < n; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }

        for (int i = 0; i < q; i++) {
            int sIndex = start[i];
            int eIndex = end[i];

            if (sIndex == 0) {
                System.out.println(arr[eIndex]);
            } else {
                int sum = arr[eIndex] - arr[sIndex - 1];
                System.out.println(sum);
            }
        }
    }

    // space O(1)
    // Time O(N)
    static int removeDuplicates(int[] arr) {
        if (arr.length == 0) return 0;
        int n = arr.length;
        int p1 = 0, p2 = 1;

        while (p1 < n - 1 && p2 < n) {
            if (arr[p1] == arr[p2]) p2++;
            else {
                arr[p1 + 1] = arr[p2];
                p1++;
            }
        }

        return p1 + 1;
    }

}
