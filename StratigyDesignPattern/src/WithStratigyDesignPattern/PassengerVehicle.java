package WithStratigyDesignPattern;

import WithStratigyDesignPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
