
// 겹치는 지점을 찾을 때에는 구간 입력값을 받을 때, 시작점과 끝 지점까지의 인덱스에 +1
// 겹치는 구간을 찾을 때에는 구간 입력값을 받을 때, 시작점과 끝지점-1까지의 인덱스에 +1
// 왜? 구간은 끝지점이 겹치는 경우는 겹치는 것으로 인정하지 않기 때문에 모든 선분의 끝지점을 구간으로 인정하지 않음으로서 해결

// 선분의 범위로 -가 들어오는 경우에는 입력의 최소값이 0이 되는 오프셋 값을 정한뒤, 입력되는 모든 값에 이 값을 더해주는 것으로 해결, 
// 이때, 배열의 크기는 입력값의 최대값 + 오프셋 값 + 1 해야 초과안됨

import java.util.Scanner;

public class ssafy_구간_칠하기 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int[] arr = new int[201];
            for (int i = 0; i < n; i++) {
                int str = sc.nextInt() + 100;
                int las = sc.nextInt() + 100;

                for (int j = str; j < las; j++) {
                    arr[j] += 1;
                }
            }

            int max = 0;

            for (int i = 0; i < 201; i++) {
                max = Math.max(max, arr[i]);
            }
            System.out.print(max);
        }
    }
}