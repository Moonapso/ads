package graph;

import java.util.HashSet;
import java.util.Set;

public class MyGraph <T> {
    private final boolean undirected;
    private final Set<Vertex<T>> vertices;

    public MyGraph() {
        undirected = true;
        vertices = new HashSet<>();
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
        vertices = new HashSet<>();
    }

    public void addVertex(T data) {
        Vertex<T> newVertex = new Vertex<>(data);
        vertices.add(newVertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination) {
        source.addEdge(destination, 0D);
        if (undirected) {
            destination.addEdge(source, 0D);
        }
    }

    public int vertexNumber() {
        return vertices.size();
    }

    public int edgeNumber() {
        int count = 0;
        for (Vertex<T> vertex : vertices) {
            int verticesCount = vertex.vertexDegree();
            count += verticesCount;
        }
        if (undirected){
            count = count/2;
        }
        return count;
    }

    public boolean hasVertex(Vertex<T> vertex){
        return vertices.contains(vertex);
    }

    public boolean hasEdge(Vertex<T> source, Vertex<T> destination){
        return source.hasAdjacentVertex(destination);
    }

    public Set<Vertex<T>> adjacencyList(Vertex<T> vertex){
        return vertex.getAdjacentVertices();
    }
}
