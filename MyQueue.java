import java.util.LinkedList;

public class MyQueue <T extends Comparable<T>>{
    private MyLinkedList<T> list;
    int strict = 10;



    public MyQueue(){
        list = new MyLinkedList<T>();
    }

    public int size(){
        return list.size();
    }

    public T remove() throws Exception{
        if (size() != 0){
            return list.remove(0);
        } else throw new Exception();
    }

    public T poll(){
        if (size() != 0){
            return list.remove(0);
        } return null;
    }

    public boolean offer(T item){
        if (size() != strict) {
            list.add(item);
            return true;
        }
        return false;
    }

    public void add(T item) throws Exception {
        if (size() != strict) {
            list.add(item, 0);
        } else throw new Exception();
    }

    public T peek(){
        return list.get(0);
    }

    public boolean empty(){
        return list.size() == 0;
    }
}
