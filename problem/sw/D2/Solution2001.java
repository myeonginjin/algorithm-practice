package D2;
// SWEA 2001. 파리 퇴치

// N x N 배열 안의 숫자는 해당 영역에 존재하는 파리의 개수를 의미한다.
// M x M 크기의 파리채를 한 번 내리쳐 최대한 많은 파리를 죽이고자 한다.
// 죽은 파리의 개수를 구하라!

// [제약 사항]
// 1. N 은 5 이상 15 이하이다.
// 2. M은 2 이상 N 이하이다.
// 3. 각 영역의 파리 갯수는 30 이하 이다.
// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에 N 과 M 이 주어지고,
// 다음 N 줄에 걸쳐 N x N 배열이 주어진다.

// [출력]
// 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
// (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

// 유의사항1 : 변수 초기화 위치
// 유의사항2 : 아웃오브레인지 조심 

import java.io.*;
import java.util.StringTokenizer;

class Solution2001 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) { // 배열 채우기
                String str2 = br.readLine();
                StringTokenizer st2 = new StringTokenizer(str2);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st2.nextToken());
                }
            }

            int maxScore = 0;

            for (int i = 0; i <= n - m; i++) {
                for (int j = 0; j <= n - m; j++) {

                    int score = 0; // 사각형 안 점수 측정하기
                    for (int k = i; k <= i + m - 1; k++) {
                        for (int s = j; s <= j + m - 1; s++) {
                            score += arr[k][s];
                        }
                    }
                    if (score > maxScore)
                        maxScore = score;

                }

            }
            System.out.printf("#%d %d", test_case, maxScore);
            System.out.println();

        }
    }
}