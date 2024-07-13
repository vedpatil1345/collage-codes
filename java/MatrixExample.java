import java.util.Scanner;

class Matrix {
    int row, column;
    double mat[][];

    Matrix(double a[][]) {
        row = a.length;
        column = a[0].length;
        mat = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = a[i][j];
            }
        }
    }

    Matrix() {
        row = 0;
        column = 0;
    }

    Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        mat = new double[row][column];
    }

    void readMatrix() {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                mat[i][j] = scanner.nextDouble();
            }
        }
    }

    double[][] transpose() {
        double[][] result = new double[column][row];
        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++) {
                result[i][j] = mat[j][i];
            }
        }
        return result;
    }

    double[][] matrixMultiplication(Matrix second) {
        if (column != second.row) {
            System.out.println("Matrices cannot be multiplied: incompatible dimensions.");
            return null;
        }
        double[][] result = new double[row][second.column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < second.column; j++) {
                for (int k = 0; k < column; k++) {
                    result[i][j] += mat[i][k] * second.mat[k][j];
                }
            }
        }
        return result;
    }

    void displayMatrix() {
        displayMatrix(mat);
    }

    void displayMatrix(double[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    double maximum_of_array() {
        double max = mat[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] > max) {
                    max = mat[i][j];
                }
            }
        }
        return max;
    }

    double average_of_array() {
        double sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                sum += mat[i][j];
            }
        }
        return sum / (row * column);
    }

}

class MatrixExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] arr1 = new double[3][3];
        double[][] arr2 = new double[3][3];

        System.out.println("Enter elements for arr1:");
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Enter elements for arr2:");
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                arr2[i][j] = sc.nextDouble();
            }
        }

        Matrix matrix1 = new Matrix(arr1);
        Matrix matrix2 = new Matrix(arr2);

        System.out.println("Matrix 1:");
        matrix1.displayMatrix();
        System.out.println("Transpose of Matrix 1:");
        matrix1.displayMatrix(matrix1.transpose());
        System.out.println("Maximum element of Matrix 1: " + matrix1.maximum_of_array());
        System.out.println("Average of elements of Matrix 1: " + matrix1.average_of_array());

        System.out.println("Matrix 2:");
        matrix2.displayMatrix();
        System.out.println("Multiplication of Matrix 1 and Matrix 2:");
        double[][] result = matrix1.matrixMultiplication(matrix2);
        if (result != null) {
            matrix1.displayMatrix(result);
        }
    }
}
