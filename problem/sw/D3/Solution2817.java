
// 가능한 모든 수열의 문제로 접근할 수 있다면 백트래킹으로 풀어라.
// nCn를 잘 구상해서 어떻게 재귀 로직을 짤지 고민
// 재귀가 종료되는 시점 잘 생각하기 
// 순열의 합이든, 순열 리스트 출력이든 각 원소를 선택하냐(1) 안하냐(0) 이 두 가짓수로 분기해서 재귀하면 됨

package D3;

import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution2817 {
    public static int n, k, cnt;
    public static int[] arr = new int[20];

    public static void dfs(int num, int sum) {

        if (sum > k)
            return;

        if (num == n) {
            if (sum == k)
                cnt++;
            return;
        }

        dfs(num + 1, sum + arr[num]);

        dfs(num + 1, sum);

        return;

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            cnt = 0;

            str = br.readLine();
            st = new StringTokenizer(str);
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dfs(0, 0);

            sb.append("#" + test_case + " " + cnt + "\n");

        }
        System.out.print(sb);
    }
}