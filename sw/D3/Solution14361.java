
// 재배열 문제는 자릿수의 크기가 같아야 함. 고로 기존 문자열 길이와 변경된 문자열 길이를 비교해야함
// 탐색 문제 정답 여부 저장하는 불리언 값 변수 따로, 탐색해야할 모든 가짓수에서의 불리언 값 따로 선언하고, 가짓수 안에서 정답 충족했을 시, 정답 여부 저장 불리언 값 참으로 변경한 뒤 반복문 탈출

package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution14361 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            int num = Integer.parseInt(str);

            boolean[] nums = new boolean[10];

            for (int i = 0; i < str.length(); i++) {
                nums[Integer.parseInt(str.substring(i, i + 1))] = true;
            }

            boolean ans = false;

            for (int i = 2; i <= 9; i++) {

                boolean compare = true;

                int compareNum = num * i;

                String compareStr = Integer.toString(compareNum);

                if (compareStr.length() != str.length())
                    break;

                for (int j = 0; j < compareStr.length(); j++) {
                    if (i == 3) {

                    }
                    if (!nums[Integer.parseInt(compareStr.substring(j, j + 1))]) {
                        compare = false;
                    }
                }

                if (compare) {
                    ans = true;
                    break;
                }
            }

            if (ans)
                sb.append("#" + test_case + " " + "possible" + "\n");
            else
                sb.append("#" + test_case + " " + "impossible" + "\n");

        }
        System.out.print(sb);
    }
}

// 1035
// 2070
// 3105