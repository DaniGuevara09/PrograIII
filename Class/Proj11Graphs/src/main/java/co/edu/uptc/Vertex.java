package co.edu.uptc;

import java.util.ArrayList;
import java.util.List;

public class Vertex <T> {
    private T info;
    private boolean visited;
    private final List<Vertex<T>> adjacent;

    public Vertex(T info) {
        adjacent = new ArrayList<>();
        this.info = info;
        this.visited = false;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public T getInfo() {
        return info;
    }

    public boolean isVisited() {
        return visited;
    }

    public boolean isAdjacent(Vertex<T> vertex) {
        return adjacent.contains(vertex);
    }

    public boolean addVertex(Vertex<T> vertex) {
        if (!isAdjacent(vertex)) {
            adjacent.add(vertex);
            return true;
        }
        return false;
    }

    public List<Vertex<T>> getAdjacent() {
        return adjacent;
    }
}
