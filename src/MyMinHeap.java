import java.util.Comparator;

public class MyMinHeap<T> {
    private final MyArrayList<T> list = new MyArrayList<>();
    private final Comparator<T> comparator;

    public MyMinHeap(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public boolean empty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    public T getMin() {
        if (empty()) {
            return null;
        }
        return list.get(0);
    }

    // Removes and returns the minimum element, restoring heap property
    public T extractMin() {
        if (empty()) {
            return null;
        }
        T min = list.get(0);
        T last = list.get(list.size() - 1);
        // Move last element to root and remove it from the end
        list.set(0, last);
        list.removeLast();
        if (!empty()) {
            heapify(0);
            // Reorganize heap starting from root to maintain min-heap property
        }
        return min;
    }

    public void insert(T item) {
        list.add(item);
        traverseUp(list.size() - 1);
    }

    private int leftChildOf(int index) {
        return 2 * index + 1;
    }

    private int rightChildOf(int index) {
        return 2 * index + 2;
    }

    private int parentOf(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        T temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    // Moves a node up the heap to restore min-heap property
    private void traverseUp(int index) {
        while (index > 0) {
            int parent = parentOf(index);
            // Compare with parent; swap if child is smaller
            if (comparator.compare(list.get(index), list.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                // Stop if min-heap property is satisfied
                break;
            }
        }
    }


    // Moves a node down the heap to restore min-heap property
    private void heapify(int index) {
        int size = list.size();
        while (true) {
            int left = leftChildOf(index);
            int right = rightChildOf(index);
            int smallest = index;
            // Find smallest among current node and its children
            if (left < size && comparator.compare(list.get(left), list.get(smallest)) < 0) {
                smallest = left;
            }
            if (right < size && comparator.compare(list.get(right), list.get(smallest)) < 0) {
                smallest = right;
            }
            if (smallest != index) {
                // Swap with smallest child and continue heapifying
                swap(index, smallest);
                index = smallest;
            } else {
                // Stop if no smaller child exists
                break;
            }
        }
    }
}