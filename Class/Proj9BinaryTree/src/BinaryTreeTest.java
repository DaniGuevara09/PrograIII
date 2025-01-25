import org.junit.jupiter.api.Test;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class BinaryTreeTest {

    private BinaryTree<Integer> binaryTree;

    void setUp() {
        Comparator<Integer> comparator = Integer::compareTo;
        binaryTree = new BinaryTree<>(comparator);

        binaryTree.addNode(50);
        binaryTree.addNode(30);
        binaryTree.addNode(60);
        binaryTree.addNode(20);
        binaryTree.addNode(35);
        binaryTree.addNode(58);
        binaryTree.addNode(70);
    }

    void setUp2() {
        Comparator<Integer> comparator = Integer::compareTo;
        binaryTree = new BinaryTree<>(comparator);

        binaryTree.addNode(50);
        binaryTree.addNode(10);
        binaryTree.addNode(69);
        binaryTree.addNode(5);
        binaryTree.addNode(34);
        binaryTree.addNode(57);
        binaryTree.addNode(18);
        binaryTree.addNode(40);
        binaryTree.addNode(63);
    }

    @Test
    void addNode() {
        setUp();

        assertNotNull(binaryTree.findNode(50));
        assertNotNull(binaryTree.findNode(30));
        assertNotNull(binaryTree.findNode(60));
        assertNotNull(binaryTree.findNode(20));
        assertNotNull(binaryTree.findNode(35));
        assertNotNull(binaryTree.findNode(58));
        assertNotNull(binaryTree.findNode(70));
        assertNull(binaryTree.findNode(51));
    }

    @Test
    void listPresort() {
        setUp();
        List<Integer> pre = binaryTree.listPresort();
        assertArrayEquals(new Integer[]{50, 30, 20, 35, 60, 58, 70}, pre.toArray());
    }

    @Test
    void listInsort() {
        setUp();
        List<Integer> in = binaryTree.listInsort();
        assertArrayEquals(new Integer[]{20, 30, 35, 50, 58, 60, 70}, in.toArray());
    }

    @Test
    void listPosort() {
        setUp();
        List<Integer> post = binaryTree.listPosort();
        assertArrayEquals(new Integer[]{20, 35, 30, 58, 70, 60, 50}, post.toArray());
    }

    @Test
    void listPre() {
        setUp();
        List<Integer> pre = binaryTree.preList();
        assertArrayEquals(new Integer[]{50, 30, 60, 20, 35, 58, 70}, pre.toArray());
    }

    @Test
    void listIn() {
        setUp();
        List<Integer> in = binaryTree.inList();
        assertArrayEquals(new Integer[]{50, 60, 30, 70, 58, 35, 20}, in.toArray());
    }

    @Test
    void listPost() {
        setUp();
        List<Integer> post = binaryTree.postList();
        assertArrayEquals(new Integer[]{20, 35, 58, 70, 30, 60, 50}, post.toArray());
    }

    @Test
    void listAmplitude(){
        setUp2();

        List <Integer> list = binaryTree.listAmplitudeDown();
        assertEquals(9, list.size());
        assertEquals(50, list.getFirst());
        assertEquals(63, list.get(8));
        assertEquals(5, list.get(3));
    }


    // 50, 30, 60, 20, 35, 58, 70
    @Test
    void deleteNode() {

        setUp();
        TreeNode<Integer> node = binaryTree.findNode(20);

        binaryTree.deleteNode(node);
        List<Integer> list = binaryTree.listAmplitudeDown();

        assertArrayEquals(new Integer[]{50, 30, 60, 35, 58, 70}, list.toArray());
        assertNull(binaryTree.findNode(20));

        setUp2();
        binaryTree.deleteNode(binaryTree.findNode(18));
        list = binaryTree.listAmplitudeDown();
        assertNull(binaryTree.findNode(18));
        assertArrayEquals(new Integer[]{50, 10, 69, 5, 34, 57, 40, 63}, list.toArray());

        binaryTree.deleteNode(binaryTree.findNode(57));
        list = binaryTree.listAmplitudeDown();
        assertNull(binaryTree.findNode(57));
        assertArrayEquals(new Integer[]{50, 10, 69, 5, 34, 63, 40}, list.toArray());

        binaryTree.deleteNode(binaryTree.findNode(10));
        list = binaryTree.listAmplitudeDown();
        assertNull(binaryTree.findNode(10));
        assertArrayEquals(new Integer[]{50, 34, 69, 5, 40, 63}, list.toArray());
    }

    @Test
    void listAmplitudeTop() {
        setUp();
        assertArrayEquals(new Integer[]{50, 30, 60, 20, 35, 58, 70}, binaryTree.listAmplitudeDown().toArray());
        assertArrayEquals(new Integer[]{70, 58, 35, 20, 60, 30, 50}, binaryTree.listAmplitudeTop().toArray());

        setUp2();
        assertArrayEquals(new Integer[]{50, 10, 69, 5, 34, 57, 18, 40, 63}, binaryTree.listAmplitudeDown().toArray());
        assertArrayEquals(new Integer[]{63, 40, 18, 57, 34, 5, 69, 10, 50}, binaryTree.listAmplitudeTop().toArray());
    }
}