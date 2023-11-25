// 그리디 문제는 규칙을 찾아서 풀기. 
// 꼭 반례와 모든 케이스를 나눠서 분석하기

import java.util.Scanner;

public class ssafy_홀수_짝수의_묶음 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int ans = 0;

            int odd = 0;
            int even = 0;

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                if (num % 2 != 0)
                    odd++;
                else
                    even++;
            }

            if (even > odd)
                ans = odd * 2 + 1;

            else if (even == odd)
                ans = even + odd;

            else {
                ans = even * 2;
                int size = odd - even;

                if (size % 3 == 0)
                    ans += (size / 3) * 2;

                else {
                    if ((size % 3) % 2 == 0)
                        ans += size / 3 * 2 + 1;
                    else
                        ans += size / 3 * 2 - 1;
                    ;
                }
            }

            System.out.print(ans);
        }
    }
}