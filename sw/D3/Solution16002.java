package D3;

// 약수가 있는지 검사하는 반복문의 i 최댓값은 인자로 넘어온 값의 완전제곱근이면 된다. Math.sqrt(num);
// 단순한 알고리즘이라도 절차가 있다면 함수 단위로 쪼개자.
// 문제를 쉽게 접근 하는 방법도 필요. 본 문제 같은 경우 두 수를 n*7 과 n*8로 지정하여 풀수도 있다. 1차이 나는 배수로 곱했음으로 차이도 n이고 n이라는 약수를 무조건 가지기 때문제 조건 충족.

import java.io.*;
import java.lang.StringBuilder;

class Solution16002 {

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

            for (int i = 2; i <= 1000000000; i++) {
                int ans1 = i + n;
                int ans2 = i;

                if (check(ans1) && check(ans2)) {
                    sb.append("#" + test_case + " " + ans1 + " " + ans2 + "\n");
                    break;
                }
            }

        }
        System.out.print(sb);

    }
}
