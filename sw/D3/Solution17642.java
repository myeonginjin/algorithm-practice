package D3;

// b에서는 빼고 a에서는 증가시키므로, a가 더 큰 경우는 만들 수 없다.
// 최대 횟수를 구하는 것이므로, 가장 작은 수를 뺴거나 더하는 것, 가장 작은 소수 2 
// 그렇다면 오차 범위인 B-a를 2로 나누면 최대 횟수가 나올 것이다, 오차 범위가 홀수라도 다음 최소 홀수인 3을 한번 섞어주면 되기 떄문에 해결 가능

import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution17642 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (a > b || b - a == 1) {
                sb.append("#" + test_case + " " + "-1" + "\n");
            } else {
                sb.append("#" + test_case + " " + (b - a) / 2 + "\n");
            }
        }
        System.out.print(sb);

    }
}
