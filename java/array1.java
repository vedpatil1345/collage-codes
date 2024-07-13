import java.util.Scanner;

class arr {
    Scanner sc = new Scanner(System.in);
    int[] arr, arr1;

    arr(int[] a) {
        this.arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i];

        }
    }

    arr() {
        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        this.arr = new int[n];
        this.arr1 = new int[n];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = sc.nextInt();
        }

    }

    arr(int size) {
        this.arr = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < arr.length; i++) {
            this.arr[i] = sc.nextInt();

        }
    }

    void display() {
        System.out.print("The elements of the array are : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(".\n");
    }

    void reverse() {
        System.out.print("The elements of the array in reverse are : ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.print(".\n");
    }

    void sort() {
        display();
        this.arr1 = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = arr[i];
        }
        for (int i = 0; i < arr1.length - 1; i++) {
            for (int j = 0; j < arr1.length - i - 1; j++) {
                if (arr1[j] > arr1[j + 1]) {
                    int temp = arr1[j];
                    arr1[j] = arr1[j + 1];
                    arr1[j + 1] = temp;
                }
            }
        }
        System.out.print("The elements of the array after sorting are: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();

    }

    void max() {
        int max = 0;
        display();
        max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }

        System.out.println("Maximum  element in the array is: " + max);
    }

    void search() {
        int q, loc = 0;
        System.out.print("Enter number to search in array:");
        q = sc.nextInt();
        for (int i = 0; arr[i] == q; i++) {
            loc++;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i == loc - 1)
                System.out.println("**" + arr[i] + "** ");
            else
                System.out.print(arr[i] + " ");
        }
        System.out.print(".\n");
        System.out.println("Location of " + q + " in array is " + loc + ".");
    }

    void avg() {
        int sum = 0, avg;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        avg = sum / arr.length;
        System.out.println("\n\nAverage of Array is " + avg + ".");
    }

    void funs() {
        int ch;
        System.out.println(
                "\n\n\n\n1.Display\n2.Search\n3.Average\n4.Maximum out of Array\n5.sort\n6.Reverse\nEnter choice:");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                display();
                break;
            case 2:
                search();
                break;
            case 3:
                avg();
                break;
            case 4:
                max();
                break;
            case 5:
                sort();
                break;
            case 6:
                reverse();
                break;
            case 7:
                break;
            default:
                System.out.println("Enter valid choice;");
                break;
        }
    }
}

class array1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch;

        System.out.print(
                "1.call constructor without argument;\n2.call constructor with size only;\n3.call constructor with array as argument\nEnter choice:");
        ch = sc.nextInt();
        switch (ch) {
            case 1:
                arr a1 = new arr();
                a1.funs();
                break;
            case 2:
                System.out.print("Enter size of array:");
                int n = sc.nextInt();
                arr a2 = new arr(n);
                a2.funs();
                break;
            case 3:
                System.out.print("Enter size of array:");
                int m = sc.nextInt();
                int a[] = new int[m];
                System.out.print("Enter the elements of the array: ");
                for (int i = 0; i < m; i++) {
                    a[i] = sc.nextInt();
                }

                arr a3 = new arr(a);
                a3.funs();
                break;

            default:
                System.out.println("Enter valid choice;");
                break;
        }

    }

}