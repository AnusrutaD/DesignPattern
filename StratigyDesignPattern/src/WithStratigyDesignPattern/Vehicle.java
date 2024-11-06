package WithStratigyDesignPattern;

import WithStratigyDesignPattern.Strategy.DriveStrategy;

public class Vehicle {
    private DriveStrategy strategy;

    public Vehicle(DriveStrategy strategy){
        this.strategy = strategy;
    }

    public void drive(){
        strategy.drive();
    }
}
