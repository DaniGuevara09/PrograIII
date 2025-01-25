package co.edu.uptc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Graph <T>{
    public static final int INDIRECT = 1;
    public static final int DIRECT = 0;
    private Comparator <T> comparator;
    private List<Vertex<T>> vertexList;

    public Graph(Comparator <T> comparator) {
        this.comparator = comparator;
        vertexList = new ArrayList<>();
    }

    public boolean addVertex(T info){
        if (findVertex(info) == null){
            vertexList.add(new Vertex<>(info));
            return true;
        }
        return false;
    }

    public boolean addEdge(Vertex<T> source, Vertex<T> target, int mode){
        // Agragar como adyacente el destino al origen cuando es directo, o en ambos sentidos cuendo es indirecto
        if (!source.isAdjacent(target)) {
            source.addVertex(target);
            if (mode == INDIRECT) {
                target.addVertex(source);
            }
            return true;
        }
        return false;
    }

    public Vertex <T> findVertex(T info){
        for (Vertex<T> v : vertexList) {
            if (comparator.compare(info, v.getInfo()) == 0){
                return v;
            }
        }
        return null;
    }

        public List<T> getAdjacents(Vertex<T> vertex){
        List<T> list = new ArrayList<>();
        for (Vertex<T> vertexAux : vertex.getAdjacent()) {
            list.add(vertexAux.getInfo());
        }
        return list;
    }

    public List<T> listGraph(Vertex<T> vertex){
        List<T> list = new ArrayList<>();
        for (Vertex<T> vertexAux : vertex.getAdjacent()) {
            list.add(vertexAux.getInfo());
        }
        return null;
    }

    public boolean isAdjacent(Vertex<T> source, Vertex<T> target){
        return source.isAdjacent(target);
    }

    public void setNotVisited(){
        for (Vertex<T> v : vertexList){
            v.setVisited(false);
        }
    }
}
