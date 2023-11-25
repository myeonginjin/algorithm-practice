package D2;
// SWEA 1959. 두 개의 숫자열

//N 개의 숫자로 구성된 숫자열 Ai (i=1~N) 와 M 개의 숫자로 구성된 숫자열 Bj (j=1~M) 가 있다.

// 아래는 N =3 인 Ai 와 M = 5 인 Bj 의 예이다.
// Ai 나 Bj 를 자유롭게 움직여서 숫자들이 서로 마주보는 위치를 변경할 수 있다.

// 단, 더 긴 쪽의 양끝을 벗어나서는 안 된다.
// 서로 마주보는 숫자들을 곱한 뒤 모두 더할 때 최댓값을 구하라.
// 위 예제의 정답은 아래와 같이 30 이 된다.

// 유의사항 : 비교 횟수를 위해 만든 for문에서, 횟수가 1부터 시작하는 것과 달리 i는 0부터 시작하는 것을 유의. 횟수만을 위한 반복문은 1부터 시작하든지, 최대값 범위에서 1을 빼주자.
// 유의사항 : 출력이 별로 메모리를 차지하지 않을 것 같은 경우에는 버터드리더만 사용하자

import java.util.StringTokenizer;
import java.io.*;

class Solution1959 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String numStr = br.readLine();
            StringTokenizer st = new StringTokenizer(numStr);
            int temp = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());

            int n = Math.min(temp, temp2);
            int m = Math.max(temp, temp2);

            int[] arrN = new int[n];
            int[] arrM = new int[m];

            String str1 = br.readLine();
            String str2 = br.readLine();

            StringTokenizer st1 = new StringTokenizer(str1);
            StringTokenizer st2 = new StringTokenizer(str2);

            if (str1.length() > str2.length()) {
                for (int i = 0; i < m; i++) {
                    arrM[i] = Integer.parseInt(st1.nextToken());
                }
                for (int i = 0; i < n; i++) {
                    arrN[i] = Integer.parseInt(st2.nextToken());
                }

            } else {
                for (int i = 0; i < m; i++) {
                    arrM[i] = Integer.parseInt(st2.nextToken());
                }
                for (int i = 0; i < n; i++) {
                    arrN[i] = Integer.parseInt(st1.nextToken());
                }

            }

            // 시작

            int maxSum = 0;

            for (int s = 0; s <= m - n; s++) { // 비교 횟수
                int sum = 0;

                for (int i = 0; i < n; i++) {
                    sum += arrN[i] * arrM[s + i];

                }
                if (sum > maxSum)
                    maxSum = sum;
            }
            bw.write("#" + test_case + " " + maxSum + "\n");

        }
        bw.close();
        br.close();
    }
}