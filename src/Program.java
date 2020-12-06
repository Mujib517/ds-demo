
// object oriented
public class Program {

    // SRP
    public static void main(String[] args) {
        boolean res = isPrime(7);
        System.out.println(res);
    }

    // 1 - 50 - 3rs -
    // 51- 100 - 5rs
    // 101-*   - 10rs
    // 0
    // ask questions
    // understand the problem
    // method signature
    static int calculate(int units) {
        int amount = 0;
        if (units < 50) return units * 3;
        if (units >= 50) {
            amount = amount + (50 * 3);
        }

        if (units >= 100) {
            amount = amount + (50 * 5);
            amount = amount + ((units - 100) * 10);
        }

        return amount;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // int, string, boolean, double, char
// abc - xyz
// algorithmic
// design
// phone
// 96595959
// 969-222-2292
// char c ='a'
// globalization
// store, operate
// char arrays - 4GB
// index int - 2^32
    class Student {
        String name;
        String id;
        double fee; //"100000"
        int age;
        boolean active; //8bit, 32 bits
        String[] phonenumber;
    }


    class Node {
        public int val;
        public Node next;
    }
}


