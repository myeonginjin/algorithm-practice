
// 최댓값, 최솟값 동시에 찾을 때에는 꼭 if if를 걸어주도록 하자.
// if 와 else if를 사용한다면, max와 min변수가 초기화가 정상적으로 이루어지지않는다.

package D3;

import java.io.*;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

class Solution1208 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        String str;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] arr = new int[100];

            int cnt = Integer.parseInt(br.readLine());
            str = br.readLine();
            st = new StringTokenizer(str);

            for (int i = 0; i < 100; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < cnt; i++) {
                int min = 101;
                int max = 0;

                int minInd = 0;
                int maxInd = 0;

                for (int j = 0; j < 100; j++) {
                    int t = arr[j];

                    if (t > max) {
                        max = t;
                        maxInd = j;
                    }
                    if (t < min) {
                        min = t;
                        minInd = j;
                    }
                }
                arr[maxInd]--;
                arr[minInd]++;
            }

            int min2 = 101;
            int max2 = 0;
            for (int i = 0; i < 100; i++) {
                int t2 = arr[i];

                if (t2 > max2) {
                    max2 = t2;

                }
                if (t2 < min2) {
                    min2 = t2;
                }
            }

            sb.append("#" + test_case + " " + (max2 - min2) + "\n");

        }
        System.out.print(sb);
    }
}