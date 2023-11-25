package D3;

// 테케 폭넓게 생각하기

//import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

class Solution14413 {
    public static int n, m;
    public static char[][] arr = new char[50][50];

    public static boolean indexOk(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

    public static boolean checkSide(int r, int c) {
        int[] dr = new int[] { -1, 1, 0, 0 };
        int[] dc = new int[] { 0, 0, -1, 1 };

        char[] sideArr = new char[4];
        int cnt = 0;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (indexOk(nextR, nextC)) {
                sideArr[cnt++] = arr[nextR][nextC];
            }
        }

        if (arr[r][c] == '.') {
            for (int i = 0; i < cnt; i++) {
                if (sideArr[i] == '.')
                    return false;
            }

        } else if (arr[r][c] == '#') {
            for (int i = 0; i < cnt; i++) {
                if (sideArr[i] == '#')
                    return false;
            }
        }

        else if (arr[r][c] == '?') {
            boolean findD = false;
            boolean findS = false;

            for (int i = 0; i < cnt; i++) {
                if (sideArr[i] == '#') {
                    findS = true;
                } else if (sideArr[i] == '.') {
                    findD = true;
                }
            }
            if (findS && findD)
                return false;
            else if (findS)
                arr[r][c] = '.';
            else if (findD)
                arr[r][c] = '#';

        }

        return true;

    }

    // # . ? ? ? ?
    // ? # ? ? ? ?
    // ? ? ? . ? ?

    public static boolean fillArr() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!checkSide(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            if (fillArr()) {
                sb.append("#" + test_case + " " + "possible" + "\n");
            } else {
                sb.append("#" + test_case + " " + "impossible" + "\n");
            }

        }
        System.out.print(sb);
    }
}