
/*
조건 1. 재료 수는 상관없음 (선택하고 안하고, dfs(선택 하는 경우) dfs(선택 안 하는 경우) 쌍으로 호출하는 재귀함수 구현)

조건 2. 제한된 칼로리가 넘지않는것  (재귀함수의 탈출조건 형성)

조건 3. 최상의 맛  (탈출 시, max 혹은 min값 초기화 검사)

=> 부분집합  

순열과 조합은 nPr, nCr 과 같이 n개중에서 r개를 뽑는것으로, 백트래킹을 사용해서 푼다.
*/

// 백트래킹 함수를 구현할때에는, 첫번째 최상위 노드에서 분기되는 두 갈래만 잘 생각해서 이 두 경우를 재귀호출 하는 식으로 짜면된다.
// 순열을 구성하는 문제에서는, 첫번째 부모노드를 선택하고, 안하고 이 두갈래로 찢어준다면 재귀 호출된 함수들은 알아서 각 원소들을 선택하는 경우아 안하는 경우로 쪼개간다.

package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution5215_2 {
    public static int n, l;
    public static int[] s = new int[10000];
    public static int[] k = new int[10000];
    public static int maxScore;

    public static void dfs(int index, int kal, int sum) {

        if (index == n) {
            if (kal <= l) {
                maxScore = Math.max(maxScore, sum);
            }
            return;
        }

        dfs(index + 1, kal + k[index], sum + s[index]);

        dfs(index + 1, kal, sum);

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            StringTokenizer st;

            st = new StringTokenizer(str);

            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);

                int score = Integer.parseInt(st.nextToken());
                int kal = Integer.parseInt(st.nextToken());
                s[i] = score;
                k[i] = kal;
            }

            maxScore = 0;
            dfs(0, 0, 0);

            sb.append("#" + test_case + " " + maxScore + "\n");
        }

        System.out.print(sb);
    }
}
