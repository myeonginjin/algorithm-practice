
// 약간의 하드코딩 버전, 같은 열 행 대각선에 위치한지를 검사하는 로직이 깔끔하지않다.
// 재귀함수가 이중포문일 필요가 없다. 각 부모노드는 n개의 행부터 각 행에 무슨 열에 놓여있는가이고, 자식들은 그 다음 행의 모든 열... 이렇게 가기 때문에 
// 행의 값이 증가하는 for문 하나만으로 구현이 가능

package D3;

import java.io.*;
import java.lang.StringBuilder;
//import java.util.StringTokenizer;

class Solution2806 {
    public static int ans = 0;
    public static int n = 0;
    public static int[][] arr = new int[10][10];

    public static boolean canGo(int r, int c) {

        for (int i = 0; i < n; i++) {
            if (arr[i][c] == 1)
                return false;
        }
        for (int j = 0; j < n; j++) {
            if (arr[r][j] == 1)
                return false;
        }

        int[] dr = new int[] { -1, -1, 1, 1 };
        int[] dc = new int[] { -1, 1, 1, -1 };
        int dir = 0;

        int row = r;
        int col = c;

        while (dir <= 3) {

            row += dr[dir];
            col += dc[dir];
            if (row < 0 || row >= n || col < 0 || col >= n) {
                dir++;
                row = r;
                col = c;
            }
            if (dir >= 4)
                break;

            if (arr[row][col] == 1)
                return false;

        }
        return true;

    }

    public static void dfs(int row) {

        if (row == n) {
            ans++;
            return;
        }

        for (int j = 0; j < n; j++) {
            if (canGo(row, j)) {
                arr[row][j] = 1;

                dfs(row + 1);

                arr[row][j] = 0;
            }

        }

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // String str;
        // StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());

            ans = 0;
            dfs(0);
            sb.append("#" + test_case + " " + ans + "\n");

        }
        System.out.print(sb);
    }
}