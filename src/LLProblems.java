public class LLProblems {
    public static Node remove(Node nd) {
        if (nd.next == null) return null;
        nd.val = nd.next.val;
        nd.next = nd.next.next;
        return nd;
    }

    public static Node reverse(Node head) {
        Node temp = head;
        Node prev = null;

        while (temp != null) {
            Node next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }

    public static Node middle(Node head) {
        int count = 0;
        Node temp = head;

        while (temp != null) {
            ++count;
            temp = temp.next;
        }

        int middle = 0;
        if (count % 2 == 0) {
            middle = count / 2;
        } else {
            middle = (count / 2) + 1;
        }

        while (middle > 1) {
            head = head.next;
            middle--;
        }

        return head;
    }

    // O(N)
    public static Node middle2(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // increrment by 1
            fast = fast.next.next; //increrment by 2
        }

        return slow;
    }

    public static boolean hasCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }
}

