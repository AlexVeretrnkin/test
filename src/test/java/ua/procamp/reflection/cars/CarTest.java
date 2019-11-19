package ua.procamp.reflection.cars;

import org.junit.Test;
import ua.procamp.reflection.rules.RoadSign;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

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