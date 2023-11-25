package D3;

// 변수 초기화 위치 조심하기. 출력할 모든 변수는 첫번째 포문(i가 T인 반복문) 안에 작성되어 매번 테스트케이스마다 초기화되어야 한다.

// import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution16910 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        // String str;
        // StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int r = Integer.parseInt(br.readLine());

            int cnt = 0;
            int side = 0;

            for (int x = 1; x < r; x++) {
                for (int y = 1; y < r; y++) {
                    if (x * x + y * y <= r * r) {
                        side++;
                    }
                }
            }

            cnt += side * 4;
            cnt += 1; // (0,0)
            cnt += r * 4;

            sb.append("#" + test_case + " " + cnt + "\n");

        }
        System.out.print(sb);

    }
}
