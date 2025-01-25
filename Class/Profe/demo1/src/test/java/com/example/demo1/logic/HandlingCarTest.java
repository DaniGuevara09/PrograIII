package com.example.demo1.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandlingCarTest {

    @Test
    void findByPLate() {
        HandlingCar handlingCar = new HandlingCar();
        assertNull(handlingCar.findByPLate("HPV990"));
        handlingCar.save(new Car(3454,"JIA764","BMW",(short)1987,"Verde"));
        handlingCar.save(new Car(6543,"NOT560","Nissan",(short)2007,"Azul"));
        assertNotNull( handlingCar.findByPLate("JIA764"));
        assertNotNull( handlingCar.findByPLate("NOT560"));
        assertEquals("NOT560",handlingCar.findByPLate("NOT560").getPlate());
    }

    @Test
    void save() {
        HandlingCar handlingCar = new HandlingCar();
        assertTrue( handlingCar.save(new Car(24234,"NOT560","Nissan",(short)2007,"Azul")));
        assertTrue( handlingCar.save(new Car(76543,"JIA764","Nissan",(short)2007,"Azul")));
        assertTrue( handlingCar.save(new Car(63434,"PQR534","Nissan",(short)2007,"Azul")));
        assertFalse( handlingCar.save(new Car(5234,"NOT560","Renault",(short)2020,"Blanco")));
        assertEquals(3,handlingCar.getAll().size());
    }

    @Test
    void getAll() {
    }
}