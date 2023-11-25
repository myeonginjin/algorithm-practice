package D2;

import java.lang.StringBuilder;
import java.io.*;

class Solution1288 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            boolean[] choosedNum = new boolean[10];

            String n = br.readLine();
            int cnt = 0;
            String firN = n;

            String lastN = "";

            while (true) {
                cnt++;

                for (int i = 0; i < n.length(); i++) {
                    int nSub = Integer.parseInt(n.substring(i, i + 1));
                    choosedNum[nSub] = true;
                }

                boolean clear = true;
                for (int i = 0; i < 10; i++) {
                    if (!choosedNum[i]) {
                        clear = false;
                    }
                }
                if (clear) {
                    lastN = n;
                    break;
                }

                int nextN = Integer.parseInt(firN) * (cnt + 1);
                n = Integer.toString(nextN);

            }
            sb.append("#" + test_case + " " + lastN + "\n");

        }
        System.out.print(sb);
    }
}

// 숫자가 들어오면 모든 자리의 수에 해당하는 숫자 인덱스 true 처리
