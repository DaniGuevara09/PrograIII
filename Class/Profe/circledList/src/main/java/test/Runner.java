package test;

import logic.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ArrayList<Dish> dishes = new ArrayList<>();
        dishes.add(new Dish("3464","Pollo",false,34500,320));
        dishes.add(new Dish("90","Carne",false,67000,450));
        dishes.add(new Dish("1010","Pasta",false,20000,189));
        dishes.add(new Dish("1005","Arroz",true,15000,90));
        dishes.add(new Dish("3245","Hamburguesa",false,23000,400));

        dishes.sort((o1,o2)->Integer.compare(o1.getCalories(),o2.getCalories()));

        dishes.forEach( System.out::println);
    }
}
