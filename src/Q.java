import java.util.LinkedList;

public class Q {

    private LinkedList<Integer> list = new LinkedList<>();

    // O(1)
    public void add(int x) {
        list.add(x);
    }

    // O(1)
    public int poll() {
        if(list.size()==0) throw new EmptyQueueException();
        return list.removeFirst();
    }

    public int peek() {
        if(list.size()==0) throw new EmptyQueueException();
        return list.peekFirst();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }
}
