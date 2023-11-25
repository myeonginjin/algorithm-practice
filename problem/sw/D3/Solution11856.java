package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution11856 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();

            int[] num = new int[128];

            int cnt = 0;

            for (int i = 0; i < 4; i++) {

                if (num[str.charAt(i)] == 1)
                    cnt++;

                num[str.charAt(i)]++;
            }

            if (cnt == 2) {
                sb.append("#" + test_case + " Yes\n");
            } else {
                sb.append("#" + test_case + " No\n");
            }

        }
        System.out.print(sb);
    }
}
