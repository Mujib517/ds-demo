public class HashTable {
    private int[] arr = new int[10];
    private int count = 0;

    private int getHash(int x) {
        int index = x % arr.length;
        return index;
    }

    public void add(int x) {
        int index = getHash(x);
        if (arr[index] == x) throw new ItemExistsException();
        arr[index] = x;
        ++count;
    }

    // O(1)
    public boolean contains(int x) {
        int index = getHash(x);

        if (arr[index] == x) return true;
        return false;
    }

    public int size() {
        return count;
    }
}

class ItemExistsException extends RuntimeException {
}
