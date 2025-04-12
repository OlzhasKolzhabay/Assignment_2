import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // ArrayList Tests:
        System.out.println("ArrayList tests");
        MyArrayList<Integer> list = new MyArrayList<>();
        Comparator<Integer> cmp = Integer::compare;
        list.add(8);
        // method add, add the element in list
        list.add(7);
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);

        // method get return index 3 element - 5
        System.out.println(list.get(3));

        // method getFirst return first element 8
        System.out.println(list.getFirst());

        // method getLast return last element 2
        System.out.println(list.getLast());

        // remove 2 index - 6
        list.remove(2);

        // removeFirst will be remove first element 8
        list.removeFirst();

        // removeLast will be remove last element 2
        list.removeLast();

        // list will be sort using bubble sort - 3 4 5 7
        list.sort(cmp);
        System.out.println("Sorted list");
        for(int i =0;i < list.size();i++){
            System.out.println(list.get(i));
        }

        // find index element, for 3 will be 0
        System.out.println(list.indexOf(3));

        // find last index element for 4 will be 1
        System.out.println(list.lastIndexOf(4));

        // find exist element on list or not, in our case will be False
        System.out.println(list.exists(2));

        // make list to array
        list.toArray();

        // method set adds the item to a special index
        list.set(0, 5);

        // method size return length list
        System.out.println(list.size());

        // method addFirst, add element on index 0
        list.addFirst(3);

        // method addLast, add element on last Index
        list.addLast(4);


        System.out.println("Doubly LinkedList tests");
        // Linked list tests
        MyLinkedList<Integer> list2 = new MyLinkedList<>();
        list2.add(8);
        // method add, add the element in list
        list2.add(7);
        list2.add(6);
        list2.add(5);
        list2.add(4);
        list2.add(3);
        list2.add(2);

        // method get return index 3 element - 5
        System.out.println(list2.get(3));

        // method getFirst return first element 8
        System.out.println(list2.getFirst());

        // method getLast return last element 2
        System.out.println(list2.getLast());

        // remove 2 index - 6
        list2.remove(2);

        // removeFirst will be remove first element 8
        list2.removeFirst();

        // removeLast will be remove last element 2
        list2.removeLast();

        // list will be sort using bubble sort - 3 4 5 7
        list2.sort(cmp);
        System.out.println("Sorted list");
        for(int i =0;i < list2.size();i++){
            System.out.println(list2.get(i));
        }

        // find index element, for 3 will be 0
        System.out.println(list2.indexOf(3));

        // find last index element for 4 will be 1
        System.out.println(list2.lastIndexOf(4));

        // find exist element on list or not, in our case will be False
        System.out.println(list2.exists(2));

        // make list to array
        list2.toArray();

        // method set adds the item to a special index
        list2.set(0, 5);

        // method size return length list
        System.out.println(list2.size());

        // method addFirst, add element on index 0
        list2.addFirst(3);

        // method addLast, add element on last Index
        list2.addLast(4);

        System.out.println("Heap tests:");
        MyMinHeap<Integer> minHeap = new MyMinHeap<>(cmp);
        minHeap.insert(8);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(5);
        System.out.println(minHeap.size()); // 4
        System.out.println(minHeap.getMin()); // 5
        minHeap.extractMin(); // delete min element
        System.out.println(minHeap.getMin()); // min element changed











    }
}