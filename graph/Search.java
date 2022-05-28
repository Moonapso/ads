package graph;

import java.util.*;

public class Search <T>{
    protected int count;
    protected Set<Vertex<T>> marked;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public Search(Vertex<T> source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(Vertex<T> vertex) {
        return marked.contains(vertex);
    }

    public LinkedList<Vertex<T>> pathTo(Vertex<T> vertex) {
        if (!hasPathTo(vertex)){
            return null;
        }
        LinkedList<Vertex<T>> list = new LinkedList<>();

        for (Vertex<T> i = vertex; i != source; i = edgeTo.get(i)) {
            list.push(i);
        }
        list.push(source);

        return list;
    }

    public int getCount() {
        return count;
    }
}

