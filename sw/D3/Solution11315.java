package D3;

import java.io.*;
import java.lang.StringBuilder;

class Solution11315 {
    public static int n;
    public static int[][] arr = new int[20][20];

    public static boolean indexOk(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static boolean check1(int r, int c) {
        // 가로 체크
        for (int j = c; j < c + 5; j++) {
            if (!indexOk(r, j))
                return false;
            else if (arr[r][j] == 0)
                return false;
        }
        return true;
    }

    public static boolean check2(int r, int c) {

        for (int i = r; i < r + 5; i++) {
            if (!indexOk(i, c))
                return false;
            else if (arr[i][c] == 0)
                return false;
        }
        return true;
    }

    public static boolean check3(int r, int c) {
        int col = c;

        for (int i = r; i < r + 5; i++) {
            if (!indexOk(i, col))
                return false;
            else if (arr[i][col] == 0)
                return false;
            col++;
        }
        return true;
    }

    public static boolean check4(int r, int c) {
        int col = c;

        for (int i = r; i < r + 5; i++) {
            if (!indexOk(i, col))
                return false;
            else if (arr[i][col] == 0)
                return false;
            col--;
        }
        return true;
    }

    public static boolean simul() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    if (check1(i, j) || check2(i, j) || check3(i, j) || check4(i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            n = Integer.parseInt(br.readLine());

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    char chr = str.charAt(j);
                    if (chr == 'o')
                        arr[i][j] = 1;
                    else
                        arr[i][j] = 0;
                }
            }
            String ans = simul() ? "YES" : "NO";
            sb.append("#" + test_case + " " + ans + "\n");
        }
        System.out.print(sb);
    }
}