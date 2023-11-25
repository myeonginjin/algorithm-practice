package D3;

// br.readLine().trim 사용할 시 공백 제거. 한 줄에 한 값만 가져오는 경우 유리

import java.io.*;
import java.lang.StringBuilder;

class Solution15941 {

    public static boolean check(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return true;
        }
        return false;
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine().trim());

            sb.append("#" + test_case + " " + n * n + "\n");

        }
        System.out.print(sb);

    }
}
