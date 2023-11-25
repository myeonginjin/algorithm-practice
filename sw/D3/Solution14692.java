package D3;

// 예외처리할 복잡한 문제가 아니라면 최대한 쉽게, 최적의 복잡도로 풀 수 있는방법으로 접근하기

// import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution14692 {
    public static void main(String args[]) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // StringTokenizer st;
        int num;
        String ans;

        for (int test_case = 1; test_case <= T; test_case++) {
            num = Integer.parseInt(br.readLine());

            ans = num % 2 == 0 ? "Alice" : "Bob";

            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);
    }
}