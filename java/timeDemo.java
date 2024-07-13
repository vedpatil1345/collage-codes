/* Create a class time that has hour, minute and second as data members. Create a parameterized constructor to initialize Time Objects. Create a member Function Time Sum (Time, Time) to sum two time objects. */
class Time {
    private int hour, minute, second;

    public Time(int h, int m, int s) {
        hour = h;
        minute = m;
        second = s;
        second %= 60;
        minute += second / 60;
        minute %= 60;
        hour += minute / 60;
    }

    public void display() {
        System.out.println("Time: " + hour + ":" + minute + ":" + second);
    }

    public Time TimeSum(Time t1, Time t2) {
        int totalSeconds = (t1.hour * 3600 + t1.minute * 60 + t1.second)
                + (t2.hour * 3600 + t2.minute * 60 + t2.second);
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int s = (totalSeconds % 3600) % 60;
        return new Time(h, m, s);
    }
}

public class timeDemo {

    public static void main(String[] args) {
        Time t1 = new Time(2, 30, 45);
        Time t2 = new Time(1, 45, 30);
        Time sum = t1.TimeSum(t1, t2);
        System.out.println("time 1");
        t1.display();
        System.out.println("time 2");
        t2.display();
        System.out.println("Sum of time 1 and time 2");
        sum.display();
    }
}