package D2;
// SWEA 1954. 달팽이 숫자

// 달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.

// 다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.

// 유의사항 : 배열, n , 현재 인덱스 등 변수들의 초기화 위치
// 유의사항 : 반복문 탈출 조건 

import java.lang.StringBuilder;
import java.util.Scanner;

class Solution1954 {

    public static Scanner sc = new Scanner(System.in);
    public static int T, n;
    public static StringBuilder sb = new StringBuilder();

    public static boolean indexOk(int r, int c) {
        return r >= 0 & r < n && c >= 0 && c < n;
    }

    public static void main(String args[]) throws Exception {

        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int dir = 0;
            n = sc.nextInt();
            int num = 1;
            int[][] arr = new int[n][n];
            int curR = 0, curC = 0;

            arr[0][0] = num;

            int[] dr = new int[] { 0, 1, 0, -1 };
            int[] dc = new int[] { 1, 0, -1, 0 };

            int range = n * n;

            while (true) {

                if (num == range)
                    break;

                int nextR = curR + dr[dir];
                int nextC = curC + dc[dir];

                if (indexOk(nextR, nextC) && arr[nextR][nextC] == 0) {
                    num += 1;
                    arr[nextR][nextC] = num;
                    curR = nextR;
                    curC = nextC;
                } else
                    dir = (dir + 1) % 4;

            }
            sb.append("#" + test_case + "\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }

        }

        System.out.print(sb);
    }
}
