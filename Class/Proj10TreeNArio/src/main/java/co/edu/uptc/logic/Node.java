package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.List;

public class Node <T>{
    private T info;
    private List<Node<T>> sons;

    public Node(T info){
        this.info = info;
        sons = new ArrayList<>();
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public List<Node<T>> getSons(){
        return sons;
    }

    public void addSon(Node<T> node){
        sons.add(node);
    }
}
