package D2;

// SWEA 1284. 수도 요금 경쟁

// 그런데 집의 위치가 두 수도 회사 A, B 중간에 위치하기에 원하는 수도 회사를 선택할 수 있게 되었는데, 두 회사 중 더 적게 수도 요금을 부담해도 되는 회사를 고르려고 한다.
// 종민이가 알아본 결과 두 회사의 수도 요금은 한 달 동안 사용한 수도의 양에 따라 다음과 같이 정해진다.

// A사 : 1리터당 P원의 돈을 내야 한다.
// B사 : 기본 요금이 Q원이고, 월간 사용량이 R리터 이하인 경우 요금은 기본 요금만 청구된다. 하지만 R 리터보다 많은 양을 사용한 경우 초과량에 대해 1리터당 S원의 요금을 더 내야 한다.

// 종민이의 집에서 한 달간 사용하는 수도의 양이 W리터라고 할 때, 요금이 더 저렴한 회사를 골라 그 요금을 출력하는 프로그램을 작성하라.

// 유의사항 : 절댓값 쓸 거 아니면 꼭 큰 수에서 작은 수 빼서 오차 범위 구하기

import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.io.*;

class Solution1284 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            int P = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            int aPrice = W * P;
            int bPrice = 0;

            if (W <= R) {
                bPrice = Q;
            } else {
                int lastP = (W - R) * S;
                bPrice = Q + lastP;
            }

            sb.append("#" + test_case + " " + (aPrice > bPrice ? bPrice : aPrice) + "\n");

        }
        System.out.print(sb);
    }
}