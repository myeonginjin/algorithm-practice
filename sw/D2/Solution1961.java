package D2;

// SWEA 1961. 숫자 배열 회전

// N x N 행렬이 주어질 때,
// 시계 방향으로 90도, 180도, 270도 회전한 모양을 출력하라.

// [제약 사항]
// N은 3 이상 7 이하이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에 N이 주어지고,
// 다음 N 줄에는 N x N 행렬이 주어진다.

// 유의사항 : !!! 버터드라이터에 int타입은 쓸 수 가 없다. 그러므로 String으로 타입 변환이 필요한데,
//          이떄 Integer.toString(num) 혹은 num+"" 를 해주면 된다.

import java.util.StringTokenizer;
import java.io.*;

class Solution1961 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("#" + test_case + "\n");

            for (int s = 0; s < n; s++) { // 총 출력 !

                for (int i = n - 1; i >= 0; i--) { // j일정

                    bw.write(Integer.toString(arr[i][s]));
                }
                bw.write(" ");

                for (int j = n - 1; j >= 0; j--) { // i일정
                    bw.write(arr[n - s - 1][j] + "");
                }
                bw.write(" ");

                for (int i = 0; i < n; i++) { // j일정
                    bw.write(arr[i][n - s - 1] + "");
                }
                bw.write("\n");

            }
        }
        bw.close();
        br.close();
    }
}
