public class General {

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
}
