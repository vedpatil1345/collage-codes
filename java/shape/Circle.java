/*
 * Packages:
 * 1) Implement a program that defines
 * package figures, which has a class
 * circle inherited from a class shape in
 * it. Include the methods in the class to
 * calculate area and display the
 * necessary information. Also include a
 * class, which has main to carry out
 * above-mentioned operations.
 * 2) Create a package new_figures, which
 * has classesrectangle and triangle
 * inherited from class shape of package
 * figures. Thus import the package
 * figure.Carry out necessary operations
 * tocalculate area and display the
 * necessary information.
 * 3) Modify the above programs by
 * importing both the packages in a file
 * outside both the packages, which
 * contains main class.
 */
package shape;

interface shape {

    abstract public void Area();
}

public class Circle implements shape {
    double radius;

    public Circle(double r) {
        radius = r;
    }

    @Override
    public void Area() {
        System.out.println("Area of the Circle having Radius:" + radius + " is: " + Math.PI * radius * radius);
    }

}
