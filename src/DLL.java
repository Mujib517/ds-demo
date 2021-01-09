public class DLL {

    // state or data
    private int count = 0;
    private DLNode head = null;
    private DLNode tail = null;

    // behavior
    public void add(int x) {
        DLNode nd = new DLNode(x);
        if (head == null) {
            head = nd;

        } else {
            tail.next = nd;
            nd.prev = tail;
        }
        tail = nd;
        ++count;
    }

    public void addToHead(int x) {
        DLNode nd = new DLNode(x);
        if (head == null) {
            head = nd;
            tail = nd;
        } else {
            nd.next = head;
            head.prev = nd;
            head = nd;
        }

        ++count;
    }

    public void remove(){}

    public void removeHead(){}

    // O(1)
    public int size() {
        return count;
    }
}
