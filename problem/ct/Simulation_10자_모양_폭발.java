
// 중력이 작용하는, 혹은 특수 상황 이후 배열의 모양이 달라지는 경우 temp 배열을 이용해서 풀기

import java.util.Scanner;

public class Simulation_10자_모양_폭발 {
    public static Scanner sc = new Scanner(System.in);
    public static int n = sc.nextInt();
    public static int[][] arr = new int[n][n];
    public static int[][] temp = new int[n][n];
    // public static boolean indexOk(int r, int c){
    // return r >= 0 && r < n && c >= 0 && c < n;
    // }

    public static void bobm(int row, int col) {
        int power = arr[row][col] - 1;

        int rowStr = row - power;
        int rowEnd = row + power;

        int colStr = col - power;
        int colEnd = col + power;

        int r = n - 1;
        // int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == col && i >= rowStr && i <= rowEnd) {
                    arr[i][j] = 0;
                } else if (i == row && j >= colStr && j <= colEnd) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = n - 1; i >= 0; i--) {
                if (arr[i][j] != 0) {
                    temp[r--][j] = arr[i][j];
                }
            }
            r = n - 1;
        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;

        bobm(r, c);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }

    }
}