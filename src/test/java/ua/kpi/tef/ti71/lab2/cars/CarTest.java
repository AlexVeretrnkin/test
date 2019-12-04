package ua.kpi.tef.ti71.lab2.cars;

import org.junit.jupiter.api.Test;
import ua.kpi.tef.ti71.lab2.rules.RoadSign;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    public void canEnterAt_ForbiddenForAll() {
        assertFalse(new Car().canEnterAt(RoadSign.ENTRY_FORBIDDEN_FOR_ALL));
    }

    @Test
    public void canEnterAt_ForbiddenForMotorcycles() {
        assertTrue(new Car().canEnterAt(RoadSign.ENTRY_FORBIDDEN_FOR_MOTORCYCLES));
    }

    @Test
    public void canEnterAt_ForbiddenForTrucks() {
        assertTrue(new Car().canEnterAt(RoadSign.ENTRY_FORBIDDEN_FOR_TRUCKS));
    }

}