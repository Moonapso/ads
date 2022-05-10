import java.util.ArrayList;
import java.util.Objects;

public class MyHashTable<K extends Comparable<K>, V>{

    private static class HashNode<K,V>{
        private HashNode<K,V> next;
        private K key;
        private V value;

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }

        public HashNode(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList <HashNode <K,V>>[] chainArray;
    private int M = 11;
    private int size;
    private final double  loadFactor = 0.75;


    public MyHashTable(){
        chainArray = new ArrayList[M];
        size = 0;
    }

    public MyHashTable(int M){
        this.M = M;

        chainArray = new ArrayList[M];
        size = 0;
    }

    private int hash(K key){
        return Objects.hashCode(key);
    }

    public void put (K key, V value){
        int index = hash(key);
        HashNode <K,V> newNode = new HashNode<>(key, value);
        HashNode <K,V> node = chainArray.get(index);

        while (node != null){
            if (node.key.equals(key)){
                node.value = value;
                return;
            }
            node = node.next;
        }
            size++;
            node = chainArray.get(index);
            newNode.next = node;
            chainArray.set (index,newNode);

            if ((double) (size/M) >= loadFactor){
                ArrayList<HashNode<K, V>>[] temp = chainArray;
                M *= 2;
                size = 0;
                chainArray = new ArrayList[M];

                for (int i = 0; i < M; i++){
                    M.add (null);
                }

                for (HashNode<K,V> node : temp){
                    while (node != null){
                        put(node.key, node.value);
                        node = node.next;
                    }
                }
            }
    }

    public V get (K key){
        int index = hash(key);
        HashNode <K,V> node = chainArray.get(index);

        while (node != null){
            if (node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> node = chainArray.get(index);
        HashNode<K, V> p = null;
        if (node == null) {
            return null;
            size--;
        }

        while (node != null) {
            if (node.key.equals(key)) {
                break;
            }
            p = node;
            node = node.next;
        }
            if (p!= null){
                p.next = node.next;
            }else{
                chainArray.set(index,node.next);
            }
            
            return node.value;
    }
    
    public boolean contains (V value){
        for (int i = 0; i < M; i++){
            ArrayList<HashNode<K, V>> node = chainArray[i];
            while (node != null){
                V nodeV = get((K) node);
                if (nodeV.equals(value)){
                    return true;
                } node = node.next;
            }
        }
        return false;
    }

    public K getKey(V value){
        for (int i = 0; i < M; i++){
            HashNode<K,V> node = chainArray.get(i);
            while (node != null){
                V nodeV = get((K) node);
                if (nodeV.equals(value)){
                    return node.key;
                }
            }
        }
        return null;
    }
}
