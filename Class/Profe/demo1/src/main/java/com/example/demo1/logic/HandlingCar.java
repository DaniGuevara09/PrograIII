package com.example.demo1.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class HandlingCar {
    private List<Car> cars;

    public HandlingCar() {
        this.cars = new ArrayList<>();
        cars.add( new Car(63534,"HWY818","Nissan versa",(short)2014,"Blanco"));
        cars.add( new Car(5323,"JGB306","Chevrolet",(short)2020,"Rojo"));
    }

    public Car findByPLate(String plate){
        Optional<Car> optional = cars.stream()
                .filter( car -> car.getPlate().equals( plate) )
                .findFirst();

        return optional.isPresent() ? optional.get() : null;
    }

    public boolean save( Car car ){
        if( findByPLate(car.getPlate()) == null ){
            cars.add( car );

            return true;
        }

        return false;
    }

    public List<Car> getAll(){

        return  cars;
    }
}
