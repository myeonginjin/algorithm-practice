package D2;
// SWEA 1966. 숫자를 정렬하자

// 주어진 N 길이의 숫자열을 오름차순으로 정렬하여 출력하라.

// [제약 사항]
// N 은 5 이상 50 이하이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에 N 이 주어지고, 다음 줄에 N 개의 숫자가 주어진다.

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

class Solution1966 {
    public static void main(String args[]) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            String str = br.readLine();

            StringTokenizer st = new StringTokenizer(str);

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            bw.write("#" + test_case + " ");

            for (int i = 0; i < n; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");

        }
        br.close();
        bw.close();
    }
}