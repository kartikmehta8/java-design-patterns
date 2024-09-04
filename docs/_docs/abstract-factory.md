# Abstract Factory Design Pattern

## Overview

The **Abstract Factory** is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. This pattern is particularly useful when the system needs to be independent of how its objects are created, composed, and represented.

## Structure

### 1. **Abstract Product (Vehicle)**

An interface for a type of product object.

```java
public interface Vehicle {
    void start();
    void stop();
}
```

### 2. **Concrete Products (Car, Bike)**

Concrete implementations of the abstract product interface.

```java
public class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }
}

public class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
    }
}
```

### 3. **Abstract Factory (VehicleFactory)**

An interface for creating abstract product objects.

```java
public interface VehicleFactory {
    Vehicle createVehicle();
}
```

### 4. **Concrete Factories (CarFactory, BikeFactory)**

Concrete implementations of the abstract factory interface.

```java
public class CarFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Car();
    }
}

public class BikeFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new Bike();
    }
}
```

### 5. **Factory Provider (VehicleFactoryProvider)**

A utility class to provide the appropriate factory based on input.

```java
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
```

## Usage

### When to Use

- When a system should be independent of how its objects are created, composed, and represented.
- When a system needs to be configured with one of multiple families of objects.
- When a family of related product objects is designed to be used together, and you need to enforce this constraint.
- When you want to provide a library of products and reveal only their interfaces, not their implementations.

## Advantages

- **Encapsulation of Object Creation**: Abstract Factory encapsulates the responsibility of selecting and instantiating the correct product classes, making the system easier to manage.
- **Ease of Use**: The client code interacts with the abstract factories and does not need to know the details of object creation.
- **Product Consistency**: Ensures that products are used together in a consistent way. For example, you can ensure that a CarFactory always produces a Car and not a Bike.

## Disadvantages

- **Complexity**: The pattern introduces additional classes and interfaces, which may increase the complexity of the system.
- **Difficult to Change**: If a new product family is required, it can be difficult to extend the abstract factory interface and its implementations.

## Example Usage

Below is a simple example of how the Abstract Factory pattern can be used in a client code:

```java
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
```

## Conclusion

The Abstract Factory pattern is a powerful design pattern that is essential in scenarios where you need to create families of related or dependent objects. By following clean coding principles, the code remains readable, maintainable, and scalable.
