package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution11688 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int l = 1;
            int r = 1;

            String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                char chr = str.charAt(i);

                if (chr == 'L')
                    r += l;
                else
                    l += r;
            }

            sb.append("#" + test_case + " " + l + " " + r + "\n");
        }
        System.out.print(sb);
    }
}
