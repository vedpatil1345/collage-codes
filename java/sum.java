abstract class Calc {
    int a, b, c;

    Calc(int a, int b) {
        this.a = a;
        this.b = b;
    }

    Calc(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    abstract int sum2();

    abstract int sum3();

    void display2() {
        System.out.println(a + "+" + b + "=" + sum2());
    }

    void display3() {
        System.out.println(a + "+" + b + "+" + c + "=" + sum2());
    }
}

class Addition extends Calc {
    Addition(int a, int b, int c) {
        super(a, b, c);
    }

    Addition(int a, int b) {
        super(a, b);
    }

    public int sum2() {
        return a + b;
    }

    public int sum3() {
        return a + b + c;
    }
}

/**
 * sum
 */
public class sum {

    public static void main(String[] args) {
        Addition a2 = new Addition(5, 20);
        Addition a3 = new Addition(5, 10, 15);
        a2.sum2();
        a3.sum3();
        a2.display2();
        a3.display3();
    }
}