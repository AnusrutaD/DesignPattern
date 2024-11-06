package WithStratigyDesignPattern;

import WithStratigyDesignPattern.Strategy.SpacialDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle() {
        super(new SpacialDriveStrategy());
    }
}
