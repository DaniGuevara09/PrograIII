package co.edu.uptc.logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TreeNArioTest {

    private TreeNArio<Character> tree;

    void setUp(){
        tree = new TreeNArio<>((c1, c2) -> Character.compare(c1, c2));

        Node<Character> node = new Node<>('J');
        tree.addNode(null, 'J');
        tree.addNode(tree.findNode('J'), 'A');
        tree.addNode(tree.findNode('J'), 'I');
        tree.addNode(tree.findNode('J'), 'R');
        tree.addNode(tree.findNode('J'), 'O');

        tree.addNode(tree.findNode('A'), 'G');
        tree.addNode(tree.findNode('A'), 'L');

        tree.addNode(tree.findNode('R'), 'U');
        tree.addNode(tree.findNode('R'), 'N');
        tree.addNode(tree.findNode('R'), 'E');
        tree.addNode(tree.findNode('R'), 'S');
        tree.addNode(tree.findNode('R'), 'C');

        tree.addNode(tree.findNode('C'), 'M');
    }

    @Test
    void addNode() {
    }

    @Test
    void findNode() {
        setUp();
        assertNotNull(tree.findNode('J'));
        assertEquals('J', tree.findNode('J').getInfo());
        assertEquals('C', tree.findNode('C').getInfo());
        assertEquals('M', tree.findNode('M').getInfo());

        assertNull(tree.findNode('Z'));
        assertNull(tree.findNode('X'));
        assertNull(tree.findNode('Y'));
    }

    @Test
    void getSons() {
        setUp();
        System.out.println(tree.getSons(tree.findNode('J')));
        List<Character> list = new ArrayList<>();
        list.add('A');
        list.add('I');
        list.add('R');
        list.add('O');

        assertEquals(list, tree.getSons(tree.findNode('J')));
    }

    @Test
    void getTreeNArio() {
    }
}