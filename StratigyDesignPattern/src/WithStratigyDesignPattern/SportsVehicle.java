package WithStratigyDesignPattern;

import WithStratigyDesignPattern.Strategy.SpacialDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SpacialDriveStrategy());
    }
}
