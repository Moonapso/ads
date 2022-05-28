package graph;

import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<T> {
    private final boolean undirected;
    private final Set<Vertex<T>> vertices;

    public WeightedGraph() {
        undirected = true;
        vertices = new HashSet<>();
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        vertices = new HashSet<>();
    }

    public void addVertex(Vertex<T> vertex){
        vertices.add(vertex);
    }

    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight){
        source.addEdge(destination,weight);
        if(undirected){
            destination.addEdge(source,weight);
        }
    }

    public int vertexNumber(){
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

    public boolean hasVertex (Vertex<T> vertex){
        return vertices.contains(vertex);
    }
    public boolean hasEdge (Vertex<T> source, Vertex<T> destination){
        return source.hasAdjacentVertex(destination);
    }
    public Set<Vertex<T>> adjacencyList(Vertex<T> vertex){
        if (!hasVertex(vertex)){
            return null;
        }
        return vertex.getAdjacentVertices();
    }
}
