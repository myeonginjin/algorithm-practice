package D3;

// 문제에서 a이상 b이하의 자연수의 최대공약수라고 했으니, a~b사이의 모든 숫자들의 공통 약수이자 그중 최댓값이어야한다. 문제가 대충 읽으면 함정이 있음.
// long으로도 지정할 수 없는 큰 숫자인 경우 받을 수 있는 방법은 문자열밖에 없다. 

import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution17937 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            String a = st.nextToken();
            String b = st.nextToken();

            if (a.equals(b))
                sb.append("#" + test_case + " " + a + "\n");
            else {
                sb.append("#" + test_case + " " + 1 + "\n");
            }
        }
        System.out.print(sb);

    }

}