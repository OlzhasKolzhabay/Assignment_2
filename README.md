# Assignment 2 - ArrayList and LinkedList

## Project Description:
### Implementation of basic data structures in Java
* MyArrayList
* MyLinkedList
* MyStack
* MyQueue
* MyMinHeap

## Requirements
**Java 11 или выше** ([скачать JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html))
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
