public class MyQueue<T> {
    private int length;
    private MyLinkedList<T> queue = new MyLinkedList<>();
    public MyQueue(){

    }

    public boolean empty(){
        return queue.size() == 0;
    }

    public int size(){
        return queue.size();
    }

    public T peek(){
        return queue.getFirst();
    }

    public T equeue(T newItem){
        queue.addLast(newItem);
        return newItem;
    }

    public T dequeue(){
        if(empty()){
            return null;
        }
        T FrontNewItem = queue.getFirst();
        queue.removeFirst();
        return FrontNewItem;
    }
}
