import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] array;
    private int length = 0;
    private int capacity = 5;

    public MyArrayList(){
        array = new Object[capacity];
    }

    @Override
    public T get(int index){
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        return (T) array[index];
    }

    @Override
    public T getFirst() {
        if(length == 0){
            return null;
        };
        return (T) array[0];
    }

    @Override
    public T getLast() {
        if(length == 0){
            return null;
        }
        return (T) array[length - 1];
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        for(int i = index;i < length - 1;i++){
            array[i] = array[i + 1];
        }
        array[length - 1] = null;
        length--;

    }

    @Override
    public void removeFirst() {
        if(length == 0){
            return;
        }
        for(int i = 0;i <length - 1;i++){
            array[i] = array[i + 1];
        }
        array[length - 1] = null;
        length--;

    }

    @Override
    public void removeLast() {
        if(length == 0){
            return;
        }
        array[length - 1] = null;
        length--;

    }
    // Implements bubble sort using the provided Comparator for ordering
    @Override
    public void sort(Comparator<T> cmp) {
        for(int i = 0;i < length - 1;i++){
            for (int j = 0; j < length - i - 1; j++) {
                T current = (T) array[j];
                T next = (T) array[j + 1];
                // Swap elements if they are in the wrong order according to the Comparator
                if(cmp.compare(current, next) > 0) {
                Object temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        for(int i = 0;i < length;i++){
            if(array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i = length - 1;i >= 0;i--){
            if(array[i].equals(object)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[length];
        System.arraycopy(array, 0, result, 0, length);
        return result;
    }

    @Override
    public void clear() {
        array = new Object[capacity];
        length = 0;

    }

    @Override
    public void add(T newItem){
        if(length == capacity){
            increaseBuffer();
        }

        array[length++] = newItem;
    }

    @Override
    public void set(int index, T item) {
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException();
        }
        array[index] = item;

    }

    // Inserts an item at the specified index, shifting elements to the right
    @Override
    public void add(int index, T item) {
        if(index < 0 || index > length){
            return;
        }
        if(length == capacity){
            increaseBuffer();
        }
        // Shift elements to the right to make space for the new item
        for(int i = length;i > index;i--){
            array[i] = array[i - 1];
        }

        array[index] = item;
        length++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(length, item);
    }

    // Increases the capacity of the internal array by 1.5x when full
    private void increaseBuffer(){
        capacity = (int) (1.5 * capacity);
        Object[] array2 = new Object[capacity];
        if (length >= 0) System.arraycopy(array, 0, array2, 0, length);

        array = array2;
    }

    @Override
    public int size(){
        return length;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
