
/*Write a program to find prime number in given range using both method of
multithreading. Also run the same program using executor framework*/
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class PrimeFinder1 extends Thread {
    private int start;
    private int end;

    public PrimeFinder1(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    System.out.println(i + " is prime.");
                } else {
                    System.out.println(i + " is not prime.");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

class PrimeFinder2 implements Runnable {
    private int start;
    private int end;

    public PrimeFinder2(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        synchronized (this) {
            for (int i = start; i <= end; i++) {
                if (isPrime(i)) {
                    System.out.println(i + " is prime.");
                } else {
                    System.out.println(i + " is not prime.");
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isPrime(int num) {
        if (num <= 1)
            return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }
}

public class PrimeFinderMain {
    public static void main(String[] args) throws InterruptedException {
        int startRange = 1;
        int endRange = 50;

        // Using multithreading
        PrimeFinder1 thread1 = new PrimeFinder1(startRange, endRange / 2);
        PrimeFinder1 thread2 = new PrimeFinder1(endRange / 2 + 1, endRange);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        // Using Executor framework
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new PrimeFinder2(startRange, endRange / 2));
        executor.execute(new PrimeFinder2(endRange / 2 + 1, endRange));
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    }
}
