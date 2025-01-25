package uptc.edu.co.evaluation4.logic;

import java.util.ArrayList;
import java.util.Optional;

public class HandlingDish {
    private ArrayList<Dish> dishes;

    public HandlingDish() {
        this.dishes = new ArrayList<>();
    }

    public boolean addDish(Dish dish) {
        try {
            this.dishes.add(dish);
            return true;
        } catch (Exception _) {
            return false;
        }
    }

    public ArrayList<Dish> getDishes() {
        return dishes;
    }

    public Dish findById(String id){
        Optional<Dish> optional = dishes.stream()
                .filter( dish -> dish.getIdDish().equals( id) )
                .findFirst();

        return optional.isPresent() ? optional.get() : null;
    }
}
