package FactoryDesignPattern.DesignShapeFactory;

public class Driver {
    public static void main (String [] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape("circle");

        if(shape != null) {
            shape.draw();
        } else {
            System.out.println("Can't you even spell a shape, you weasel");
        }
        
        
    }
}
