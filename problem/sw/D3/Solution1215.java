//배열 탐색 문제, i와 j 1씩 증가하며 완전 탐색하는건지 구간으로 쪼개서 탐색하는건지 잘 확인
// 구간으로 나눠 탐색이더라도 i,j 1씩 증가시키며 모든 배얼의 시작점을 고려하는 문제일 수 있음

package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution1215 {

    public static int n;
    public static char[][] arr = new char[8][8];

    public static boolean check1(int r, int c) {
        String str = "";

        for (int j = c; j < c + n; j++) {
            if (j > 7)
                return false;
            str += arr[r][j];
        }

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static boolean check2(int r, int c) {
        String str = "";

        for (int i = r; i < r + n; i++) {
            if (i > 7)
                return false;
            str += arr[i][c];
        }

        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(br.readLine());
            int ansCnt = 0;
            String str;

            for (int i = 0; i < 8; i++) {
                str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    arr[i][j] = str.charAt(j);
                }
            }

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (check1(i, j))
                        ansCnt++;
                }
            }

            for (int j = 0; j < 8; j++) {
                for (int i = 0; i < 8; i++) {
                    if (check2(i, j))
                        ansCnt++;
                }
            }

            sb.append("#" + test_case + " " + ansCnt + "\n");

        }
        System.out.print(sb);
    }
}