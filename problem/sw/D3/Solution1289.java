
// 답으로 출력하는 변수는 i가 T인 기본 반복문 안에 선언되어야 한다.
// 각 테스트 케이스 별로 답이 들어갈 변수 값이 초기화 되어야 하기 때문이다

package D3;

import java.lang.StringBuilder;

import java.io.*;

class Solution1289 {

    public static String str;

    public static int check(int index) {
        int cnt = 1;
        for (int i = index + 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            int ansCnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    ansCnt = check(i);
                    break;
                }
            }
            sb.append("#" + test_case + " " + ansCnt + "\n");
        }
        System.out.print(sb);
    }
}