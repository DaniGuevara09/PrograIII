package com.example.demo1.logic;

public class Car {
    private String plate;

    private String mark;
    private Short model;
    private String color;

    public Car(String plate, String mark, Short model, String color) {
        this.plate = plate;
        this.mark = mark;
        this.model = model;
        this.color = color;
    }

    public Car() {
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Short getModel() {
        return model;
    }

    public void setModel(Short model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
