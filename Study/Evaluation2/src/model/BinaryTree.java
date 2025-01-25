package model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree <T> {
    private Comparator<T> comparator;
    private TreeNode<T> root;
    private List<T> list;

    public BinaryTree(Comparator<T> comparator) {
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
    public void addNode(T info){
        TreeNode<T> node = new TreeNode<>( info );
        if( isEmpty()){
            root = node;
        }else{
            TreeNode<T> aux = root;
            TreeNode<T> father = null;
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
    public TreeNode<T> findNode(T info){

        TreeNode<T> aux = root;
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

    public int heightNode( TreeNode<T> node){
        return height(node);
    }

    private int height( TreeNode<T> node){
        if( node == null ) return 0;

        int left = height(node.getLeft());
        int right = height(node.getRight());

        return left > right ? left + 1 : right + 1;
    }

    public int weightTree(){
        return weight(root);
    }

    private int weight( TreeNode<T> node){
        if (node == null) return 0;
        return weight(node.getLeft()) + weight(node.getRight()) + 1;
    }

    public int levelNode( TreeNode<T> node ){
        return node == root ? 0 : levelNode( findFather( node) ) + 1;
    }

    public boolean isLeaf(TreeNode<T> node){
        return node.getLeft() == null && node.getRight() == null;
    }

    public byte gradeNode(TreeNode<T> node){
        if (node.getRight() == null && node.getLeft() == null) {
            return 0;
        } else if (node.getRight() != null && node.getLeft() != null) {
            return 2;
        }
        return 1;
    }

    public List<T> listPresort(){
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
    private void presort(TreeNode<T> root) {
        if( root != null ){
            list.add( root.getInfo() );
            presort( root.getLeft( ) );
            presort( root.getRight( ) );
        }
    }

    public List<T> listInsort(){
        list = new ArrayList<>();
        insort(root);
        return list;
    }

    /**
     * A - I - J - O - R
     * @param root
     */
    private void insort(TreeNode<T> root) {
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
    public List<T> listPosort(){
        list = new ArrayList<>();
        posort(root);
        return list;
    }

    private void posort(TreeNode<T> root) {
        if( root != null ){
            posort( root.getLeft( ) );
            posort( root.getRight( ) );
            list.add( root.getInfo() );
        }
    }

    public List<T> preList(){
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

    private void pre(TreeNode<T> root) {
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

    public List<T> inList(){
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

    private void in(TreeNode<T> root) {
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

    public List<T> postList(){
        list = new ArrayList<>();
        if (root != null) {

            post(root);
            list.add(root.getInfo());
        }
        return list;
    }

    private void post(TreeNode<T> root) {
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

    public List<T> listAmplitudeDown() {
        ArrayDeque<TreeNode<T>> deque = new ArrayDeque<>();
        list = new ArrayList<>();
        deque.add(root);

        TreeNode<T> aux = null;

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

    public List<T> listAmplitudeTop() {
        list = new ArrayList<>(listAmplitudeDown());

        ArrayList <T> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            newList.add(list.get(i));
        }
        return newList;
    }

    public TreeNode<T> findFather( TreeNode<T> node ){
        if( node != root ){
            TreeNode<T> aux = root;
            while( aux.getLeft() != node && aux.getRight() != node ){
                aux = comparator.compare( aux.getInfo(),node.getInfo()) > 0 ? aux.getLeft() : aux.getRight();
            }
            return aux;
        }
        return null;
    }

    public T deleteNode(TreeNode<T> node){
        return switch (gradeNode(node)) {
            case 0 -> deleteLeaft(node);
            case 1 -> deleteWithSon(node);
            default -> deleteWithSons(node);
        };
    }

    private T deleteLeaft(TreeNode<T> node){
        T info = node.getInfo();

        if (node == root){
            root = null;
        } else {
            TreeNode <T> father = findFather(node);

            if (father.getLeft() == node){
                father.setLeft(null);
            } else if (father.getRight() == node) {
                father.setRight(null);
            }
        }
        return info;
    }

    private T deleteWithSon(TreeNode<T> node){
        if (node == root){
            root = node.getLeft() != null ? node.getLeft() : node.getRight();

        } else {
            TreeNode <T> father = findFather(node);

            if (father.getLeft() == node){
                father.setLeft(node.getLeft() != null ? node.getLeft() : node.getRight());
            } else {
                father.setRight(node.getLeft() != null ? node.getLeft() : node.getRight());
            }
        }
        return node.getInfo();
    }

    private T deleteWithSons(TreeNode<T> node){
        TreeNode<T> sustitute = node.getRight();
        TreeNode<T> fatherSustitute = null;

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
            TreeNode<T> father = findFather(node);

            if (father.getLeft() == node){
                father.setLeft(sustitute);
            } else {
                father.setRight(sustitute);
            }
        }
        return node.getInfo();
    }
}