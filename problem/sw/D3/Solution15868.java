package D3;

// 이 문제에서는 사용하지 않지만, 숫자끼리 xor를 계산할 수 있는 연산자가 있다. 바로 비트 연산자 ^ 이다. num ^ num 이진수로 바꾼뒤 각 자리의 값이 다르면 그 자리 비트 인덱스를 1로, 같으면 0으로 채운 뒤 10진수로 바꿔 출력함.
// 예를 들어 10 ^ 15 는 5가 나옴

// boolean값끼리 비트연산자를 적용하면 true와 false랑 만난 경우에만 true 출력

import java.io.*;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

class Solution15868 {

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

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][m];

            for (int i = 0; i < n; i++) {
                String str2 = br.readLine();

                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(str2.substring(j, j + 1));
                }
            }

            boolean xor = true;

            for (int i = 0; i < n - 1; i++) {

                for (int j = 0; j < m; j++) {
                    if (arr[i][j] == arr[i + 1][j]) {
                        xor = false;
                    }
                }

            }

            String ans = xor ? "yes" : "no";

            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);

    }
}
