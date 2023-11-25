package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution12741 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int ansM = 0;

            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int[] arr = new int[101];

            for (int i = a; i <= b; i++) {
                arr[i] += 1;
            }
            for (int i = c; i <= d; i++) {
                arr[i] += 1;
            }

            for (int i = Math.min(a, c); i <= Math.max(b, d); i++) {
                if (arr[i] == 2)
                    ansM++;
            }

            if (ansM > 0)
                ansM--;

            sb.append("#" + test_case + " " + ansM + "\n");

        }
        System.out.print(sb);
    }
}
