package D2;

//SWEA 1945. 간단한 소인수분해

// 숫자 N은 아래와 같다.

// N=2a x 3b x 5c x 7d x 11e

// N이 주어질 때 a, b, c, d, e 를 출력하라.

// 유의사항 : int[] cnt = new int[5];의 초기화 위치. 초기화 위치를 항상 조심하자 만약, 출력되는 값이 T에 값이 증가함에 따라 터무니 없이 크다면 변수 초기화가 제대로 안됐을 가능성이 높다

import java.lang.StringBuilder;
import java.io.*;

class Solution1945 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        int[] nums = new int[] { 2, 3, 5, 7, 11 };

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] cnt = new int[5];

            for (int i = 0; i < 5; i++) {

                while (n % nums[i] == 0) {
                    n /= nums[i];
                    cnt[i]++;
                }
            }
            sb.append("#" + test_case + " ");
            for (int i = 0; i < 5; i++) {
                sb.append(cnt[i] + " ");
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}