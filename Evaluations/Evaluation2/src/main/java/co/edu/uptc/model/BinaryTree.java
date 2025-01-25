package co.edu.uptc.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree <Car> {
    private Comparator<Car> comparator;
    private TreeNode<Car> root;
    private List<Car> list;

    public BinaryTree(Comparator<Car> comparator) {
        this.comparator = comparator;
        this.root = null;
    }

    /**
     * Método que valida si el árbol está vacío
     * @return verdadero si está vacío, falso, si no está vacío
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     * Método que permite agregar un nodo
     * @param info especifica la información del nodo
     */
    public void addNode(Car info){
        TreeNode<Car> node = new TreeNode<>( info );
        if( isEmpty()){
            root = node;
        }else{
            TreeNode<Car> aux = root;
            TreeNode<Car> father = null;
            while( aux != null){
                father = aux;
                aux = comparator.compare( aux.getInfo(),info) > 0 ? aux.getLeft() : aux.getRight();
            }
            if ( comparator.compare( father.getInfo(), info ) > 0 ){
                father.setLeft( node );
            }else{
                father.setRight( node );
            }
        }
    }

    /**
     * Método que busca un nodo
     * @param info especifica el valor de la clave a buscar
     * @return El nodo si existe, si no, retorna null
     */
    public TreeNode<Car> findNode(Car info){

        TreeNode<Car> aux = root;
        while( aux != null ){
            if( comparator.compare( aux.getInfo(), info) == 0 ){
                return aux;
            }
            aux = comparator.compare( info, aux.getInfo()) < 0 ? aux.getLeft() : aux.getRight();
        }
        return null;
    }

    public int heightTree(){
        return height(root);
    }

    public int heightNode( TreeNode<Car> node){
        return height(node);
    }

    private int height( TreeNode<Car> node){
        if( node == null ) return 0;

        int left = height(node.getLeft());
        int right = height(node.getRight());

        return left > right ? left + 1 : right + 1;
    }

    public int weightTree(){
        return weight(root);
    }

    private int weight( TreeNode<Car> node){
        if (node == null) return 0;
        return weight(node.getLeft()) + weight(node.getRight()) + 1;
    }

    public int levelNode( TreeNode<Car> node ){
        return node == root ? 0 : levelNode( findFather( node) ) + 1;
    }

    public boolean isLeaf(TreeNode<Car> node){
        return node.getLeft() == null && node.getRight() == null;
    }

    public byte gradeNode(TreeNode<Car> node){
        if (node.getRight() == null && node.getLeft() == null) {
            return 0;
        } else if (node.getRight() != null && node.getLeft() != null) {
            return 2;
        }
        return 1;
    }

    public List<Car> listPresort(){
        list = new ArrayList<>();
        presort(root);
        return list;
    }

    /**
     *              J
     *        A         R
     *          I   O
     * @param root
     *  J - A - I - R - O
     */
    private void presort(TreeNode<Car> root) {
        if( root != null ){
            list.add( root.getInfo() );
            presort( root.getLeft( ) );
            presort( root.getRight( ) );
        }
    }

    public List<Car> listInsort(){
        list = new ArrayList<>();
        insort(root);
        return list;
    }

    /**
     * A - I - J - O - R
     * @param root
     */
    private void insort(TreeNode<Car> root) {
        if( root != null ){
            insort( root.getLeft( ) );
            list.add( root.getInfo() );
            insort( root.getRight( ) );
        }
    }

    /**
     * I - A - O - R - J
     * @return
     */
    public List<Car> listPosort(){
        list = new ArrayList<>();
        posort(root);
        return list;
    }

    private void posort(TreeNode<Car> root) {
        if( root != null ){
            posort( root.getLeft( ) );
            posort( root.getRight( ) );
            list.add( root.getInfo() );
        }
    }

    public List<Car> preList(){
        list = new ArrayList<>();
        if (root != null) {
            list.add(root.getInfo());

            if (root.getLeft() != null) {
                list.add(root.getLeft().getInfo());
            }
            if (root.getRight() != null) {
                list.add(root.getRight().getInfo());
            }

            pre(root.getLeft());
            pre(root.getRight());
        }
        return list;
    }

    private void pre(TreeNode<Car> root) {
        if (root != null) {
            if (root.getLeft() != null) {
                list.add(root.getLeft().getInfo());
            }

            if (root.getRight() != null) {
                list.add(root.getRight().getInfo());
            }

            pre(root.getLeft());
            pre(root.getRight());
        }
    }

    public List<Car> inList(){
        list = new ArrayList<>();
        if (root != null) {
            list.add(root.getInfo());

            if (root.getRight() != null) {
                list.add(root.getRight().getInfo());
            }
            if (root.getLeft() != null) {
                list.add(root.getLeft().getInfo());
            }

            in(root.getRight());
            in(root.getLeft());
        }
        return list;
    }

    private void in(TreeNode<Car> root) {
        if (root != null) {
            if (root.getRight() != null) {
                list.add(root.getRight().getInfo());
            }
            if (root.getLeft() != null) {
                list.add(root.getLeft().getInfo());
            }

            in(root.getRight());
            in(root.getLeft());
        }
    }

    public List<Car> postList(){
        list = new ArrayList<>();
        if (root != null) {

            post(root);
            list.add(root.getInfo());
        }
        return list;
    }

    private void post(TreeNode<Car> root) {
        if (root != null) {
            if (root.getLeft() != null) {
                post(root.getLeft());
            }

            if (root.getRight() != null) {
                post(root.getRight());
                if (root.getLeft() != null) {
                    list.add(root.getLeft().getInfo());
                }
                list.add(root.getRight().getInfo());
            }
        }
    }

    public List<Car> listAmplitudeDown() {
        ArrayDeque<TreeNode<Car>> deque = new ArrayDeque<>();
        list = new ArrayList<>();
        deque.add(root);

        TreeNode<Car> aux = null;

        while (!deque.isEmpty()){
            aux = deque.poll();

            if (aux.getLeft() != null) {
                deque.add(aux.getLeft());
            }
            if (aux.getRight() != null) {
                deque.add(aux.getRight());
            }

            list.add(aux.getInfo());
        }
        return list;
    }

    public List<Car> listAmplitudeTop() {
        list = new ArrayList<>(listAmplitudeDown());

        ArrayList <Car> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public TreeNode<Car> findFather( TreeNode<Car> node ){
        if( node != root ){
            TreeNode<Car> aux = root;
            while( aux.getLeft() != node && aux.getRight() != node ){
                aux = comparator.compare( aux.getInfo(),node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            return aux;
        }
        return null;
    }

    public Car deleteNode(TreeNode<Car> node){
        return switch (gradeNode(node)) {
            case 0 -> deleteLeaft(node);
            case 1 -> deleteWithSon(node);
            default -> deleteWithSons(node);
        };
    }

    private Car deleteLeaft(TreeNode<Car> node){
        Car info = node.getInfo();

        if (node == root){
            root = null;
        } else {
            TreeNode <Car> father = findFather(node);

            if (father.getLeft() == node){
                father.setLeft(null);
            } else if (father.getRight() == node) {
                father.setRight(null);
            }
        }
        return info;
    }

    private Car deleteWithSon(TreeNode<Car> node){
        if (node == root){
            root = node.getLeft() != null ? node.getLeft() : node.getRight();

        } else {
            TreeNode <Car> father = findFather(node);

            if (father.getLeft() == node){
                father.setLeft(node.getLeft() != null ? node.getLeft() : node.getRight());
            } else {
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return node.getInfo();
    }

    private Car deleteWithSons(TreeNode<Car> node){
        TreeNode<Car> sustitute = node.getRight();
        TreeNode<Car> fatherSustitute = null;

        while (sustitute.getLeft() != null){
            fatherSustitute = sustitute;
            sustitute = sustitute.getLeft();
        }

        if (fatherSustitute != null){
            fatherSustitute.setLeft(sustitute.getRight());
            sustitute.setRight(node.getRight());
        }
        sustitute.setLeft(node.getLeft());

        if (node == root){
            root = sustitute;
        } else {
            TreeNode<Car> father = findFather(node);

            if (father.getLeft() == node){
                father.setLeft(sustitute);
            } else {
                father.setRight(sustitute);
            }
        }
        return node.getInfo();
    }
    /*
    int jump = 0;
    public int countJumps(TreeNode<Car> node1, TreeNode<Car> node2) {
        TreeNode<Car> right = node1.getRight();
        TreeNode<Car> left = node1.getLeft();
        TreeNode<Car> aux = node1;

        int jumps = 0;
        if (node1 == node2){
            return 0;
        }

        while (node1 != null){
            jump++;
            if (node1)
        }

        while (aux.getRight() != null || aux.getLeft() != null){
            if (aux.getRight() == node2){
                jumps++;
            } else{
                System.out.println("Llegaaa");
                aux = aux.getRight();
            }

            if (node1.getLeft() == node2){
                jumps++;
            } else{
                node1 = node1.getLeft();
            }
        }
        return -1;
    }*/

    int jump = 1;
    public int countJumps(TreeNode<Car> node1, TreeNode<Car> node2) {
        if (node1 == node2) {
            return 0;
        } else {
            jump(node1, node2);
            return jump;
        }
    }

    private void jump(TreeNode<Car> node1, TreeNode<Car> node2) {

        if( node1 != null && node2 != null){
            System.out.println(node1.getInfo().toString());
            jump++;
            countJumps( node1.getLeft( ), node2);
            System.out.println("Pasa");
            countJumps( node2.getRight( ), node2 );
            //jump = -1;
        }
    }

    public boolean isLessBrandLeft(TreeNode<Car> node) {
        return heightNode(node.getLeft()) < heightNode(node.getRight());
    }

    public TreeNode<Car> getBrother(TreeNode<Car> node) {
        if (node == null || node == root) {
            return null;
        }

        TreeNode<Car> father = findFather(node);

        // Retorna el hermano (izquierdo o derecho)
        if (father.getLeft() != null && father.getLeft() != node) {
            return father.getLeft();
        } else if (father.getRight() != null && father.getRight() != node) {
            return father.getRight();
        }

        return null;
    }
}