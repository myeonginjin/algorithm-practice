
// 그리디 문제가 항상 정답을 찾아주는 것은 아니다. 매번의 선택이 최선의 선택일 떄에만 적용 가능하다
// 동전 거슬러 주기를 예로 들 때에는, 동전의 값이 배수로 주어질 때 그리디를 사용할 수 있다. 가장 큰 값의 동전을 최대한 쓸 수 있는 만큼 쓰고 다음 약수의 값을 지닌 다음 
// 동전으로 넘어가도 매번 최선의 선택이기 때문이다 

import java.util.Scanner;
// import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class ssafy_동전_거슬러_주기 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int num = sc.nextInt();
                arr.add(num);
            }

            Collections.sort(arr, Collections.reverseOrder());

            int c = 0;

            for (int i = 0; i < n; i++) {
                c += m / arr.get(i);
                m %= arr.get(i);
            }

            System.out.print(c);
        }

    }
}