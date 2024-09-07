public class SimpleFactoryExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.start();
        car.stop();

        Vehicle bike = VehicleFactory.createVehicle("bike");
        bike.start();
        bike.stop();
        
        // Uncomment to see an error when an unknown type is provided.
        // Vehicle unknown = VehicleFactory.createVehicle("truck");
    }
}
