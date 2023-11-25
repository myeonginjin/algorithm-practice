
// 몇가지 테케 직접 계산해서 규칙 찾기

package D3;

import java.lang.StringBuilder;
import java.io.*;
import java.util.StringTokenizer;

class Solution14718 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int range = m * 2 + 1;

            int ans = n / range;
            if (n % range != 0)
                ans++;

            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);
    }
}

/*
 * 0 0 0 0 0
 * 0 0 0 1 0 0 0 0
 * 14
 * 
 */
