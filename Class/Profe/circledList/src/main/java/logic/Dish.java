package logic;

public class Dish {
    private String code;
    private String name;
    private boolean vegetarian;
    private double value;
    private int calories;

    public Dish(String code, String name, boolean vegetarian, double value, int calories) {
        this.code = code;
        this.name = name;
        this.vegetarian = vegetarian;
        this.value = value;
        this.calories = calories;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", value=" + value +
                ", calories=" + calories +
                '}';
    }
}
