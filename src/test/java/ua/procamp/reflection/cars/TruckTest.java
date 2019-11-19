package ua.procamp.reflection.cars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ua.procamp.reflection.rules.RoadSign;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class TruckTest {

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