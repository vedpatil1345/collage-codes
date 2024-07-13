package new_figures;

public class Rectangle implements Shape {
    private double length, width;

    public Rectangle(double l, double w) {
        length = l;
        width = w;
    }

    @Override
    public void Area() {
        System.out.println(
                "Area of the Rectangle having length: " + length + " and Width: " + width + " is: " + (length * width));
    }
}