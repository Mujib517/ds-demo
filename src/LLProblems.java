public class LLProblems {
    public static Node remove(Node nd) {
        if (nd.next == null) return null;
        nd.val = nd.next.val;
        nd.next = nd.next.next;
        return nd;
    }
}
