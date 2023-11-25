package D3;

import java.lang.StringBuilder;

import java.io.*;

class Solution2805 {
    public static int n;
    public static int[][] arr = new int[50][50];

    public static int simul() {
        int sum = 0;
        int index = n / 2;

        for (int i = 0; i < n; i++) {
            sum += arr[index][i];
        }

        int str = 1;
        int las = n - 1;
        for (int i = index - 1; i >= 0; i--) {

            for (int j = str; j < las; j++) {
                sum += arr[i][j];
            }
            str++;
            las--;
        }

        int str2 = 1;
        int las2 = n - 1;
        for (int i = index + 1; i < n; i++) {

            for (int j = str2; j < las2; j++) {
                sum += arr[i][j];
            }
            str2++;
            las2--;
        }

        return sum;

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {

            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(str.substring(j, j + 1));
                }
            }

            int ansS = simul();

            sb.append("#" + test_case + " " + ansS + "\n");

        }
        System.out.print(sb);
    }
}