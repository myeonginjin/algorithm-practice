package D2;

// SWEA 1940. 가랏! RC카!

// 입력으로 매 초마다 아래와 같은 command 가 정수로 주어진다.

// 0 : 현재 속도 유지.
// 1 : 가속
// 2 : 감속

// 위 command 중, 가속(1) 또는 감속(2) 의 경우 가속도의 값이 추가로 주어진다.

// 가속도의 단위는, m/s2 이며, 모두 양의 정수로 주어진다.

// 입력으로 주어진 N 개의 command 를 모두 수행했을 때, N 초 동안 이동한 거리를 계산하는 프로그램을 작성하라.

// RC 카의 초기 속도는 0 m/s 이다.

// [예제]

// 아래 예제 입력에서 정답은 3 이 된다.

// 입력         시간     RC 카의 속도 RC     카의 이동거리
// 1 2          1 sec          2 m/s                    2 m
// 2 1          2 sec          1 m/s                    3 m

// 유의사항 : 속도가 음수가 되는 경우 예외처리
// 유의사항  : 변수의 초기화 위치

import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution1940 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int dis = 0;
            int ms = 0;

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                int type = Integer.parseInt(st.nextToken());
                int speed = 0;

                if (type > 0) {
                    speed = Integer.parseInt(st.nextToken());
                }

                if (type == 1) { // 현재 속도에 더 하기
                    ms += speed;
                    dis += ms;

                }

                else if (type == 2) { // 현재 속도 붙어있었다면 현재 속도에서 뺴기 그리고 거리에 더, 음수면 0으로 초기
                    ms -= speed;
                    if (ms < 0) {
                        ms = 0;
                    }
                    dis += ms;
                }

                else { // 현재 속도 유지. 현재 속도가 붙어있었다면 1초당안 해당 속도만큼 이동
                    if (ms > 0) {
                        dis += ms;
                    }
                }
            }
            sb.append("#" + test_case + " " + dis + "\n");
        }
        System.out.print(sb);
    }
}