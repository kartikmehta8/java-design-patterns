public class PrototypePatternExample {
    public static void main(String[] args) {

        PrototypeRegistry prototypeRegistry = new PrototypeRegistry();
        prototypeRegistry.registerShape("circle", new Circle(5));
        prototypeRegistry.registerShape("rectangle", new Rectangle(4, 6));

        Shape clonedCircle = prototypeRegistry.getShape("circle");
        clonedCircle.draw();

        Shape clonedRectangle = prototypeRegistry.getShape("rectangle");
        clonedRectangle.draw();

        ((Circle) clonedCircle).setRadius(10);
        clonedCircle.draw();

        ((Rectangle) clonedRectangle).setWidth(8);
        clonedRectangle.draw();
    }
}
