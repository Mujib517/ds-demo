import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        LL list = new LL();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(50);
        list.addToHead(5);
        list.addToHead(1);
        list.add(60);
        System.out.println(list.size());

        list.print();

        System.out.println(list.contains(50));
        System.out.println(list.contains(100));

    }
}
