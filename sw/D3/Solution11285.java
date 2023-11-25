
// Math.pow(n,2) -> n의 제곱 구하기
// Math.sqrt(n) -> n의 제곱근 구하기  

package D3;

import java.io.*;

import java.lang.StringBuilder;
import java.util.StringTokenizer;

class Solution11285 {

    public static int getScore(double r) {
        if (r <= 20)
            return 10;
        else if (r <= 40)
            return 9;
        else if (r <= 60)
            return 8;
        else if (r <= 80)
            return 7;
        else if (r <= 100)
            return 6;
        else if (r <= 120)
            return 5;
        else if (r <= 140)
            return 4;
        else if (r <= 160)
            return 3;
        else if (r <= 180)
            return 2;
        else if (r <= 200)
            return 1;

        return 0;

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            int n = Integer.parseInt(br.readLine());

            int score = 0;
            String str;
            StringTokenizer st;

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                double r = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

                score += getScore(r);
            }
            sb.append("#" + test_case + " " + score + "\n");

        }
        System.out.print(sb);
    }
}
