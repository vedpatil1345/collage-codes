package new_figures;

interface Shape {

    abstract public void Area();
}

public class Triangle implements Shape {
    private double base, height;

    public Triangle(double b, double h) {
        base = b;
        height = h;
    }

    @Override
    public void Area() {
        System.out.println("The area of the triangle having base: " + base + " and Height: " + height + " is: "
                + (0.5 * base * height));
    }
}