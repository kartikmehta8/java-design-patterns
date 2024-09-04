---
layout: default
title: "Builder Pattern"
---

# Builder Design Pattern

## Overview

The **Builder** design pattern is a creational pattern that allows you to construct complex objects step by step. Unlike other creational patterns, Builder doesn't require that products have a common interface. It provides a flexible solution for creating complex objects in a clear and concise manner.

## Structure

### 1. **Product (House)**

The complex object that is to be built.

```java
public class House {
    private String basement;
    private String structure;
    private String roof;
    private String interior;

    private House(HouseBuilder builder) {
        this.basement = builder.basement;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.interior = builder.interior;
    }
}
```

### 2. **Builder (HouseBuilder)**

The builder class that constructs the `House` object.

```java
public static class HouseBuilder {
    private String basement;
    private String structure;
    private String roof;
    private String interior;

    public HouseBuilder withBasement(String basement) {
        this.basement = basement;
        return this;
    }

    public HouseBuilder withStructure(String structure) {
        this.structure = structure;
        return this;
    }

    public HouseBuilder withRoof(String roof) {
        this.roof = roof;
        return this;
    }

    public HouseBuilder withInterior(String interior) {
        this.interior = interior;
        return this;
    }

    public House build() {
        return new House(this);
    }
}
```

### 3. **Client Code**

The client uses the builder to create instances of `House`.

```java
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
```

## Usage

### When to Use

- When you need to construct complex objects with a large number of optional parameters.
- When the construction process must allow different representations for the object being built.
- When you want to avoid the telescoping constructor anti-pattern where you have multiple constructors with different parameters.
- When the object creation process needs to be independent of the components that make up the object.

### Where to Use

- Building complex objects in steps, such as in GUI frameworks, where the object can be built piece by piece.
- In cases where immutable objects are required, and the complete object needs to be built in a single call to the build method.

## Advantages

- **Readable Code**: The fluent interface provided by the builder pattern makes the code easy to read and understand.
- **Step-by-Step Construction**: Allows for step-by-step construction of objects and can produce different representations of the object.
- **Immutability**: The final object can be made immutable since it's built in one go.
- **Avoids Telescoping Constructor Pattern**: Simplifies the creation of objects with many parameters.

## Disadvantages

- **Increased Complexity**: The builder pattern can add unnecessary complexity if the object is simple and doesn’t require such an elaborate construction process.
- **Requires Mutability During Construction**: The builder object itself needs to be mutable until the final object is built, which might lead to unintended side effects if not managed properly.

## Conclusion

The Builder pattern is a powerful design pattern that is particularly useful for constructing complex objects with many optional parameters. It helps in building immutable objects with a clear construction process, adhering to clean coding principles by keeping the code readable, maintainable, and scalable.
