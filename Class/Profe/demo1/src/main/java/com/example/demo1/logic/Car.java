package com.example.demo1.logic;

public class Car {
    private Integer id;
    private String plate;
    private String mark;
    private short model;
    private String color;

    public Car(Integer id, String plate, String mark, short model, String color) {
        this.id = id;
        this.plate = plate;
        this.mark = mark;
        this.model = model;
        this.color = color;
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

    public short getModel() {
        return model;
    }

    public void setModel(short model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
