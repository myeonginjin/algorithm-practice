// 코드트리 자료구조•알고리즘 DP - 아이템을 적절히 고르는 문제 / Knapsack

// 도둑이 보석방을 털러 갔습니다.
// 이때 도둑 가방의 크기는 8이며, 이보다 더 많은 양의 무게에 해당하는 보석들을 담아 나올 수는 없습니다.
// 또한, 보석은 종류별로 단 하나씩만 있습니다.

// 유의사항  : dp[0][0] = 0;로 시작점 잡아주기
// 유의사항 : dp[0][w[0]] = p[0]; 첫번째 보석 하나 담은 경우는 직접 넣어주기
// 유의사항 : 배열에 -1 모두 넣어주고 시작하기
// 유의사항  : dp[i - 1][j - w[i]] != -1 이라면 i번째 새로 못 담음. 

public class DP_Knapsack {
    public static void main(String[] args) {

        int n = 8;
        int[] w = { 3, 1, 4, 5, 2 };
        int[] p = { 4, 1, 2, 6, 3 };

        int[][] dp = new int[5][n + 1];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        dp[0][w[0]] = p[0];

        for (int i = 1; i < 5; i++) {
            for (int j = 0; j <= n; j++) {
                if (w[i] <= j && dp[i - 1][j - w[i]] != -1) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + p[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
