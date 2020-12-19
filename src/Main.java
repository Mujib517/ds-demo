public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 4, 15, -1, 10};
        int[] res = Arrays.maxRight2(arr);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
