package WithoutStratigyDesignPattern;


public class PassengerVehicle implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Normal Drive Capability");
    }
}