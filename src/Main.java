public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{};


        int res = Arrays.removeDuplicates(arr);

        for (int i = 0; i < res; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
