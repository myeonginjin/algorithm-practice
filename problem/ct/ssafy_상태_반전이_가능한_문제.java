// 구간 단위를 뒤집는 문제의 경우, 굳이 겹치진 구간을 건들이는, 겹쳐서 해결하는 방식을 사용하지 않아도 된다.
// 구간별로 나눠서 반전 동작을 몇번 수행하는지 그리디로 접근한다면 결과를 위한 매번 최선의 선택이다

import java.util.Scanner;

public class ssafy_상태_반전이_가능한_문제 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int[] arr1 = new int[n];
            int[] arr2 = new int[n];

            String str = sc.next();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == 'G')
                    arr1[i] = 1;
                else
                    arr1[i] = 0;
            }

            str = sc.next();
            for (int i = 0; i < n; i++) {
                if (str.charAt(i) == 'G')
                    arr2[i] = 1;
                else
                    arr2[i] = 0;
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (arr1[i] == arr2[i])
                    continue;

                else {
                    cnt++;

                    for (int j = i; j < n; j++) {
                        if (arr1[j] != arr2[j]) {
                            i++;
                            continue;
                        } else {
                            i = j;
                            break;
                        }

                    }
                }
            }
            System.out.print(cnt);
        }

    }
}