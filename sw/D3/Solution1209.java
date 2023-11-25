
// 반복문 범위 잘 확인하기

package D3;

import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution1209 {
    public static int n;
    public static int[][] arr = new int[100][100];

    public static int getSum() {

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 100; i++) {
            int sum = 0;
            for (int j = 0; j < 100; j++) {
                sum += arr[i][j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        for (int j = 0; j < 100; j++) {
            int sum = 0;
            for (int i = 0; i < 100; i++) {
                sum += arr[i][j];
            }
            maxSum = Math.max(maxSum, sum);
        }

        int sumR = 0;
        for (int i = 0; i < 100; i++) {
            sumR += arr[i][i];
        }

        maxSum = Math.max(maxSum, sumR);

        int sumL = 0;
        for (int i = 99; i >= 0; i--) {
            sumL += arr[i][i];
        }
        maxSum = Math.max(maxSum, sumL);

        return maxSum;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            int ansSum = 0;

            for (int i = 0; i < 100; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ansSum = getSum();
            sb.append("#" + test_case + " " + ansSum + "\n");

        }
        System.out.print(sb);
    }
}