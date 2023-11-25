package D2;
// SWEA 1976. 시각 덧셈

// 시 분으로 이루어진 시각을 2개 입력 받아, 더한 값을 시 분으로 출력하는 프로그램을 작성하라.
// (시각은 12시간제로 표시한다. 즉, 시가 가질 수 있는 값은 1시부터 12시이다.)

// [제약 사항]
// 시는 1 이상 12 이하의 정수이다. 분은 0 이상 59 이하의 정수이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에는 4개의 수가 주어진다.
// 첫 번째 수가 시를 나타내고 두 번째 수가 분을 나타낸다. 그 다음 같은 형식으로 두 번째 시각이 주어진다.

// 유의사항 : !!! 12시까지만을 표현하는 시계에서 00시는 없다. 그러므로 24시가 되었을 때 24%12 = 0이되는 경우를 고려해, 0시는 12시로 바꿔줘야한다.

import java.util.StringTokenizer;
import java.io.*;

class Solution1976 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        /*
         * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
         */

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int h = h1 + h2;

            int m = m1 + m2;

            int mOut = 0;
            int mLast = 0;

            if (m >= 60) {
                mLast = m % 60;
                mOut = m / 60;
            }

            h += mOut;

            if (h > 12) {
                h = h % 12;
            }

            if (mLast == 0)
                mLast = m;
            if (h == 0)
                h = 12;

            System.out.println("#" + test_case + " " + h + " " + mLast);

        }
    }
}
