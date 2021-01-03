public class LL {
    //readonly
    private int count = 0;
    private Node head = null;
    private Node tail = null;

    // O(1)
    public void add(int x) {
        Node nd = new Node(x);
        if (count == 0) head = nd;
        else tail.next = nd;

        tail = nd;
        ++count;
    }

    // O(1)
    public void addToHead(int x) {
        Node nd = new Node(x);
        nd.next = head;
        head = nd;
        ++count;
    }

    // O(N)
    public boolean contains(int x) {
        Node temp = head;
        while (temp != null) {
            if (temp.val == x) return true;
            temp = temp.next;
        }

        return false;
    }

    public void print() {
        for (Node temp = head; temp != null; temp = temp.next) {
            System.out.print(temp.val + " ");
        }
    }

    public int size() {
        return count;
    }
}
