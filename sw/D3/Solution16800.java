package D3;


// 당신은 무한히 많은 행과 열이 있는 곱셈표 위에 서 있다. (i, j)셀에는 정수 ixj 가 적혀 있다. (만약 행과 열이 9개라면 이는 구구단 표와 동일하다.) 현재 당신의 위치는 셀 (1, 1) 이다.
// 당신은 곱셈표의 오른쪽이나 아래쪽 방향으로 이동할 수 있다. 즉, 당신이 (i, j)에 서 있다면, (i+1, j)나 (i, j+1)로 이동할 수 있다.
// 정수 N이 주어질 때, N이 적혀 있는 어떤 셀에 도착하기 위해서 최소 몇 번 움직여야 하는가?

// [입력]
// 첫 번째 줄에 테스트 케이스의 수 TC가 주어진다. 이후 TC개의 테스트 케이스가 새 줄로 구분되어 주어진다. 각 테스트 케이스는 다음과 같이 구성되었다.
//  l 첫 번째 줄에 정수 N이 주어진다. (2 <= N <= 10^12)

// 유의사항 : 구구단 배열에서 약수가 없는 수는 최장거리(해당 수 -1)만큼 이동해야한다. 최장거리인 가장자리를 제외한 구구단 안쪽 수들은 어떠한 수의 배수들만 존재하기 떄문.
// 유의사항 : 약수의 한 쌍에서 작은 쪽은 해당 수의 최대공약수를 넘지 못한다. 즉 약수 쌍에서 작은 쪽을 구할 때에는 최대공약수까지만 for문을 돌려준다. 이때 Math.sqrt(num)를 사용한다.

import java.io.*;

class Solution16800 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            long n = Long.parseLong(br.readLine());

            long minStep = n - 1;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    long step = (i - 1) + (n / i - 1);
                    minStep = Math.min(minStep, step);
                }

            }
            System.out.println("#" + test_case + " " + minStep);

        }

    }
}
