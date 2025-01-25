package co.edu.uptc;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {

    private Vertex<Character> vertexA;
    private Vertex<Character> vertexB;
    private Vertex<Character> vertexC;
    private Vertex<Character> vertexD;

    void setup(){
        vertexA = new Vertex<>('A');
        vertexB = new Vertex<>('B');
        vertexC = new Vertex<>('C');
        vertexD = new Vertex<>('D');

        vertexA.addVertex(vertexB);
        vertexA.addVertex(vertexC);
        vertexA.addVertex(vertexD);

        vertexB.addVertex(vertexA);
        vertexB.addVertex(vertexD);

        vertexD.addVertex(vertexA);
        vertexD.addVertex(vertexB);

        vertexC.addVertex(vertexA);
    }

    @org.junit.jupiter.api.Test
    void isAdjacent() {
        setup();
        assertTrue(vertexA.isAdjacent(vertexB));
        assertTrue(vertexA.isAdjacent(vertexC));
        assertTrue(vertexA.isAdjacent(vertexD));

        assertFalse(vertexC.isAdjacent(vertexB));
        assertFalse(vertexC.isAdjacent(vertexD));

        assertTrue(vertexB.isAdjacent(vertexA));
        assertTrue(vertexB.isAdjacent(vertexD));

        assertTrue(vertexD.isAdjacent(vertexA));
        assertTrue(vertexD.isAdjacent(vertexB));

        vertexB.addVertex(vertexC);
        assertTrue(vertexB.isAdjacent(vertexC));
        assertFalse(vertexC.isAdjacent(vertexB));
    }

    @org.junit.jupiter.api.Test
    void addVertex() {
        setup();
        assertFalse(vertexA.addVertex(vertexC));
        assertFalse(vertexA.addVertex(vertexD));
        assertFalse(vertexA.addVertex(vertexB));

    }

    @org.junit.jupiter.api.Test
    void getAdjacent() {
        setup();
        assertEquals(3, vertexA.getAdjacent().size());
        assertEquals(1, vertexC.getAdjacent().size());
        assertEquals(2, vertexB.getAdjacent().size());
        assertEquals(2, vertexD.getAdjacent().size());
    }
}