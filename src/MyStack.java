public class MyStack<T> {
    private int length;
    private MyLinkedList<T> stack = new MyLinkedList<>();
    public MyStack() {

    }

    public boolean empty(){
        return stack.size() == 0;

    }

    public int size(){
        return stack.size();
    }


    public T peek(){
        if(empty()){
            return null;
        }
        return stack.get(stack.size()-1);
    }

    public T push(T newItem){
        stack.add(newItem);
        return newItem;
    }


    public T pop(){
        if(empty()){
            return null;
        }
        T lastItem = stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return lastItem;
    }

}