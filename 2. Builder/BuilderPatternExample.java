public class BuilderPatternExample {
  public static void main(String[] args) {
    House house = new House.HouseBuilder()
        .withBasement("Concrete Basement")
        .withStructure("Wooden Structure")
        .withRoof("Shingle Roof")
        .withInterior("Modern Interior")
        .build();

    System.out.println(house);

    House simpleHouse = new House.HouseBuilder()
        .withStructure("Brick Structure")
        .build();

    System.out.println(simpleHouse);
  }
}
