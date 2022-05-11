import java.util.Iterator;

public class BST <K extends Comparable<K>, V> {
    private Node root;

    private class Node{
        private K key;
        private V val;
        private Node left,right;

        public Node (K key, V value){
            this.key = key;
            this.val = value;
            root = null;
        }
    }



    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private Node put(Node node, K key, V value){
        if (node == null){
            node = new Node(key, value);
            return node;
        }

        int res = key.compareTo(node.key);
        if(res < 0){
            node.left = put(node.left, key, value);
        } else if (res > 0){
            node.right = put(node.right, key, value);
        } else{
            node.val = value;
        }
        return node;
    }

    public V get (K key){
        return get(root, key);
    }

    private V get (Node node, K key){
        if (node == null){
            return null;
        }
        if (node.key.compareTo(key) == 0){
            return node.val;
        }
        if(node.key.compareTo(key) > 0){
            return get(node.left, key);
        } else if (node.key.compareTo(key) < 0){
            return get(node.right, key);
        }
        return node.val;
    }

    public void delete (K key){
        delete(root,key);
    }

    private Node delete (Node node, K key){
        if (node == null){
            return null;
        }
        int res = key.compareTo(node.key);

        if (key.compareTo(node.key) > 0){
            root.right = delete(root.right, key);
        } else if (key.compareTo(node.key) < 0){
            root.left = delete(root.left, key);
        } else {
            if (node.right == null){
                return null;
            }
            if (node.left == null){
                return null;
            }

            node.key = minNode (node.key);
            node.right = delete(node.right, node.key);
        }
        return node;
    }

    public Iterator<K> iterator(){

    }


        private K minNode(K key){
        K min = root.key;
        while (root.left != null){
            min = root.left.key;
            root = root.left;
        }
        return min;
    }
}
