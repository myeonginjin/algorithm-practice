package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution11736 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();
            int[] arr = new int[n];

            st = new StringTokenizer(str);
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;

            }
            int cnt = 0;
            for (int i = 1; i <= n - 2; i++) {
                if (arr[i] >= arr[i - 1] && arr[i] >= arr[i + 1] || arr[i] <= arr[i - 1] && arr[i] <= arr[i + 1]) {
                    continue;
                }
                cnt++;

            }

            sb.append("#" + test_case + " " + cnt + "\n");
        }
        System.out.print(sb);
    }
}
