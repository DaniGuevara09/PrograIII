package co.edu.co.logic;

import static org.junit.jupiter.api.Assertions.*;

class HandlingCarTest {

    @org.junit.jupiter.api.Test
    void findByPlate() {
        HandlingCar handlingCar = new HandlingCar();
        assertNull(handlingCar.findByPlate("CCC234"));
        handlingCar.addCar(new Car("CCC234", "BMW", (short)1987, "Verde"));
        handlingCar.addCar(new Car("NOT560", "Nissan", (short)2024, "Rojo"));
        assertNotNull(handlingCar.findByPlate("CCC234"));
        assertNotNull(handlingCar.findByPlate("NOT560"));
        assertEquals("NOT560", handlingCar.findByPlate("NOT560").getPlate());

    }

    @org.junit.jupiter.api.Test
    void addCar() {
        HandlingCar handlingCar = new HandlingCar();
        assertTrue(handlingCar.addCar(new Car("CCC234", "BMW", (short)1987, "Verde")));
        assertTrue(handlingCar.addCar(new Car("NOT560", "Nissan", (short)2024, "Rojo")));
        assertTrue(handlingCar.addCar(new Car("SDF687", "Nissan", (short)2024, "Rojo")));
        assertFalse(handlingCar.addCar(new Car("CCC234", "Renault", (short)2020, "Blanco")));
    }
}