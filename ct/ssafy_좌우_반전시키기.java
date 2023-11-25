
// ^ 비트 연산자 활용, 두 값(비트 값인 0 아니면 1, 단 10진수를 넣어도 2진수로 변한 뒤 계산)을 비교하여 같으면 0, 다르면 1 리턴
// 입력값 n에 대해서, 범위 첫번째 값과 마지막 값은 꼭 넣어보고 테스트하기. 중간 값들도 많이많이 디버깅 필수 

import java.util.Scanner;

public class ssafy_좌우_반전시키기 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int cnt = 0;

            if (n == 1) {
                if (arr[0] == 1)
                    cnt = 0;
                else
                    cnt = -1;
            } else {
                for (int i = 1; i < n; i++) {

                    if (i == n - 1) {
                        if (arr[i] == 1 && arr[i - 1] == 0)
                            cnt = -1;

                        else if (arr[i - 1] == 1 && arr[i] == 0)
                            cnt = -1;
                        else {
                            if (arr[i] == 0) {
                                cnt++;
                            } else {
                                break;
                            }
                        }
                    }

                    else if (arr[i - 1] == 0) {

                        arr[i] ^= 1;

                        arr[i + 1] = arr[i + 1] ^ 1;

                        cnt++;
                    }
                }

            }
            System.out.print(cnt);
        }
    }
}