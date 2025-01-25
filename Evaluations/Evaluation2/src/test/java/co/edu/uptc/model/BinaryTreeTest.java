package co.edu.uptc.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Car> bts;

    void setup() {
        bts = new BinaryTree<>((car1,car2)->car1.getPlate().compareTo(car2.getPlate()));
        bts.addNode( new Car("JIA764","Renault 4",1977,"Verde Militar"));
        bts.addNode( new Car("JJJ708","Renault 9",1989,"Azul Tormenta"));
        bts.addNode( new Car("NOT560","Chevrolet Aveo",2007,"Rojo Destello"));
        bts.addNode( new Car("DZW615","Kia Pikanto",2018,"Gris"));
        bts.addNode( new Car("HPV990","Chevrolet ONix",2022,"Gris Satin"));
        bts.addNode( new Car("BWG737","Chevrolet Corsa Evolution",2004,"Gris Ratón"));
        bts.addNode( new Car("HWY818","Nissan Versa",2014,"Blanco"));
        bts.addNode( new Car("HPW707","Mazda CX5",2016,"Rojo Ferrari"));
        bts.addNode( new Car("JRL026","Honda CR-V",2021,"Plata"));
        bts.addNode( new Car("DYG504","Subaru Forester",2017,"Azul"));
        bts.addNode( new Car("USB065","BMW CX-3",2019,"Platas"));
        bts.addNode( new Car("TRM588","Renault Duster",2012,"Blanco"));
        bts.addNode( new Car("GSP404","Chevrolet Vitara",2010,"Rojo"));
    }

    @Test
    /**
     * Método que prueba la funcionalidad del método countJumps().
     * El Método countJumps(TreeNode<T>, TreeNode<T>) en la clase BinaryTree, retorna el número de saltos desde
     * un nodo origen a un nodo destino. No hay saltos (0) cuando el origen y destino son el mismo nodo.
     * Los valores que se pueden retornar son:
     * - 0 -> Los nodos origen y destino son los mismos
     * - Mayor que cero (0) -> Cuando se puede ir desde el nodo origen al nodo destino
     * - -1 -> No hay ruta desde el origen al destino
     */
    void countJumps(){
        setup();
        assertEquals(3,bts.countJumps( bts.findNode(new Car("DZW615",null,0,null)),bts.findNode(new Car("HPW707",null,0,null))));
        assertEquals(-1,bts.countJumps( bts.findNode(new Car("DZW615",null,0,null)),bts.findNode(new Car("TRM588",null,0,null))));
        assertEquals(-1,bts.countJumps( bts.findNode(new Car("GSP404",null,0,null)),bts.findNode(new Car("HPW707",null,0,null))));
        assertEquals(-1,bts.countJumps( bts.findNode(new Car("HPV990",null,0,null)),bts.findNode(new Car("TRM588",null,0,null))));
        assertEquals(0,bts.countJumps( bts.findNode(new Car("NOT560",null,0,null)),bts.findNode(new Car("NOT560",null,0,null))));
        assertEquals(0,bts.countJumps( bts.findNode(new Car("JIA764",null,0,null)),bts.findNode(new Car("JIA764",null,0,null))));
        assertEquals(1,bts.countJumps( bts.findNode(new Car("NOT560",null,0,null)),bts.findNode(new Car("JRL026",null,0,null))));
        assertEquals(-1,bts.countJumps( bts.findNode(new Car("NOT560",null,0,null)),bts.findNode(new Car("DZW615",null,0,null))));
        assertEquals(-1,bts.countJumps( bts.findNode(new Car("HPV990",null,0,null)),bts.findNode(new Car("TRM588",null,0,null))));
        assertEquals(4,bts.countJumps( bts.findNode(new Car("JIA764",null,0,null)),bts.findNode(new Car("HPW707",null,0,null))));
        assertEquals(-1,bts.countJumps( bts.findNode(new Car("HWY818",null,0,null)),bts.findNode(new Car("NOT560",null,0,null))));
        assertEquals(2,bts.countJumps( bts.findNode(new Car("DZW615",null,0,null)),bts.findNode(new Car("DYG504",null,0,null))));
    }

    @Test
    /**
     * Método que prueba la funcionalidad del método isLessBrandLeft()
     * El Método isLessBrandLeft(TreeNode<T>) en la clase BinaryTree retorna verdadero cuando el peso de la rama izquierda
     * es menor al peso de la rama derecha del nodo recibido, o false cuando el peso de la rama izquierda es
     * mayor al peso de la rama derecha
     */
    void lessBrandLeft(){
        setup();
        assertTrue( bts.isLessBrandLeft( bts.findNode( new Car("HPV990",null,0,null))));
        assertTrue( bts.isLessBrandLeft( bts.findNode( new Car("JJJ708",null,0,null))));
        assertFalse( bts.isLessBrandLeft( bts.findNode( new Car("HWY818",null,0,null))));
        assertFalse( bts.isLessBrandLeft( bts.findNode( new Car("JIA764",null,0,null))));
        assertTrue( bts.isLessBrandLeft( bts.findNode( new Car("NOT560",null,0,null))));
        bts.addNode( new Car("FEA123","Fiat",1980,"Azul"));
        assertFalse( bts.isLessBrandLeft( bts.findNode(new Car("FEA123",null,0,null))));
    }

    @Test
    /**
     * Método de prueba para la funcionalidad del Método getBrother
     * El Método getBrother en BinaryTree(TreeNode<T>), retorna el nodo hermano del parámetro, la raiz no tiene
     * hermano, entonces retorna null.
     * Si el parámetro no tiene hermano, retorna null
     */
    void getBrother(){
        setup();
        assertNotNull(bts.getBrother( bts.findNode( new Car("JRL026",null,0,null))));
        assertEquals("USB065",bts.getBrother(bts.findNode(new Car("JRL026",null,0,null))).getInfo().getPlate());
        assertNull( bts.getBrother( bts.findNode( new Car("TRM588",null,0,null))));
        assertNull( bts.getBrother( bts.findNode( new Car("JIA764",null,0,null))));
        assertEquals("GSP404",bts.getBrother(bts.findNode(new Car("HWY818",null,0,null))).getInfo().getPlate());
        assertNull(bts.getBrother( bts.findNode( new Car("HPW707",null,0,null))));
    }

    @Test
    /**
     * Metodo que prueba la destrucción del árbol borrando nodos
     */
    void destroyTree(){
        setup();
        assertEquals(1,bts.levelNode( bts.findNode( new Car("JJJ708",null,0,null))));
        assertEquals("JIA764",bts.deleteNode( bts.findNode(new Car("JIA764",null,0,null))).getPlate());
        assertEquals(0,bts.levelNode( bts.findNode( new Car("JJJ708",null,0,null))));
        assertEquals(1989,bts.findFather( bts.findNode( new Car("DZW615",null,0,null))).getInfo().getModel());
        assertEquals(3,bts.levelNode( bts.findNode( new Car("TRM588",null,0,null))));
        assertEquals("USB065",bts.findFather(bts.findNode(new Car("TRM588",null,0,null))).getInfo().getPlate());
        assertEquals("USB065",bts.deleteNode(bts.findNode( new Car("USB065",null,0,null))).getPlate());
        assertEquals(2007,bts.findFather(bts.findNode(new Car("TRM588",null,0,null))).getInfo().getModel());
        assertEquals(2,bts.levelNode( bts.findNode( new Car("TRM588",null,0,null))));
        assertEquals(4,bts.levelNode( bts.findNode( new Car("HPW707",null,0,null))));
        assertEquals("HWY818",bts.deleteNode( bts.findNode( new Car("HWY818",null,0,null))).getPlate());
        assertEquals(3,bts.levelNode( bts.findNode( new Car("HPW707",null,0,null))));
        assertNull(bts.findFather(bts.findNode(new Car("JJJ708",null,0,null))));
        assertEquals(3,bts.levelNode(bts.findNode( new Car("GSP404",null,0,null))));
        bts.deleteNode( bts.findNode( new Car("DZW615",null,0,null)));
        assertNull( bts.findNode( new Car("DZW615",null,0,null)));
        assertEquals(1,bts.levelNode(bts.findNode( new Car("GSP404",null,0,null))));
        assertFalse(bts.isEmpty());

        assertEquals("NOT560",bts.deleteNode(bts.findNode( new Car("NOT560",null,0,null))).getPlate());
        assertEquals("HPV990",bts.deleteNode(bts.findNode( new Car("HPV990",null,0,null))).getPlate());
        assertEquals("BWG737",bts.deleteNode(bts.findNode( new Car("BWG737",null,0,null))).getPlate());
        assertEquals("HPW707",bts.deleteNode(bts.findNode( new Car("HPW707",null,0,null))).getPlate());
        assertEquals("JRL026",bts.deleteNode(bts.findNode( new Car("JRL026",null,0,null))).getPlate());
        assertEquals("DYG504",bts.deleteNode(bts.findNode( new Car("DYG504",null,0,null))).getPlate());
        assertEquals("TRM588",bts.deleteNode(bts.findNode( new Car("TRM588",null,0,null))).getPlate());
        assertEquals("GSP404",bts.deleteNode(bts.findNode( new Car("GSP404",null,0,null))).getPlate());
        assertEquals("JJJ708",bts.deleteNode(bts.findNode( new Car("JJJ708",null,0,null))).getPlate());

        /**
         * TODO Escriba las instrucciones para borrar el resto de nodos
         * ..........
         */
        assertTrue( bts.isEmpty());
    }
}