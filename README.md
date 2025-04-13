# Assignment 2 - ArrayList and LinkedList

## Project Description:
### Implementation of basic data structures in Java
* MyArrayList
* MyLinkedList
* MyStack
* MyQueue
* MyMinHeap

### Used MyLinkedList for MyStack and MyQueue and MyArrayList for MyMinHeap
### MyStack
* LinkedList is suitable for a stack because the operations of adding and removing elements (push/pop) occur only from one end (vertex). LinkedList provides O(1) for operations at the beginning or the end
### MyQueue
* For a queue, LinkedList is ideal because it supports fast O(1) operations of adding to the end (enqueue) and removing from the beginning (dequeue). In addition, LinkedList is flexible in size
### MyMinHeap
* ArrayList is used for minimal heap because a heap is a data structure that is stored as a complete binary tree, where elements are conveniently represented in an array. ArrayList provides O(1) access by index





## Requirements
**Java 11 or higher** ([Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))
* Build System: IntelliJ
## Installation
* Cloning a repository
* ```git clone https://github.com/OlzhasKolzhabay/Assignment_2.git```

## Scructure project
* src/ 
* ├── Main.java             # Tests ArrayList and LinkedList
* ├── MyList.java           # Interface for Lists
* ├── MyArrayList.java      # Dynamic array implementation
* ├── MyLinkedList.java     # Linked array implementation
* ├── MyMinHeap.java        # Heap
* ├── MyStack.java          # Stack (LIFO) - last in first out
* └── MyQueue.java          # queue (FIFO) - first in fist out 



### Working with MyStack
```java
MyStack<Integer> list44 = new MyStack<>();
list44.push(2);
list44.push(3);
System.out.println(list44.peek()); // 3
```

### Working with MyQueue
``` java
MyQueue<Integer> list45 = new MyQueue<>();
list45.equeue(45);
list45.equeue(42);
System.out.println(list45.peek()) // 45
```


### Working with MyMinHeap
``` java
MyMinHeap<Integer> heap = new MyMinHeap<>(cmp);
heap.insert(8);
heap.insert(7);
heap.insert(6);
heap.insert(5);
System.out.println(heap.getMin()); // 5
```
