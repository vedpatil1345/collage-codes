/*Define following classes and interfaces.
public interface GeometricShape {
 public void describe();
}
public interface TwoDShape extends GeometricShape {
 public double area();
}
public interface ThreeDShape extends GeometricShape {
 public double volume();
}
public class Cone implements ThreeDShape {
 private double radius;
 private double height;
 public Cone (double radius, double height)
 public double volume()
 public void describe()
}
public class Rectangle implements TwoDShape {
 private double width, height;
 public Rectangle (double width, double height)
 public double area()
 public double perimeter()
 public void describe()
}
public class Sphere implements ThreeDShape {
 private double radius;
 public Sphere (double radius)
 public double volume()
 public void describe()
}
Define test class to call various methods of Geometric Shape
*/
interface GeometricShape {
    void describe();
}

interface TwoDShape extends GeometricShape {
    double area();
}

interface ThreeDShape extends GeometricShape {
    double volume();
}

class Cone implements ThreeDShape {
    double radius;
    double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double volume() {
        return Math.PI * Math.pow(radius, 2) * height / 3;
    }

    public void describe() {
        System.out.println("This is a cone.");
    }
}

class Rectangle implements TwoDShape {
    double width;
    double length;

    public Rectangle(double w, double l) {
        width = w;
        length = l;
    }

    public void describe() {
        System.out.println("This is a Rectangle.");
    }

    public double area() {
        return width * length;
    }

    public double perimeter() {
        return 2 * (width + length);
    }
}

class Sphere implements ThreeDShape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    public double volume() {
        return (4 / 3) * Math.PI * Math.pow(radius, 3);
    }

    public void describe() {
        System.out.println("This is a sphere.");
    }
}

public class inheritance3 {
    public static void main(String[] args) {
        Cone c1 = new Cone(5, 6);
        Rectangle r1 = new Rectangle(3, 7);
        Sphere s1 = new Sphere(8);
        c1.describe();
        System.out.println("volume of Cone is:" + c1.volume());
        r1.describe();
        System.out.println("area of Rectangle is:" + r1.area());
        s1.describe();
        System.out.println("volume of Sphere is:" + s1.volume());
    }
}