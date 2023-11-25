
/*
본 코드는 테스크케이스 중 마지막 1개를 통과하지 못한 문제가 있는 코드입니다. 
 */

// 문제 정의 확실하게 읽기
// main 함수에서 반복문 돌리지않기(배열 채우기 제외), 시뮬레이션 문제는 여러개의 함수로 과정 쪼개기

// 2023/10/20 코드 디버깅 완료.
// 틀렸던 이유 - 39번줄, 정사각형 이외 #이 등장하지 않는지 탐색하는 반복문에서 행 r, 열 c 에서부터만 탐색을 시작해서 왼쪽아래는 탐색하지않게됨
// simul에서 첫 # 등장 이후로 탐색을 시작해서 시작 행은  r이어도 되지만, 열의 탐색 범위는 맨 왼쪽부터 맨 오른쪽이어야 한다(0~n)

// 탐색과 같은 문제들은 로직을 떠올리고 수기로 계획을 세운 뒤 구현할 것 

package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution13732 {

    public static int n;
    public static char[][] arr = new char[21][21];

    public static boolean check(int r, int c) {

        int len = 0;

        for (int i = c; i < n; i++) {
            if (arr[r][i] == '#')
                len++;
        }

        for (int i = r; i < r + len; i++) {
            for (int j = c; j < c + len; j++) {
                if (arr[i][j] != '#')
                    return false;
            }
        }

        for (int i = r; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= r && i < r + len && j >= c && j < c + len) {
                    continue;
                }
                if (arr[i][j] == '#')
                    return false;
            }
        }

        return true;

    }

    public static boolean simul() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == '#') {
                    if (check(i, j))
                        return true;
                    else
                        return false;
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

            int sCnt = 0;

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                for (int j = 0; j < n; j++) {
                    if (str.charAt(j) == '#')
                        sCnt++;
                    arr[i][j] = str.charAt(j);
                }
            }

            if (sCnt == 1)
                sb.append("#" + test_case + " " + "yes\n");

            else {

                if (simul())
                    sb.append("#" + test_case + " " + "yes\n");
                else
                    sb.append("#" + test_case + " " + "no\n");

            }

        }
        System.out.print(sb);
    }
}