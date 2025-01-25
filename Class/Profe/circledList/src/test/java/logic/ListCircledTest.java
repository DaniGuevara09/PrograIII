package logic;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListCircledTest {
    private ListCircled<Character> list;
    private ListCircled<Dish> listDishes;

    void setup(){
        list = new ListCircled<>( (o1,o2) -> Character.compare(o1,o2));
        list.addNodeLast('J');
        list.addNodeLast('A');
        list.addNodeLast('I');
        list.addNodeLast('R');
        list.addNodeLast('O');
    }

    void setupOne(){
        listDishes = new ListCircled<>((o1,o2)->o1.getName().compareTo(o2.getName()));
        listDishes.addNodeLast( new Dish("1001","Pollo",false,45000,340));
        listDishes.addNodeLast( new Dish("1020","Carne",false,78000,400));
        listDishes.addNodeLast( new Dish("1030","Pescado",false,70000,240));
        listDishes.addNodeLast( new Dish("2000","Ensalada",true,20000,50));
        listDishes.addNodeLast( new Dish("2010","Pasta",true,23000,120));
    }

    @org.junit.jupiter.api.Test
    void findNode() {
        //J - A - I - R - O
        setup();
        assertNotNull( list.findNode( 'J') );
        assertNotNull( list.findNode( 'A') );
        assertNotNull( list.findNode( 'I') );
        assertNotNull( list.findNode( 'R') );
        assertNotNull( list.findNode( 'O') );

        assertNull( list.findNode( 'G') );
        assertNull( list.findNode( 'L') );
    }

    @Test
    void findNodeDish(){
        setupOne();
        assertNotNull( listDishes.findNode(new Dish(null,"Pollo",false,0.0,0)));
        assertNotNull( listDishes.findNode(new Dish("xx","Carne",false,0.0,0)));
        assertNotNull( listDishes.findNode(new Dish("10xx30","Pescado",false,0.0,0)));
        assertNotNull( listDishes.findNode(new Dish("xx","Ensalada",false,0.0,0)));
        assertNotNull( listDishes.findNode(new Dish("xx","Pasta",false,0.0,0)));

        assertNull( listDishes.findNode(new Dish("203410","Suchi",false,0.0,0)));
    }

    @Test
    void getList(){
        setupOne();
        List<Dish> list = listDishes.getList();
        assertEquals("1001",list.get(0).getCode());
        assertEquals("1020",list.get(1).getCode());
        assertEquals("1030",list.get(2).getCode());
        assertEquals("2000",list.get(3).getCode());
        assertEquals("2010",list.get(4).getCode());

        //Methods reference
        list.forEach( System.out::println );
    }
}