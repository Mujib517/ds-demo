import java.util.Stack;

public class Q2 {
    private int count = 0;
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    public void add(int k) {
        s1.push(k);
        ++count;
    }

    public int poll() {
        if (count == 0) throw new EmptyQueueException();
        count--;
        if (!s2.isEmpty()) return s2.pop();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.pop();
    }

    public int peek() {
        if (count == 0) throw new EmptyQueueException();
        if (!s2.isEmpty()) return s2.peek();
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.peek();
    }
}
