package model;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinaryTree <T>{
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

        return 0;
    }

    public int heightNode( TreeNode<T> node){

        return 0;
    }

    private int height( TreeNode<T> root){

        return 0;
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
    public int levelNode( TreeNode<T> node ){

        return node == root ? 0 : levelNode( findFather( node) ) + 1;

    }
}
