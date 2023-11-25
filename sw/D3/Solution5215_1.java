
// 테스트 케이스 5개만 통과한 문제, dp로 풀 수 없는 상황. 혹은 점화식에서 놓치는 부분이 있음.

package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution5215_1 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			String str = br.readLine();
			StringTokenizer st;

			st = new StringTokenizer(str);

			int n = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			int[] s = new int[n];
			int[] k = new int[n];
			int[][] dp = new int[n][l + 1];

			for (int i = 0; i < n; i++) {
				str = br.readLine();
				st = new StringTokenizer(str);

				int score = Integer.parseInt(st.nextToken());
				int kal = Integer.parseInt(st.nextToken());
				s[i] = score;
				k[i] = kal;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= l; j++) {
					dp[i][j] = -1;
				}
			}

			dp[0][0] = 0;
			dp[0][k[0]] = s[0];

			for (int i = 1; i < n; i++) {
				for (int j = 0; j <= l; j++) {
					if (j >= k[i] && dp[i - 1][j - k[i]] != -1) {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - k[i]] + s[i]);
					} else {
						dp[i][j] = dp[i - 1][j];
					}
				}
			}

			int max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= l; j++) {
					max = Math.max(max, dp[i][j]);
				}

			}
			sb.append("#" + test_case + " " + max);

		}
		System.out.print(sb);
	}
}