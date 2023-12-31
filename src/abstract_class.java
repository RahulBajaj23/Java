abstract class Shape {
    abstract void draw();

    public void sayHello() {
        System.out.println("Hello, who are you");
    }
}

abstract class Shape1 extends Shape {
    void draw1() {
        System.out.println("You can draw a square");
    }

    abstract void draw2();
}

class Square extends Shape1 {
    void draw() {
        System.out.println("You can draw a square");
    }

    void draw2() {
        System.out.println("Drawing method for Square");
    }
}

class Triangle extends Shape {
    void draw() {
        System.out.println("You can draw a Triangle");
    }
}

public class abstract_class {
    public static void main(String[] args) {

        Square objSquare = new Square();
        objSquare.draw1();
        objSquare.draw();
        objSquare.draw2();
    }
}