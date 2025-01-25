package logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListCircled <T>{
    private Comparator<T> comparator;
    private Node<T> head;

    public ListCircled(Comparator<T> comparator) {
        this.comparator = comparator;
        this.head = null;
    }

    private boolean isEmpty(){
        return head == null;
    }

    public void addNodeLast( T info ){
        Node<T> nodeNew = new Node<T>(info);
        if( isEmpty() ){
            head = nodeNew;
            head.setNext( head );
        }else{
            nodeNew.setNext( head.getNext());
            head.setNext( nodeNew );
            head = nodeNew;
        }
    }

    public void addNodeBegin( T info ){

    }

    public Node<T> findNode( T info ){
        Node<T> aux = head;
        do{
            if( comparator.compare( info, aux.getNext().getInfo()) == 0){

                return aux.getNext();
            }
            aux = aux.getNext();
        }while( aux != head );

        return null;
    }

    public List<T> getList(){
        Node<T> aux = head;
        List<T> result = new ArrayList<>();
        do{
            result.add(aux.getNext().getInfo());
            aux = aux.getNext();
        }while( aux != head );

        return result;
    }

    /**
     * Método que bla bla
     * @param node
     * @return loren ipsum
     */
    public List<T> getListForNode( Node<T> node){

        return null;
    }

}
