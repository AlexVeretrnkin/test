package ua.procamp.reflection.Cars;

import org.junit.Test;
import ua.procamp.reflection.Rules.RoadSign;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    public void canEnterAt_ForbiddenForAll() {
        assertFalse(new Car().canEnterAt(RoadSign.EntryForbiddenForAll));
    }

    @Test
    public void canEnterAt_ForbiddenForMotorcycles() {
        assertTrue(new Car().canEnterAt(RoadSign.EntryForbiddenForMotorcycles));
    }

    @Test
    public void canEnterAt_ForbiddenForTrucks() {
        assertTrue(new Car().canEnterAt(RoadSign.EntryForbiddenForTrucks));
    }

}