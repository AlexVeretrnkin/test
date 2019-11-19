package ua.procamp.reflection;


import ua.procamp.reflection.cars.Car;
import ua.procamp.reflection.cars.CarBlueprint;
import ua.procamp.reflection.cars.CarBrand;
import ua.procamp.reflection.cars.Truck;
import ua.procamp.reflection.reflection.ReflectionUtils;

public class Main {

    public static void main(String[] args){

        Car tesla = new Car(CarBrand.TESLA, 0, 370);
        Car bmw = new Car(CarBrand.BMW, 6, 500);
        Truck hyundai = new Truck(CarBrand.HYUNDAI, 8, 1000, 3000);
        Truck homemade = new Truck(hyundai);
        homemade.setBearingCapacity(4000);
        homemade.setPower(1200);
        Truck bmwPseudoTruck = new Truck(bmw, 1000);
        bmwPseudoTruck.setBrand(CarBrand.HOMEMADE);

        ReflectionUtils.invokeAllAnnotatedMethods(bmwPseudoTruck);
        System.out.println("Class interfaces: " + ReflectionUtils.getInterfaceNames(bmwPseudoTruck).toString());
        ReflectionUtils.printAllFieldsWithTheirTypesAndAnnotations(bmwPseudoTruck);

        System.out.println("Class name: " + ReflectionUtils.getName(tesla));
        ReflectionUtils.printAllFieldsWithTheirTypesAndAnnotations(tesla);

        System.out.println("Horsepower of real tesla: ");
        System.out.println(tesla.getPower());
        CarBlueprint demoTesla = (CarBlueprint) ReflectionUtils.getProxy(tesla);
        try {
            System.out.println("Horsepower of demo tesla: ");
            System.out.println(demoTesla.getPower());
            demoTesla.setBrand(CarBrand.BMW);
        } catch (Exception e) {
            System.out.println("Got an exception while trying to access");
        }
    }

}
