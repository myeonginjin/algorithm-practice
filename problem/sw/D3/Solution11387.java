package D3;

// 퍼센트 계산 혹은 나누기 할때, 소수점 날라가는거 생각하기. 
// 정 복잡하면 다 double로 선언해버리기

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution11387 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            double d = Integer.parseInt(st.nextToken());
            double l = Integer.parseInt(st.nextToken());
            double n = Integer.parseInt(st.nextToken());

            double ansD = d;

            for (int i = 1; i < n; i++) {
                double plusD = d * 1 + d * i * (l / 100);

                ansD += plusD;
            }

            int ans = (int) ansD;
            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);
    }
}
