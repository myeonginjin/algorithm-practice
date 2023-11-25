
// 반복문 범위 재확인
// 가끔은 어렵게 접근하지 않기

package D3;

import java.io.*;
import java.lang.StringBuilder;

class Solution14555 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();

            int cnt = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    cnt++;
                    i++;
                } else if (str.charAt(i) == ')') {
                    cnt++;

                }
            }
            sb.append("#" + test_case + " " + cnt + "\n");

        }
        System.out.print(sb);
    }
}