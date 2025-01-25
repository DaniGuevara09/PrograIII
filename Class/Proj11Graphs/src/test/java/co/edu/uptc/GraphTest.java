package co.edu.uptc;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph<Character> graph;

    void setup(){
        graph = new Graph<>((c1, c2) -> Character.compare(c1, c2));
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
    }

    void setup2(){
        setup();
        graph.addEdge(graph.findVertex('A'), graph.findVertex('B'), Graph.INDIRECT);
        graph.addEdge(graph.findVertex('A'), graph.findVertex('C'), Graph.INDIRECT);
        graph.addEdge(graph.findVertex('A'), graph.findVertex('D'), Graph.INDIRECT);
        graph.addEdge(graph.findVertex('B'), graph.findVertex('D'), Graph.INDIRECT);
    }

    @Test
    void addVertex() {
        setup();
        assertFalse(graph.addVertex('A'));
        assertFalse(graph.addVertex('B'));
        assertFalse(graph.addVertex('C'));
        assertFalse(graph.addVertex('D'));

        assertTrue(graph.addVertex('J'));
        assertTrue(graph.addVertex('R'));
        assertTrue(graph.addVertex('G'));
        assertTrue(graph.addVertex('S'));
    }

    @Test
    void addEdge() {
        setup();
        graph.addEdge(graph.findVertex('A'), graph.findVertex('B'), Graph.INDIRECT);
        graph.addEdge(graph.findVertex('A'), graph.findVertex('C'), Graph.INDIRECT);
        graph.addEdge(graph.findVertex('A'), graph.findVertex('D'), Graph.INDIRECT);
        graph.addEdge(graph.findVertex('B'), graph.findVertex('D'), Graph.INDIRECT);

        assertTrue(graph.isAdjacent(graph.findVertex('A'), graph.findVertex('B')));
        assertTrue(graph.isAdjacent(graph.findVertex('B'), graph.findVertex('A')));

        assertTrue(graph.isAdjacent(graph.findVertex('A'), graph.findVertex('C')));
        assertTrue(graph.isAdjacent(graph.findVertex('C'), graph.findVertex('A')));

        assertTrue(graph.isAdjacent(graph.findVertex('A'), graph.findVertex('D')));
        assertTrue(graph.isAdjacent(graph.findVertex('D'), graph.findVertex('A')));

        assertTrue(graph.isAdjacent(graph.findVertex('B'), graph.findVertex('D')));
        assertTrue(graph.isAdjacent(graph.findVertex('D'), graph.findVertex('B')));

        assertFalse(graph.isAdjacent(graph.findVertex('B'), graph.findVertex('C')));
        assertFalse(graph.isAdjacent(graph.findVertex('C'), graph.findVertex('B')));
        assertFalse(graph.isAdjacent(graph.findVertex('C'), graph.findVertex('D')));
        assertFalse(graph.isAdjacent(graph.findVertex('D'), graph.findVertex('C')));
    }

    @Test
    void findVertex() {
        setup();
        assertNotNull(graph.findVertex('A'));
        assertNotNull(graph.findVertex('B'));
        assertNotNull(graph.findVertex('C'));
        assertNotNull(graph.findVertex('D'));

        assertEquals('A', graph.findVertex('A').getInfo());
        assertEquals('B', graph.findVertex('B').getInfo());
        assertEquals('C', graph.findVertex('C').getInfo());
        assertEquals('D', graph.findVertex('D').getInfo());

        assertNull(graph.findVertex('J'));
        assertNull(graph.findVertex('R'));
        assertNull(graph.findVertex('G'));
        assertNull(graph.findVertex('S'));
    }

    @Test
    void getAdjacents() {
    }

    @Test
    void listGraph() {
    }

    @Test
    void isAdjacent() {
    }
}