package D3;

// 수정이 필요한 코드 테스크케이스 32/100

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int ansD = 0;

            int[] arr = new int[7];
            String str = br.readLine();
            st = new StringTokenizer(str);

            int classNum = 0;

            for (int i = 0; i < 7; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                if (num == 1)
                    classNum++;
            }

            if (classNum < n) {
                if (n % classNum != 0) {
                    ansD = n / classNum * 7;
                    n = n % classNum;
                } else {
                    ansD = ((n / classNum) - 1) * 7;
                    n = 0;
                }

            }

            else {

                int minD = 100;

                for (int i = 0; i < 6; i++) {
                    int temp = n;

                    int d = 1;

                    if (arr[i] == 1) {
                        temp--;
                    }

                    for (int j = i + 1; j < 6; j++) {

                        if (temp == 0) {
                            break;
                        }

                        if (arr[j] == 1)
                            temp--;
                        d++;
                    }

                    if (minD > d)
                        minD = d;
                }
                sb.append("#" + test_case + " " + minD + "\n");
                continue;
            }

            for (int i = 6; i >= 0; i--) {
                if (arr[i] == 1)
                    n--;

                if (n == 0) {
                    ansD += 7 - i;
                    break;
                }
            }
            sb.append("#" + test_case + " " + ansD + "\n");

        }
        System.out.print(sb);
    }
}

/*
 * 100000 / 3 33333 * 7 + 나머지 먹을 일
 */