package ua.kpi.tef.ti71.lab2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.kpi.tef.ti71.lab2.cars.Car;
import ua.kpi.tef.ti71.lab2.cars.CarBrand;
import ua.kpi.tef.ti71.lab2.cars.CarBlueprint;
import ua.kpi.tef.ti71.lab2.cars.Truck;
import ua.kpi.tef.ti71.lab2.reflection.ReflectionUtils;

public class Main {

    public static void main(String[] args){
        Logger logger = LogManager.getLogger();

        Car tesla = new Car(CarBrand.TESLA, 0, 370);
        Car bmw = new Car(CarBrand.BMW, 6, 500);
        Truck hyundai = new Truck(CarBrand.HYUNDAI, 8, 1000, 3000);
        Truck homemade = new Truck(hyundai);
        homemade.setBearingCapacity(4000);
        homemade.setPower(1200);
        Truck bmwPseudoTruck = new Truck(bmw, 1000);
        bmwPseudoTruck.setBrand(CarBrand.HOMEMADE);

        ReflectionUtils.invokeAllAnnotatedMethods(bmwPseudoTruck);
        String res = ReflectionUtils.getInterfaceNames(bmwPseudoTruck).toString();
        logger.info("Class interfaces: {}", res);
        ReflectionUtils.printAllFieldsWithTheirTypesAndAnnotations(bmwPseudoTruck);

        res = ReflectionUtils.getName(tesla);
        logger.info("Class name: {}", res);
        ReflectionUtils.printAllFieldsWithTheirTypesAndAnnotations(tesla);

        logger.info("Horsepower of real tesla: ");
        logger.info(tesla.getPower());
        CarBlueprint demoTesla = (CarBlueprint) ReflectionUtils.getProxy(tesla);
        try {
            logger.info("Horsepower of demo tesla: ");
            logger.info(demoTesla.getPower());
            demoTesla.setBrand(CarBrand.BMW);
        } catch (Exception e) {
            logger.error("Got an exception while trying to access");
        }
    }

}
