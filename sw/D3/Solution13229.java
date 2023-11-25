package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution13229 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        String[] arr = new String[] { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        for (int test_case = 1; test_case <= T; test_case++) {

            String week = br.readLine();
            int index = 0;

            for (int i = 0; i < arr.length; i++) {
                if (week.equals(arr[i]))
                    index = i + 1;
            }

            int ans = 7 - index;

            if (ans == 0)
                ans = 7;

            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);
    }
}