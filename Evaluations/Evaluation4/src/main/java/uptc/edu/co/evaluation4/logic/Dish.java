package uptc.edu.co.evaluation4.logic;

public class Dish {
    private String idDish;
    private String name;
    private int calories;
    private boolean isVegetarian;
    private int value;
    private String comments;

    public Dish() {
    }

    public Dish(String idDish, String name, int calories, boolean isVegetarian, int value, String comments) {
        this.idDish = idDish;
        this.name = name;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
        this.value = value;
        this.comments = comments;
    }

    public String getIdDish() {
        return idDish;
    }

    public void setIdDish(String idDish) {
        this.idDish = idDish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
