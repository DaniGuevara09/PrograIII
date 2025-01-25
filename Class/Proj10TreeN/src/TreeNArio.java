import java.util.Comparator;
import java.util.List;

public class TreeNArio <T>{
    private Comparator<T> comparator;
    private Node<T> root;

    public TreeNArio(Comparator<T> comparator){
        this.comparator = comparator;
    }

    public boolean isEmpty(){
        return false;
    }

    public void addNode(Node<T> node, T info){

    }

    public Node<T> findNode(T info){
        return null;
    }

    private Node<T> find(Node<T> node, T info){
        return null;
    }

    public List<T> getSons(Node<T> node){
        return null;
    }

    public List<T> getTreeNArio(){
        return null;
    }
}
