
// 연속된 수의 개수를 계산하는 문제에서, 
// 조건문 분기로 정답 변수를 초기화 해주는 위치에 반목분이 끝날때까지 도달하지 않아, 답변수에 값을 넣어주지 못하는 경우가 잇을 수 있다.
// 때문에, 해당 조건문에 걸리는 시점이 반목문이 끝날때까지 오지않는 경우는 어떻게 해결할지 고민해야한다.
// 예를들어, 이 문제에 경우 연속이 끝나는 시점이 반복문 종료시점까지 나오지않는다면 정답 변수를 초기화해주는 로직 부분에 도달하지 못한다.
// 그렇기에 극단적인 테스크케이스를 시도해볼것. 모두 연속된 수열의 경우 혹은 모두 연속되지않은 수열의 경우 

import java.util.Scanner;

public class ssafy_연속된_수_2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int len = 1;
            int maxL = 1;

            int preN = sc.nextInt();

            for (int i = 1; i < n; i++) {
                int num = sc.nextInt();
                if (preN == num) {
                    len++;
                    maxL = Math.max(maxL, len);
                } else {
                    preN = num;
                    len = 1;
                }
            }
            System.out.print(maxL);
        }
    }
}