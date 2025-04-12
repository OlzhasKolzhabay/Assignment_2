import java.util.Comparator;
import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private MyNodeT<T> head;
    private MyNodeT<T> tail;
    private int length;



    // Iterator implementation for traversing the linked list
    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }



    // Inner class for iterator, tracking the current node
    public class MyIterator implements Iterator<T> {
        MyNodeT<T> cursor = head;

        @Override
        public boolean hasNext() {
            return cursor != null;
        }
        @Override
        public T next() {
            T nextItem = cursor.data;
            cursor = cursor.next;
            return nextItem;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public void add(T newItem){
        MyNodeT<T> newNode = new MyNodeT<>(newItem);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void set(int index, T item) {
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException();
        }
        MyNodeT<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;

        }
        current.data = item;


    }



    // Inserts a node at the specified index, adjusting prev/next pointers
    @Override
    public void add(int index, T item) {
        if(index < 0 || index > length){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            addFirst(item);
            return;
        }
        else if(index == length){
            addLast(item);
            return;
        }

        MyNodeT<T> newNode = new MyNodeT<>(item);
        MyNodeT<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }

        // Link new node between current and its predecessor
        newNode.prev = current.prev;
        newNode.next = current;
        current.prev.next = newNode;
        current.prev = newNode;
        length++;
    }

    @Override
    public void addFirst(T item) {
        MyNodeT<T> newNode = new MyNodeT<>(item);
        if(head == null){
            head = tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    @Override
    public void addLast(T item) {
        MyNodeT<T> newNode = new MyNodeT<>(item);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    @Override
    public T get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        MyNodeT<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }

    @Override
    public T getFirst() {
        if(head == null){
            return null;
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if(tail == null){
            return null;
        }
        return tail.data;
    }

    @Override
    public void remove(int index) {
        if(index < 0 || index >= length){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            head = head.next;

        }
        MyNodeT<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        if(current.prev != null){
            current.prev.next = current.next;
        }
        if(current.next != null){
            current.next.prev = current.prev;
        }
        length--;

    }

    @Override
    public void removeFirst() {
        if(head == tail){
            head = tail = null;
        }
        else{
            head = head.next;
        }
        length--;

    }

    @Override
    public void removeLast() {
        if(head == tail){
            head = tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
        }
        length--;

    }


    // Implements bubble sort by swapping data between adjacent nodes
    @Override
    public void sort(Comparator<T> cmp) {
        for(int i = 0;i < length - 1; i++){
            // Check j != null to avoid null pointer issues, and j.next != null to ensure we can safely access the next node's data for comparison
            for(MyNodeT<T> j = head;j != null && j.next != null; j = j.next){
                // Swap data instead of nodes to maintain list structure
                if(cmp.compare(j.data, j.next.data) > 0){
                    T temp = j.data;
                    j.data = j.next.data;
                    j.next.data = temp;
                }

            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        MyNodeT<T> current = head;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = length - 1;
        MyNodeT<T> current = tail;
        while (current != null) {
            if (current.data.equals(object)) {
                return index;
            }
            current = current.prev;
            index--;
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
        MyNodeT<T> current = head;
        int index = 0;
        while(current != null){
            result[index++] = current.data;
            current = current.next;
        }
        return result;
    }

    @Override
    public void clear() {
        head = tail = null;
        length = 0;

    }

    @Override
    public int size(){
        return length;
    }

    private static class MyNodeT<E>{
        E data;
        MyNodeT<E> next;
        MyNodeT<E> prev;

        MyNodeT(E data){
            this.data = data;
            next = null;
        }
    }
}
