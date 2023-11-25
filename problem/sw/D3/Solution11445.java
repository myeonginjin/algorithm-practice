
// 테스트 케이스 97/100 통과 코드

package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution11445 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            String st1 = br.readLine();
            String st2 = br.readLine();
            boolean ok = false;

            if (st2.length() - st1.length() > 2)
                ok = true;

            else if (st2.length() - st1.length() == 1) {
                if (st2.charAt(st2.length() - 1) != 'a')
                    ok = true;
            }

            else if (st2.length() == st1.length()) {

                // for (int i = 0; i<st1.length()-2; i++) {
                // if (st1.charAt(i) != st2.charAt(i)) ok = true;
                // }
                //
                // if (!ok) {
                // if (st2.charAt(st2.length()-1) - st1.charAt(st1.length()-1) >= 2) {
                // ok = true;
                // }
                // }
                ok = true;

            } else {
                ok = true;

                if (st1.charAt(st1.length() - 1) == 'z') {
                    if (st2.charAt(st2.length() - 1) - st1.charAt(st1.length() - 2) == 1) {
                        ok = false;
                    }
                }
            }
            String ans = ok ? "Y" : "N";

            sb.append("#" + test_case + " " + ans + "\n");
        }
        System.out.print(sb);
    }
}
