
// 변수 기본값 생각하고 지정하기
// 함정 경우의 수 생각하기

import java.util.Scanner;

public class Simulation_떨어지는_1자_블록 {
    public static Scanner sc = new Scanner(System.in);
    public static int n = sc.nextInt();
    public static int[][] arr = new int[n][n];
    // public static int[][] temp = new int[n][n];
    public static int m = sc.nextInt();
    public static int k = sc.nextInt() - 1;

    public static void simul(int size, int col) {

        int findR = n - 1;
        boolean find = false;
        for (int i = 0; i < n; i++) {
            if (find)
                break;
            for (int j = k; j <= k + m - 1; j++) {
                if (arr[i][j] == 1) {
                    findR = i - 1;
                    find = true;
                }
            }
        }

        for (int j = k; j <= k + m - 1; j++) {
            arr[findR][j] = 1;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        simul(m, k);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}