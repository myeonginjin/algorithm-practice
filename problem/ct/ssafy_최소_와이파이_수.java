// 현재의 선택이 다른 선택보다 항상 더 좋은 결과로 이어지도록 한다면, 그 선택을 지속적으로 행해주면서 답을 구한다.
// 그리디 문제 방법 
// 어떤 선택이 계속 행했을 때 정답을 출력하는지, 반례는 없는지 확인하고 반복문 실행

import java.util.Scanner;

public class ssafy_최소_와이파이_수 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int r = m * 2 + 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    cnt++;
                    int nextIndex = i + r - 1;
                    if (nextIndex >= n) {
                        break;
                    }
                    i = nextIndex;
                }
            }
            System.out.print(cnt);
        }
    }
}