import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QProblems {

    public static Queue<Integer> reverseKElem(Queue<Integer> q, int k) {

        Queue<Integer> result = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        while (k > 0 && !q.isEmpty()) {
            s.push(q.poll());
            k--;
        }

        while (!s.isEmpty()) {
            result.add(s.pop());
        }

        while (!q.isEmpty()) {
            result.add(q.poll());
        }

        return result;
    }

    // constraints:  k<=q.size()
    public static Queue<Integer> reverseKElem2(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        int remainingElems = q.size() - k;

        while (k > 0 && !q.isEmpty()) {
            k--;
            s.push(q.poll());
        }

        while (!s.isEmpty()) q.add(s.pop());

        while (remainingElems > 0) {
            q.add(q.poll());
            remainingElems--;
        }

        return q;
    }
}
