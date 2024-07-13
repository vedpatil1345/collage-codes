class CPU {
    double price;
    Processor p1;
    RAM r1;

    CPU(double p, double c, String mf, int cs, double mem, String mm, double clcs) {
        p1 = new Processor(p, c, mf, cs);
        r1 = new RAM(mem, mm, clcs);
    }

    class Processor {
        double cores, cache;
        String manufacturer;

        Processor(double p, double c, String mf, int cs) {
            price = p;
            cores = c;
            manufacturer = mf;
            cache = cs;
        }

        double getCache() {
            return cache;
        }

        void displayProcesorDetail() {
            System.out.println("\nCpu Details:\nProcessor Details: ");
            System.out.println("Price : RS" + price);
            System.out.println("Number of Cores : " + cores);
            System.out.println("Manufacturer  : " + manufacturer);
            System.out.println("Cache : " + getCache() + "KB");
        }
    }

    class RAM {
        double memory, clockSpeed;
        String manufacturer;

        RAM(double mem, String mm, Double clcs) {
            memory = mem;
            manufacturer = mm;
            clockSpeed = clcs;
        }

        void displayRAMDetails() {
            System.out.print("RAM Details:\n\n");
            System.out.println("Memory : " + memory + "GB \n Manufacture :" + manufacturer + "\nClock Speed : "
                    + getClockSpeed() + "MHz");
        }

        double getClockSpeed() {
            return clockSpeed;
        }
    }
}

public class inner {
    public static void main(String[] args) {
        CPU c1 = new CPU(95000, 10, "Intel", 32, 32, "Teamgroup", 6000);
        c1.p1.displayProcesorDetail();
        c1.r1.displayRAMDetails();

    }
}