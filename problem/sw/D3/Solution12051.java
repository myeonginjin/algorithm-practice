
// (i *d)%100 == 0 잘 이해하기, 반올림하지 않고 정수로 통계가 나오려면, 이렇게 확인가능
// 문제 조건 잘 읽어보기 

package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution12051 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            long n = Long.parseLong(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            if ((g == 0 && d != 0) || g == 100 && d != 100) {
                sb.append("#" + test_case + " Broken\n");
                continue;
            }

            boolean can = false;
            for (long i = 1; i <= n; i++) {
                if ((i * d) % 100 == 0) {
                    sb.append("#" + test_case + " Possible\n");
                    can = true;
                    break;
                }
            }
            if (!can) {
                sb.append("#" + test_case + " Broken\n");
            }

        }
        System.out.print(sb);
    }
}
