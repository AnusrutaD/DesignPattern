package WithoutStratigyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle1 = new PassengerVehicle();
        Vehicle vehicle2 = new SportsVehicle();
        Vehicle vehicle3 = new OffRoadVehicle();

        vehicle1.drive();
        vehicle2.drive();
        vehicle3.drive();
    }
}
