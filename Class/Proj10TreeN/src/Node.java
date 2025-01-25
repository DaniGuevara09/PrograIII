import java.util.List;

public class Node <T>{
    private T info;
    private Node<T> sons;

    public Node(T info){
        this.info = info;
        this.sons = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public List<Node<T>> getSons(){
        return null;
    }

    public void addSon(Node<T> node){

    }
}
