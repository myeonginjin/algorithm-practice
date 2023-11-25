
// 특정 규칙을 찾아내어 푸는 문제 같은 경우, 
// 복잡한 반복문을 사용해서 풀기 보다는, 입력값은 다양하더라도 출력 결과 값은 소수의 케이스로 분류되는경우,
// 규칙에 의해 입력값을 바로 적절한 출력값으로 바꾸는 코드를 작성해야한다.

// 중간값이 아닌 '사이' 처럼 단어의 의미차이로 문제를 잘못 해석할 수 있는 경우 조심하기 

import java.util.Scanner;

public class ssafy_연속된_숫자_만들기2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int cnt = 0;

            if (a + 1 == b && b + 1 == c || a - 1 == b && b - 1 == c)
                cnt = 0;

            else {
                int abs1 = Math.abs(a - b);
                int abs2 = Math.abs(b - c);

                if (abs1 == 2 || abs2 == 2)
                    cnt = 1;

                else {
                    cnt = 2;
                }
            }

            System.out.print(cnt);
        }
    }
}