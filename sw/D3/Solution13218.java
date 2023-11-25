package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution13218 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = Integer.parseInt(br.readLine());

            int ans = n / 3;

            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);
    }
}