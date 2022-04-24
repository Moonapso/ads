public class MyHeap <T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyHeap() {
        list = new MyArrayList<>();
    }

    public int size(){
        return list.size();
    }

    public boolean empty(){
        return list.size() == 0;
    }

    public T getMax(){
        return list.get(0);
    }

    public T extractMax(){
        return list.remove(0);
    }

    public void insert(T item){
        list.add(item);
    }

    private void swap(int iFirst, int iSecond){
        swap(iFirst,iSecond);
    }

    private T rightChildOf(int i){
        return list.get(i*2+2);
    }

    private T leftChildOf(int i){
        return list.get(i*2+1);
    }

    private T parentOf(int i){
        return list.get(i/2);
    }

    private void heapify(int i){
        int leftHeap = (int) leftChildOf(i);
        int rightHeap = (int) rightChildOf(i);
        int min = i;

        if (leftHeap <= (list.size() - 1) && list.get(leftHeap).compareTo(list.get(i)) < 0)  {
        min = leftHeap;
        }

        if (rightHeap <= (list.size() - 1) && list.get(leftHeap).compareTo(list.get(i)) < 0)  {
            min = leftHeap;
        }

        if (min != i){
            swap(i,min);
            heapify(min);
            traverseUp(i);
        }
}
