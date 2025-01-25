package co.edu.uptc.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class TreeNArio <T>{
    private Comparator<T> comparator;
    private Node<T> root;

    public TreeNArio(Comparator<T> comparator){
        this.comparator = comparator;
        this.root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void addNode(Node<T> father, T info){
        if (isEmpty()){
            root = new Node<>(info);
        } else {
            father.addSon(new Node<>(info));
        }
    }

    public Node<T> findNode(T info){
        return find(root,info);
    }

    private Node<T> find(Node<T> node, T info){
        if(node != null){
            if (comparator.compare(info, node.getInfo()) == 0){
                return node;
            } else {
                List<Node<T>> sons = node.getSons();
                Iterator<Node<T>> it = sons.iterator();

                while(it.hasNext()){
                    Node<T> aux = it.next();

                    if (find(aux, info) != null){
                        return find(aux,info);
                    }
                }
                return null;
            }
        }
        return null;
    }

    public List<T> getSons(Node<T> node){
        List<T> sons = new ArrayList<>();

        for (int i = 0; i < node.getSons().size(); i++) {
            sons.add(node.getSons().get(i).getInfo());
        }
        return sons;
    }

    public List<T> getTreeNArio(){
        return null;
    }
}
