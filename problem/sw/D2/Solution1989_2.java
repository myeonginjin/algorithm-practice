package D2;

// SWEA 1989. 초심자의 회문 검사

// "level" 과 같이 거꾸로 읽어도 제대로 읽은 것과 같은 문장이나 낱말을 회문(回文, palindrome)이라 한다.
// 단어를 입력 받아 회문이면 1을 출력하고, 아니라면 0을 출력하는 프로그램을 작성하라.

// [제약 사항]
// 각 단어의 길이는 3 이상 10 이하이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에 하나의 단어가 주어진다.

// [출력]
// 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
// (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

// StringBuffer로 푸는 방법

import java.io.*;

class Solution1989_2 {
    public static void main(String args[]) throws Exception {

        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = new String(br.readLine());
            StringBuffer strB = new StringBuffer(str);

            if (strB.reverse().toString().equals(str))
                System.out.println("#" + test_case + " " + 1);
            else
                System.out.println("#" + test_case + " " + 0);

        }
    }
}
