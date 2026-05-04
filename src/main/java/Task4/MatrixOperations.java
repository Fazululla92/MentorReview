package Task4;

import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rows and columns: ");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] A = new int[r][c];
        int[][] B = new int[r][c];

        System.out.println("Enter Matrix A:");
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter Matrix B:");
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                B[i][j] = sc.nextInt();

        System.out.println("1. Addition  2. Multiplication");
        int choice = sc.nextInt();

        if(choice == 1) {
            int[][] sum = new int[r][c];
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    sum[i][j] = A[i][j] + B[i][j];

            System.out.println("Result:");
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++)
                    System.out.print(sum[i][j] + " ");
                System.out.println();
            }
        }
        else if(choice == 2) {
            int[][] mul = new int[r][c];
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                    for(int k=0;k<c;k++)
                        mul[i][j] += A[i][k] * B[k][j];

            System.out.println("Result:");
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++)
                    System.out.print(mul[i][j] + " ");
                System.out.println();
            }
        }

        sc.close();
    }
}
