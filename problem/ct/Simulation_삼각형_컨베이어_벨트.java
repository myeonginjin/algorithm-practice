
// 오른쪽으로 밀면 왼쪽 인덱스부터 감소 순으로 배열 조작
// 행이나 열 중 한 값을 정해준 경우 답안 출력도 이에 맞추어

import java.util.Scanner;

public class Simulation_삼각형_컨베이어_벨트 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] arr = new int[3][n];

            int t = sc.nextInt();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < t; i++) {

                int nextFir = arr[2][n - 1];
                int nextTwo = arr[0][n - 1];
                int nextThir = arr[1][n - 1];

                for (int j = n - 1; j > 0; j--) {
                    arr[0][j] = arr[0][j - 1];
                }
                for (int j = n - 1; j > 0; j--) {
                    arr[1][j] = arr[1][j - 1];
                }
                for (int j = n - 1; j > 0; j--) {
                    arr[2][j] = arr[2][j - 1];
                }

                arr[0][0] = nextFir;
                arr[1][0] = nextTwo;
                arr[2][0] = nextThir;
            }

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }

    }
}