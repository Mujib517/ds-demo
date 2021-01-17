import java.util.ArrayList;
import java.util.Arrays;

class EmptyStackException extends RuntimeException {
}

public class MyStack {

    private int[] arr = new int[10];

    private int count = 0;

    // O(1)
    public void push(int x) {
        if (count == arr.length) allocateSpace();
        arr[count++] = x;

//        arr[count] = x;
//        count = count + 1;
    }

    // O(1)
    public int pop() {
        if (isEmpty()) throw new EmptyStackException();
        if (count * 2 < arr.length) deallocateSpace();

        // count = count-1;
        //return  arr[count];

        return arr[--count];
    }

    // O(1)
    public boolean isEmpty() {
        return count == 0;
    }

    // O(1)
    public int size() {
        return count;
    }

    // O(1)
    public int peek() {
        if (isEmpty()) throw new EmptyStackException();
        return arr[count - 1];
    }

    private void allocateSpace() {
        int length = arr.length;
        int newLength = length * 2;
        int[] tempArr = new int[newLength];

        System.arraycopy(arr, 0, tempArr, 0, count - 1);
        arr = tempArr;
    }

    private void deallocateSpace() {
        int length = arr.length;
        int newLength = length / 2;
        int[] tempArr = new int[newLength];

        System.arraycopy(arr, 0, tempArr, 0, count - 1);
        arr = tempArr;
    }
}
