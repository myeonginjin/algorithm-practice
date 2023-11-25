
// 답이 증가할 경우, 즉 유먕함이 보일 경우 답으로 추가할 수 있는지 확인하는 탐색에서는
// 탐색 종류 후 돌아올때 이미 탐색 한 구간은 다시 탐색하는 것을 막기 위해, 기존 인뎃으에 탐색 구간 바로 다음 인덱스를 전달해주고
// 꼭 해당 탐색을 종료하는 break를 선언해주어야한다

package D3;

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution1220 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = 10;
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];
            String str;
            for (int i = 0; i < n; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int ansCnt = 0;

            for (int j = 0; j < n; j++) {
                for (int i = 0; i < n; i++) {
                    if (arr[i][j] == 1) {
                        for (int k = i + 1; k < n; k++) {
                            if (arr[k][j] == 2) {
                                ansCnt++;
                                i = k;
                                break;
                            }
                        }
                    }
                }
            }

            sb.append("#" + test_case + " " + ansCnt + "\n");

        }
        System.out.print(sb);

    }
}