package D2;
//SWEA 1979. 어디에 단어가 들어갈 수 있을까

// N X N 크기의 단어 퍼즐을 만들려고 한다. 입력으로 단어 퍼즐의 모양이 주어진다.

// 주어진 퍼즐 모양에서 특정 길이 K를 갖는 단어가 들어갈 수 있는 자리의 수를 출력하는 프로그램을 작성하라.
// 입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.

// 다음 줄부터 각 테스트 케이스가 주어진다.

// 테스트 케이스의 첫 번째 줄에는 단어 퍼즐의 가로, 세로 길이 N 과, 단어의 길이 K 가 주어진다.

// 테스트 케이스의 두 번째 줄부터 퍼즐의 모양이 2차원 정보로 주어진다.

// 퍼즐의 각 셀 중, 흰색 부분은 1, 검은색 부분은 0 으로 주어진다.

// 유의사항 : 아웃오브 인덱스
// 유의사항 : !!! 문제의 조건을 잘 파악할 것. k 길이만큼 빈칸이라도 양쪽 끝 앞, 뒤 블럭이 막혀있거나 아웃오브 인덱스이어야 함.

import java.util.StringTokenizer;
import java.io.*;

class Solution1979 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String elm = br.readLine();
                StringTokenizer stElm = new StringTokenizer(elm);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(stElm.nextToken());
                }
            }

            int cnt = 0; // 들어갈 수 있는 자리 개

            // 가로 들어갈 수 있는 자리 탐색

            // 가로 들어갈 수 있는 자리 탐색
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n - k; j++) {
                    if (arr[i][j] == 0)
                        continue; // 검은블럭에서 시작 못함

                    boolean haveKlen = true;
                    for (int s = j; s < j + k; s++) { // k칸 수만큼 흰블럭 아니라면 안됨
                        if (arr[i][s] != 1)
                            haveKlen = false;
                    }
                    if (!haveKlen)
                        continue;

                    // 여기서 부터 k만큼의 자릿수는 있는 상태 - 양쪽끝이 막혀있지 않거나 1이 아닌 경우

                    if (j == 0) { // 시작점
                        if (arr[i][j + k] == 0)
                            cnt++;
                    } else if (j == n - k) { // 끝점
                        if (arr[i][j - 1] == 0)
                            cnt++;
                    } else { // 중간이라면 양쪽끝 다 막혀있어야됨
                        if (arr[i][j - 1] == 0 && arr[i][j + k] == 0)
                            cnt++;
                    }
                }
            }
            for (int i = 0; i <= n - k; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == 0)
                        continue; // 검은블럭에서 시작 못함

                    boolean haveKlen = true;
                    for (int s = i; s < i + k; s++) { // k칸 수만큼 흰블럭 아니라면 안됨
                        if (arr[s][j] != 1)
                            haveKlen = false;
                    }
                    if (!haveKlen)
                        continue;

                    // 여기서 부터 k만큼의 자릿수는 있는 상태 - 양쪽끝이 막혀있지 않거나 1이 아닌 경우

                    if (i == 0) { // 시작점
                        if (arr[i + k][j] == 0)
                            cnt++;
                    } else if (i == n - k) { // 끝점
                        if (arr[i - 1][j] == 0)
                            cnt++;
                    } else { // 중간이라면 양쪽끝 다 막혀있어야됨
                        if (arr[i - 1][j] == 0 && arr[i + k][j] == 0)
                            cnt++;
                    }
                }
            }

            System.out.println("#" + test_case + " " + cnt);

        }
    }
}