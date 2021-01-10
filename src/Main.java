import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        int[] arr = new int[]{10, 20, 30, 40, 50, 60};
        int res = BinSearch.binSearch(arr, 35);
        System.out.println(res);

        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        Node n4 = new Node(40);
        Node n5 = new Node(50);
        Node n6 = new Node(60);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n2;
        n5.next = n6;


//        Recursion.printListRec2(n1);

//        Node res = n1;
//        while (res != null) {
//            System.out.print(res.val + " ");
//            res = res.next;
//        }
    }

}
