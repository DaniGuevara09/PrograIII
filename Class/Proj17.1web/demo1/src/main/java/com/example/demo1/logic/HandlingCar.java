package com.example.demo1.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HandlingCar {
    private final List<Car> cars;

    public HandlingCar() {
        this.cars = new ArrayList<>();
        cars.add(new Car("ADF453", "Audi", (short)1099, "Blanco"));
        cars.add(new Car("HFH356", "Ford", (short)1985, "Negro"));
    }

    public Car findByPlate(String plate) {
        Optional<Car> optional = cars.stream()
                .filter(car -> car.getPlate().equals(plate)).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }

    public boolean addCar(Car car) {
        if (findByPlate(car.getPlate()) == null) {
            cars.add(car);
            return true;
        }
        return false;
    }

    public List<Car> getAll() {
        return cars;
    }
}
