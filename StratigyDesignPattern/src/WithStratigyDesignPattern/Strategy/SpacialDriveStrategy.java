package WithStratigyDesignPattern.Strategy;

public class SpacialDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Spacial Drive Capability");
    }
}
