import shape.Circle;
import new_figures.Rectangle;
import new_figures.Triangle;

public class package3 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5);
        Rectangle r1 = new Rectangle(5, 7);
        Triangle t1 = new Triangle(2, 6);
        System.out.println("Circle:");
        c1.Area();
        System.out.println("\nRectangle:");
        r1.Area();
        System.out.println("\nTriangle:");
        t1.Area();
    }
}
