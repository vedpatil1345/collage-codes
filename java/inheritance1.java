
class Cricket {
    String name;
    int age;

    void setdata(String N, int A) {
        name = N;
        age = A;
    }

    void display() {
        System.out.println("Name:" + name);
        System.out.println("Age:" + age);
    }
}

class Match extends Cricket {
    int no_of_odi, no_of_test;

    void setdata(String N, int A, int o, int t) {
        super.setdata(N, A);
        no_of_test = t;
        no_of_odi = o;
    }

    void display() {
        super.display();
        System.out.println("No. of odi played:" + no_of_odi);
        System.out.println("No. of test played:" + no_of_test);
    }
}

class inheritance1 {
    public static void main(String args[]) {

        Match m[] = new Match[5];
        for (int i = 0; i < m.length; i++) {
            m[i] = new Match();
        }
        for (int i = 0; i < m.length; i++) {
            m[i].setdata(args[i + i * 3], Integer.parseInt(args[(i + 1 + i * 3)]),
                    Integer.parseInt(args[i + 2 + i * 3]), Integer.parseInt(args[i + 3 + i * 3]));
        }
        for (int i = 0; i < m.length; i++) {
            m[i].display();
        }
    }
}