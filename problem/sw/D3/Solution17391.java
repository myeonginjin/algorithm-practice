package D3;

// euqls를 사용하여 간단하게 풀기 

import java.io.*;
import java.lang.StringBuilder;

class Solution17391 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String str;

        for (int test_case = 1; test_case <= T; test_case++) {
            // int l = Integer.parseInt(br.readLine());
            str = br.readLine();

            boolean same = str.substring(0, str.length() / 2).equals(str.substring(str.length() / 2, str.length()));
            String ans = same ? "Yes" : "No";
            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);

    }
}
