public class Main {
  public static void main(String[] args) {
    VehicleFactory carFactory = VehicleFactoryProvider.getFactory("car");
    Vehicle car = carFactory.createVehicle();
    car.start();
    car.stop();

    VehicleFactory bikeFactory = VehicleFactoryProvider.getFactory("bike");
    Vehicle bike = bikeFactory.createVehicle();
    bike.start();
    bike.stop();
  }
}
