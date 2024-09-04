public class VehicleFactoryProvider {
  public static VehicleFactory getFactory(String vehicleType) {
    switch (vehicleType.toLowerCase()) {
      case "car":
        return new CarFactory();
      case "bike":
        return new BikeFactory();
      default:
        throw new IllegalArgumentException("Unknown vehicle type: " + vehicleType);
    }
  }
}
