import java.util.*;

class negException extends Exception {
    negException(String s) {
        super(s);
    }
}

class ZeroindexException extends Exception {
    ZeroindexException(String s) {
        super(s);
    }
}

class userexeptiondemo {
    public static void main(String[] args) throws negException, ZeroindexException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();
        if (n == 0)
            throw new ZeroindexException("Number of elements must be positive.");
        int arr[] = new int[n];
        System.out.println("Enter " + n + " integers : ");
        double sum = 0;
        for (int i = 0; i < n; i++) {

            int num = sc.nextInt();
            if (num < 0)
                throw new negException("Negative integer not allowed!");
            arr[i] = num;
            sum += num;

        }

        System.out.println("\nSum of all elements = " + sum);

        double avg = sum / n;
        System.out.printf("Average of Array members is:" + avg);
    }

}