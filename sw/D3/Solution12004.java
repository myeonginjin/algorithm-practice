package D3;

// import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution12004 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        // StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            boolean ans = false;

            for (int i = 1; i < 10; i++) {
                if (n % i == 0 && n / i < 10) {
                    ans = true;
                }
            }

            String ansS = ans ? "Yes" : "No";

            sb.append("#" + test_case + " " + ansS + "\n");

        }
        System.out.print(sb);
    }
}
