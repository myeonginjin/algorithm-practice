package D3;
//SWEA 12368.24시간

// 하루는 24시간이다. 24시간제 시계에서는 하루가 자정에서 시작해서 다음 날 자정에서 끝나며, 자정에서부터 지금까지 흐른 시간을 기준으로 시각을 표기한다. 예를 들어, 지금이 오후 8시라면 “20시”와 같은 꼴로 표현할 수 있다. 자정을 표기하는 유일한 방법은 “0시”임에 유의하라.
//   지금은 자정에서부터 정확히 A시간이 지났다. 앞으로 정확히 B시간이 더 지난다면, 24시간제 시계에서 그 때는 몇 시일까?

// [입력]
//   첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
//   각 테스트 케이스의 첫 번째 줄에는 두 개의 정수 A, B (0 ≤ A, B ≤ 23)이 공백 하나를 사이로 두고 순서대로 주어진다.

// [출력]
//   각 테스트 케이스마다, 현재 A시인 상황에서 앞으로 B시간이 지나면 몇 시가 되는지를 출력한다.

// 팁 : 여러 테스트케이스를 짜보며 규칙을 찾아낸다.

import java.io.*;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

class Solution12368 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());

            int newH = h1 + h2;

            if (newH < 24) {
                sb.append("#" + test_case + " " + newH + "\n");
            } else if (newH == 24) {
                sb.append("#" + test_case + " " + "0" + "\n");
            } else {
                int ans = newH / 12;
                int last = newH % 12;
                if (ans % 2 != 0) {
                    last += 12;
                    sb.append("#" + test_case + " " + last + "\n");
                } else {
                    sb.append("#" + test_case + " " + last + "\n");
                }
            }

        }
        System.out.print(sb);
    }
}
// 46 10
// 12 4
// 16
// 5 9 14
// 18 7 25

// 12로 나눴을 때 몫이 홀수면 12를 더해주고
// 12로 나웟을 떄 몫이 짝수면 그대로!