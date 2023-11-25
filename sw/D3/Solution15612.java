package D3;

// 문자열로 한번에 받고 그걸 하나씩 쪼개서 배열에 담아야하는 경우, 문자열이 공백으로 나눠진 문자열이 아니라면 nextToken를 사용할 수 없다.
// charAt(n)를 사용하자.

// import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution15612 {
    public static void main(String args[]) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {

            int[][] arr = new int[8][8];

            int[] iArr = new int[8];
            int[] jArr = new int[8];

            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                // st = new StringTokenizer(str);

                for (int j = 0; j < 8; j++) {
                    char chr = str.charAt(j);
                    if (chr == 'O') {
                        arr[i][j] = 1;
                        iArr[i] += 1;
                        jArr[j] += 1;
                    } else {
                        arr[i][j] = 0;
                    }
                }
            }

            boolean ans = true;
            for (int i = 0; i < 8; i++) {
                if (iArr[i] + jArr[i] != 2) {
                    ans = false;
                }
            }
            String ansStr = ans ? "yes" : "no";

            sb.append("#" + test_case + " " + ansStr + "\n");

        }
        System.out.print(sb);
    }
}

// . . . . . . O .
// . . . . . . . O
// . . . O . . . .
// O . . . . . . .
// . . . . O . . .
// . . O . . . . .
// . O . . . . . .
// . . . . . O . .