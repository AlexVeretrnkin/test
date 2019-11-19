package ua.procamp.reflection.Cars;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import ua.procamp.reflection.Rules.RoadSign;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
public class TruckTest {

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