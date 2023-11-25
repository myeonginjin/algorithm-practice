package D2;
//SWEA 1970

// 우리나라 화폐 ‘원’은 금액이 높은 돈을 우선적으로 계산할 때 돈의 개수가 가장 최소가 된다.

// S마켓에서 사용하는 돈의 종류는 다음과 같다.
// 50,000 원
// 10,000 원
// 5,000 원
// 1,000 원
// 500 원
// 100 원
// 50 원
// 10 원

// S마켓에서 손님에게 거슬러 주어야 할 금액 N이 입력되면 돈의 최소 개수로 거슬러 주기 위하여 각 종류의 돈이 몇 개씩 필요한지 출력하라.

// 유의사항 : 지폐 단위가 몇개 쓰였는지 개수를 세는 배열의 초기화 위치 설정 혹은 초기화 해주기.

import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution1970 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[] { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

        for (int test_case = 1; test_case <= T; test_case++) {
            int[] cntArr = new int[8];
            int price = Integer.parseInt(br.readLine());

            for (int i = 0; i < arr.length; i++) {
                if (price >= arr[i]) {
                    cntArr[i] = price / arr[i];
                    price = price % arr[i];
                }
            }

            bw.write("#" + test_case + "\n");
            for (int i = 0; i < cntArr.length; i++) {
                bw.write(cntArr[i] + " ");
            }

            bw.write("\n");

        }
        bw.close();
        br.close();

    }
}
//
// 2
// 32850
// 160