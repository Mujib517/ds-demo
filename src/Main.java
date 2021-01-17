import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Q2 q = new Q2();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.poll());

        q.add(4);
        q.add(5);
        q.add(6);

        q.poll();
        q.poll();
        q.poll();
        q.poll();
        q.poll();


        System.out.println(q.peek());
    }

}
