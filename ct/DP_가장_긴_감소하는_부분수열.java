// 코드트리 자료구조•알고리즘 DP - 조건에 맞게 선택적으로 전진하는 DP / 가장 긴 감소하는 부분수열

// 다음과 같이, 조금 긴 수열이 존재합니다. 이 수열에서 가장 긴 감소하는 부분수열의 길이는 몇이 될까요?

// 60 65 50 70 63 55 45 51 45 48 54 70 61

// 여기서 부분수열이란 수열에서 일부 숫자를 선택해서 만든 또 다른 수열이며, 감소하는 부분수열이란 숫자가 점점 감소하는 부분수열을 의미합니다. 예를 들어, 45, 50, 25, 10, 18, 20 이라는 수열이 있다고 가정하면, 45, 25, 10 같은 수열은 감소하는 부분수열이지만 50, 20, 10은 순서대로 나오지 않으므로 부분수열이 아닙니다. 45, 50, 25, 10, 18, 20 수열에서 가장 긴 감소하는 부분수열은 45, 25, 10이 됩니다.

// 가장 긴 감소하는 부분수열의 길이를 구해봅시다.

class DP_가장_긴_감소하는_부분수열 {
	public static void main(String args[]) throws Exception {

		int[] arr = new int[] { 60, 65, 50, 70, 63, 55, 45, 51, 45, 48, 54, 70, 61 };
		int[] dp = new int[13];

		dp[0] = 1;

		for (int i = 1; i < dp.length; i++) {
			int elm = arr[i];
			int maxElm = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr[j] > elm) {
					maxElm = Math.max(maxElm, dp[j]);
				}
			}
			if (maxElm == 0)
				dp[i] = 1;
			else
				dp[i] = maxElm + 1;

		}
		int maxNum = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > maxNum)
				maxNum = dp[i];
		}
		System.out.println();
		System.out.println(maxNum);
	}
}