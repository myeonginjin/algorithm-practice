
// 초기설정 유의해기. dp[0][0]은 반복문 전에 직접 넣어주기
// 입력값이 터무니 없이 크다 혹은 dp로 손쉽게 풀 수 있다 싶으면 점화식 세워서 dfs, bfs로 풀지 않기

import java.util.Scanner;

public class DP_정수_사각형_최대_합 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[][] dp = new int[n][n];

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            dp[0][0] = arr[0][0];

            for (int i = 1; i < n; i++) {
                dp[0][i] = dp[0][i - 1] + arr[0][i];
                dp[i][0] = dp[i - 1][0] + arr[i][0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    int num3 = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = num3 + arr[i][j];
                }
            }

            System.out.print(dp[n - 1][n - 1]);
        }

    }
}
