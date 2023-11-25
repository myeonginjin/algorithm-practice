package D2;

// SWEA 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

// 어느 고등학교에서 실시한 1000명의 수학 성적을 토대로 통계 자료를 만들려고 한다.
// 이때, 이 학교에서는 최빈수를 이용하여 학생들의 평균 수준을 짐작하는데, 여기서 최빈수는 특정 자료에서 가장 여러 번 나타나는 값을 의미한다.
// 다음과 같은 수 분포가 있으면,
// 10, 8, 7, 2, 2, 4, 8, 8, 8, 9, 5, 5, 3
// 최빈수는 8이 된다.
// 최빈수를 출력하는 프로그램을 작성하여라 (단, 최빈수가 여러 개 일 때에는 가장 큰 점수를 출력하라).

/*
! 정렬 유의사항 ! 
    배열 오름차순은 Arrays.sort(arr);을 통해 한다. 뒤에 범위를 넣어준다면, Arrays.sort(arr, 0, cnt); 0부터 cnt-1까지만 정렬한다는 소리이다.

	배열 내림차순은 유의해야할 점이, 객체가 원소인 배열만 가능하다는것. 그렇기에 int[]은되지않는다. 
	그럼 int[]배열을 Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new); 을 통해 integer배열로 바꾸든지, 처음부터 Integer배열로
	만들든지 해야한다. 
	이제 Integer배열을 내림차순 하는 방법은  Arrays.sort(arr , Collections.reverseOrder());이다. 이떄도 마친가지로 Arrays.sort(arr, 0, cnt, Collections.reverseOrder()); 로 범위 설정 가능

	그리고 동적리스트는 방법이 다른데, Collections.sort(arr)을 통해 오름차순으로 정렬한다.  내림차순 방법은 너무 복잡하기에
	오름차순으로 정렬한 뒤, arr.size()-1 부터 0까지의 인덱스를 조회하거나 arr[arr.size()-1]등의 방법으로 원하는 답을 출력하자
 */

// 유의사항 : 최빈수가 여러 개이면 그 중 가장 큰 값을 뽑는다. 이런 점 유의

import java.io.*;
import java.lang.StringBuilder;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collections;

class Solution1204 {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		String str;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] arr = new int[1001];

			int n = Integer.parseInt(br.readLine());
			str = br.readLine();
			st = new StringTokenizer(str);

			for (int i = 0; i < 1000; i++) {
				arr[Integer.parseInt(st.nextToken())]++;
			}

			int maxCnt = 0;

			Integer[] scores = new Integer[1001];
			int cnt = 0;

			for (int i = 0; i <= 1000; i++) {
				if (maxCnt <= arr[i]) {
					maxCnt = arr[i];
					scores[cnt++] = i;
				}
			}

			Arrays.sort(scores, 0, cnt, Collections.reverseOrder());

			int maxScore = scores[0];

			sb.append("#" + n + " " + maxScore + "\n");

		}
		System.out.print(sb);
	}
}