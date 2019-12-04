package ua.kpi.tef.ti71.lab2.reflection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ua.kpi.tef.ti71.lab2.cars.Car;
import ua.kpi.tef.ti71.lab2.cars.CarBlueprint;
import ua.kpi.tef.ti71.lab2.cars.CarBrand;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReflectionUtilsTest {

    @Test
    public void getAllFields() {
        Car car = new Car();
        List<Field> fields1 = ReflectionUtils.getAllFields(car);
        List<Field> fields2 = new LinkedList<Field>();
        Class clazz = car.getClass();
        while (!clazz.equals(Object.class)) {
            fields2.addAll(Arrays.asList(clazz.getDeclaredFields()));
            clazz = clazz.getSuperclass();
        }
        assertArrayEquals(fields1.toArray(), fields2.toArray());
    }

    @Test
    void getProxy(){
        Car car = new Car(CarBrand.TESLA, 0, 370);
        CarBlueprint proxy = (CarBlueprint) ReflectionUtils.getProxy(car);


        assertThrows(Exception.class,
                () -> proxy.setPower(1),
                "No exception");

        assertThrows(Exception.class,
                () -> proxy.setCylinders(1),
                "No exception");

        assertThrows(Exception.class,
                () -> proxy.setBrand(CarBrand.HOMEMADE),
                "No exception");
    }


}