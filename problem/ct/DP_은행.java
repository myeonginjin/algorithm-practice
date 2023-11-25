// 코드트리 자료구조•알고리즘 DP - 아이템을 적절히 고르는 문제 / 은행

// 가치가 1, 4, 5, 9인 4개의 동전이 주어졌을 때, 금액 21을 거슬러 주기 위해 필요한 최소 동전의 수를 구해보려고 합니다.

// 이 문제를 해결하기 위해 dp[i]를 지금까지 선택한 동전의 합이 i라 했을 때, 필요한 최소 동전 횟수라고 정의하여 dp table을
// 완성시켜보려고 합니다.

// 유의사항 : for문의 i는 코인의 금액을 뜻 한다.
// 유의사항 : 점화식에서, i 코인의 값보다 작은 coin배열의 값들로 빼주어야 한다. 그렇지 않으면 아웃오브 인덱스.

class DP_은행 {
    public static void main(String args[]) throws Exception {

        final int MAX_INT = Integer.MAX_VALUE;

        int[] dp = new int[22];
        int[] coin = new int[] { 1, 4, 5, 9 };

        for (int i = 1; i < dp.length; i++) {
            int minCoin = MAX_INT;
            for (int j = 0; j < 4; j++) {
                if (coin[j] <= i) {
                    minCoin = Math.min(dp[i - coin[j]] + 1, minCoin);
                }
            }

            dp[i] = minCoin;
        }

        for (int i = 1; i < dp.length; i++) {
            System.out.println(i + " : " + dp[i]);
        }

    }
}