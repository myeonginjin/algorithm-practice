package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution12221 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            boolean ans = true;
            if (a >= 10 || b >= 10) {
                ans = false;
            }

            int num = ans ? a * b : -1;

            sb.append("#" + test_case + " " + num + "\n");

        }
        System.out.print(sb);
    }
}

/*
 * 100000 / 3 33333 * 7 + 나머지 먹을 일
 */