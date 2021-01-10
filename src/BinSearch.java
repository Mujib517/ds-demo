public class BinSearch {

    public static int binSearch(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) return mid;
            if (arr[mid] > k) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    /*
        base condition: T(1) = 1
     T(N) = 1 + T(N/2)

     T(N) = 1 + (1+ T(N/4))
 	  = 2 + T(N/4)
 	  = 2 + (1+T(N/8))
 	  = 3 + T(N/8)
 	  = 3 + T(N/2^3)
 	  	...
 	  =	k + T(N/2^k)

 	  	N/2^k = 1

 	  	N = 2^k

 	  	K = LogN

 	  	= LogN + T(N/2^LogN)
 	  	= LogN + T(1)
 	  	= LogN
 	  	O(LogN)
     */
    public static int binSearchRec(int[] arr, int k) {
        return binSearchUtil(arr, k, 0, arr.length - 1);
    }

    private static int binSearchUtil(int[] arr, int k, int low, int high) {

        if (low > high) return -1;

        int mid = (low + high) / 2;
        if (arr[mid] == k) return mid;
        if (arr[mid] > k) high = mid - 1;
        else low = mid + 1;

        return binSearchUtil(arr, k, low, high);
    }

    public static void pairSum(int[] arr, int k) {
        int p1 = 0, p2 = arr.length - 1;

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];

            if (sum == k) {
                System.out.println(arr[p1] + " " + arr[p2]);
                return;
            } else if (sum > k) {
                p2--;
            } else p1++;
        }
    }

    void allPairSum(int[] arr, int k) {
        int p1 = 0, p2 = arr.length - 1;

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];

            if (sum == k) {
                System.out.println(arr[p1] + " " + arr[p2]);
                p1++;
                p2--;
            } else if (sum > k) {
                p2--;
            } else p1++;
        }
    }

    public static int floor(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] == k) {
                if (mid == 0) return mid;
                else if (arr[mid - 1] != arr[mid]) return mid;
                high = mid - 1;
            } else if (arr[mid] > k) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static int ceil(int[] arr, int k) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == k) {
                if (mid == high) return mid;
                if (arr[mid + 1] != k) return mid;
                else low = mid + 1;
            } else if (arr[mid] > k) high = mid - 1;
            else low = mid + 1;
        }

        return -1;
    }

    public static int frequency(int[] arr, int k) {
        int sIndex = floor(arr, k);
        int eIndex = ceil(arr, k);

        if (eIndex == -1) return 0;
        return eIndex - sIndex + 1;
    }

}
