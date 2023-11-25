package D3;

import java.util.StringTokenizer;
// import java.util.Arrays;
import java.io.*;
import java.lang.StringBuilder;

class Solution1206 {
    public static int n;
    public static int[] arr = new int[1000];

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // int T = Integer.parseInt(br.readLine());
        int T = 10;
        StringBuilder sb = new StringBuilder();
        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            str = br.readLine();
            st = new StringTokenizer(str);
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int ansCnt = 0;
            for (int i = 2; i < n - 2; i++) {
                int t = arr[i];

                if (arr[i - 1] < t && arr[i - 2] < t && arr[i + 1] < t && arr[i + 2] < t) {
                    // int[] talls = new int[] {arr[i-1],arr[i-2],arr[i+1],arr[i+2]};
                    // Arrays.sort(talls);
                    // int dif = talls[3];
                    int dif = Math.max(Math.max(arr[i - 1], arr[i - 2]), Math.max(arr[i + 1], arr[i + 2]));
                    ansCnt += t - dif;
                }
            }
            sb.append("#" + test_case + " " + ansCnt + "\n");
        }
        System.out.print(sb);
    }
}
