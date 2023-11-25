
// 배열 열단위로 탐색해야 되는 경우 반복문 i와 j말고 r과 c로 구현해서 헷갈리지않기
// 테스크케이스 자체적으로 최대한 많이 해보기 

import java.util.Scanner;

public class Simulation_컨베이어_벨트 {
    public static Scanner sc = new Scanner(System.in);
    public static int n = sc.nextInt();
    public static int[][] arr = new int[2][n];

    public static void main(String[] args) {
        int t = sc.nextInt();

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < t; i++) {
            int temp = arr[0][n - 1];
            for (int j = n - 1; j >= 1; j--) {
                arr[0][j] = arr[0][j - 1];
            }
            arr[0][0] = arr[1][n - 1];

            for (int j = n - 1; j > 0; j--) {
                arr[1][j] = arr[1][j - 1];
            }
            arr[1][0] = temp;

        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
