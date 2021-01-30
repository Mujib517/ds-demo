public class MinHeap {
    private int count = 0;
    private int[] data = new int[10];

    public int size() {
        return count;
    }

    public int peek() {
        if (count == 0) throw new IllegalStateException();
        return data[0];
    }

    public void add(int x) {
        data[count++] = x;

        heapifyUp();
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int poll() {
        if (count == 0) throw new IllegalStateException();
        int top = data[0];
        data[0] = data[count - 1];
        count--;
        heapifyDown();

        return top;
    }

    private void heapifyUp() {
        int currentIndex = count - 1;

        while (currentIndex != 0) {
            int parentIndex = (currentIndex - 1) / 2;
            if (data[parentIndex] > data[currentIndex]) {
                swap(parentIndex, currentIndex);
                currentIndex = parentIndex;
            } else break;
        }
    }

    private void swap(int index1, int index2) {
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    private void heapifyDown() {
        int index = 0;
        while (index < count) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            int maxIndex = -1;
            if (hasLeftChild(leftIndex)) maxIndex = leftIndex;

            if (hasRightChild(rightIndex)) {
                if (data[rightIndex] < data[leftIndex]) maxIndex = rightIndex;
            }

            if (!hasLeftChild(leftIndex)) break;

            if (data[index] > data[maxIndex]) swap(index, maxIndex);
            index = maxIndex;
        }
    }

    private boolean hasLeftChild(int index) {
        return index < count;
    }

    private boolean hasRightChild(int index) {
        return index < count;
    }

}
