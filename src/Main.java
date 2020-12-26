public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 2, 3, 5, 6, 7, 10};

        int res = BinSearch.frequency(arr, 3);
        System.out.println(res);
    }
}
