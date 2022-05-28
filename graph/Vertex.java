package graph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex<T>{
    private final T data;
    private final Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;
        adjacentVertices = new HashMap<>();
    }

    public void addAdjacentVertex(Vertex<T> destination, double weight){
        adjacentVertices.put(destination,weight);
    }

    public void addEdge(Vertex<T> destination, Double weight){
        adjacentVertices.put(destination, weight);
    }

    public boolean hasAdjacentVertex(Vertex<T> vertex){
        return adjacentVertices.containsKey(vertex);
    }

    public Double getWeight(Vertex<T> vertex){
        return adjacentVertices.get(vertex);
    }

    public T getData(){
        return data;
    }

    public Set<Vertex<T>> getAdjacentVertices(){
        return adjacentVertices.keySet();
    }

    public int vertexDegree(){
        int count = 0;
        for (Vertex<T> vertex : adjacentVertices.keySet()){
            count++;
        }
        return count;
    }
}
