public class MyStack<T extends Comparable<T>>{
    private MyArrayList<T> list;

    public MyStack(){
        list = new MyArrayList<>();
    }
    public T pop(){
        return list.get((size()-1));
    }

    public T push(T item){
        list.add(item);
        return item;
    }

    public T peek(){
        return list.get(size()-1);
    }

    public boolean empty(){
       return list.size() == 0;
    }

    public int size(){
        return list.size();
    }
}
