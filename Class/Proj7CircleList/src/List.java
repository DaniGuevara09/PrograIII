import java.util.ArrayList;
import java.util.Comparator;

import static java.lang.Integer.parseInt;

public class List <T>{
    private Comparator<T> comparator;
    private Node<T> head;

    public List() {
    }

    public List(Comparator<T> comparator) {
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

    public java.util.List<T> getList(){
        Node<T> aux = head;
        java.util.List<T> result = new ArrayList<>();
        do{
            result.add(aux.getNext().getInfo());
            aux = aux.getNext();
        }while( aux != head );

        return result;
    }

    public String jumping(){
        // 2 3 1 2  2 3 1 2
        Node<T> aux = head;

        java.util.List<T> num = new ArrayList<>();

        String numStr = (String) head.getInfo();
        int pos = 0;



        for (int i = 0; i < numStr.length(); i++) {
            System.out.println(numStr.substring(i, i+1));
            pos = (pos + parseInt(numStr.substring(i , i + 1)));
            System.out.println("Pos: " + pos);
        }


        return "";
    }
}
