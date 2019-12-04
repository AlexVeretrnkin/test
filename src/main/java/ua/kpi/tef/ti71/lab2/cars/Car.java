package ua.kpi.tef.ti71.lab2.cars;

import ua.kpi.tef.ti71.lab2.rules.LegallyBinding;
import ua.kpi.tef.ti71.lab2.rules.RoadSign;
import ua.kpi.tef.ti71.lab2.rules.UsageLimit;

public class Car implements CarBlueprint {
    /**
     * Car brand
     */
    private CarBrand brand;
    /**
     * Describes an amount of cylinders in car engine
     */
    private int cylinders;
    /**
     * Measured in horsepower
     */
    @UsageLimit(500) // Car cannot use more than 500 horsepower
    private double power;

    public Car(CarBrand brand, int cylinders, double power) {
        this.brand = brand;
        this.cylinders = cylinders;
        this.power = power;
    }

    public Car(Car car) {
        this.brand = car.brand;
        this.cylinders = car.cylinders;
        this.power = car.power;
    }

    public Car() {
        this.brand = CarBrand.HOMEMADE;
        this.cylinders = 2;
        this.power = 100;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public int getCylinders() {
        return cylinders;
    }

    public void setCylinders(int cylinders) {
        this.cylinders = cylinders;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    @LegallyBinding
    public boolean canEnterAt(RoadSign roadSign) {
        switch (roadSign) {
            case ENTRY_FORBIDDEN_FOR_ALL:
                return false;
            case ENTRY_FORBIDDEN_FOR_MOTORCYCLES:
            case ENTRY_FORBIDDEN_FOR_TRUCKS:
            default:
                return true;
        }
    }

    @LegallyBinding
    public RoadSign[] getEntryAllowedSigns() {
        return new RoadSign[]{RoadSign.ENTRY_FORBIDDEN_FOR_MOTORCYCLES, RoadSign.ENTRY_FORBIDDEN_FOR_TRUCKS};
    }


    public boolean morePowerfulThan(Car car){
        return this.power > car.power;
    }

    @Override
    public String toString() {
        return "Brand: " + this.brand + " cylinders: " + this.cylinders + " power: " + this.power + "hp ";
    }
}
