package D2;

//SWEA 1946. 간단한 압축 풀기

// 원본 문서는 너비가 10인 여러 줄의 문자열로 이루어져 있다.
// 문자열은 마지막 줄을 제외하고 빈 공간 없이 알파벳으로 채워져 있고 마지막 줄은 왼쪽부터 채워져 있다.
// 이 문서를 압축한 문서는 알파벳과 그 알파벳의 연속된 개수로 이루어진 쌍들이 나열되어 있다. (예 : A 5    AAAAA)
// 압축된 문서를 입력 받아 원본 문서를 만드는 프로그램을 작성하시오.

// [예제]
// 압축된 문서의 내용

// A 10
// B 7
// C 5

// 압축을 풀었을 때 원본 문서의 내용
// AAAAAAAAAA
// BBBBBBBCCC
// CC

// 유의사항 : 동적리스트는 객체만 넣을 수 있음. char안되기에 String 넣어야함

import java.util.ArrayList;
import java.io.*;
import java.lang.StringBuilder;
import java.util.StringTokenizer;

class Solution1946 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<String> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);
                String word = st.nextToken();
                int cnt = Integer.parseInt(st.nextToken());

                for (int s = 0; s < cnt; s++) {
                    arr.add(word);
                }
            }

            sb.append("#" + test_case + "\n");

            for (int i = 0; i < arr.size(); i++) {
                if (i != 0 && i % 10 == 0)
                    sb.append("\n");
                sb.append(arr.get(i));
            }
            sb.append("\n");

        }
        System.out.print(sb);
    }
}