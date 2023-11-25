package D2;
// SWEA 1974. 스도쿠 검증

// 스도쿠는 숫자퍼즐로, 가로 9칸 세로 9칸으로 이루어져 있는 표에 1 부터 9 까지의 숫자를 채워넣는 퍼즐이다.
// 같은 줄에 1 에서 9 까지의 숫자를 한번씩만 넣고, 3 x 3 크기의 작은 격자 또한, 1 에서 9 까지의 숫자가 겹치지 않아야 한다.
// 입력으로 9 X 9 크기의 스도쿠 퍼즐의 숫자들이 주어졌을 때, 위와 같이 겹치는 숫자가 없을 경우, 1을 정답으로 출력하고 그렇지 않을
// 경우 0 을 출력한다.

// [제약 사항]
// 1. 퍼즐은 모두 숫자로 채워진 상태로 주어진다.
// 2. 입력으로 주어지는 퍼즐의 모든 숫자는 1 이상 9 이하의 정수이다.

// [입력]
// 입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
// 다음 줄부터 각 테스트 케이스가 주어진다.
// 테스트 케이스는 9 x 9 크기의 퍼즐의 데이터이다.

// 유의사항 : 중첩 for이 많은 경우에는 인덱스 변수를 잘 살펴보자
// 유의사항 : T=1의 테스트케이스를 만들어 디버깅하자

import java.util.StringTokenizer;
import java.io.*;

class Solution1974 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int[][] arr = new int[9][9];

            for (int i = 0; i < 9; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);

                for (int j = 0; j < 9; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean ok = true;

            // 가로줄 탐색
            for (int i = 0; i < 9; i++) {
                boolean[] choosedArr = new boolean[10];

                if (!ok)
                    break;

                for (int j = 0; j < 9; j++) {
                    if (choosedArr[arr[i][j]] == true) {
                        ok = false;
                        break;
                    }
                    choosedArr[arr[i][j]] = true;

                }
            }

            if (!ok) {

                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            // 가로줄 탐색
            for (int i = 0; i < 9; i++) {
                boolean[] choosedArr = new boolean[10];

                if (!ok)
                    break;

                for (int j = 0; j < 9; j++) {
                    if (choosedArr[arr[j][i]] == true) {
                        ok = false;
                        break;
                    }
                    choosedArr[arr[j][i]] = true;

                }
            }

            if (!ok) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            // 사각형 탐색

            for (int i = 0; i < 9; i += 3) {
                for (int j = 0; j < 9; j += 3) {

                    if (!ok)
                        break;
                    boolean[] choosedArr = new boolean[10];

                    for (int k = i; k <= i + 2; k++) {
                        for (int s = j; s <= j + 2; s++) {

                            if (choosedArr[arr[k][s]]) {
                                ok = false;
                                break;
                            }
                            choosedArr[arr[k][s]] = true;
                        }
                    }

                }
            }
            if (!ok) {
                System.out.println("#" + test_case + " " + 0);
                continue;
            }

            System.out.println("#" + test_case + " " + 1);

        }
    }
}