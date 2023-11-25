package D2;
// SWEA 2007. 패턴 마디의 길이

// 패턴에서 반복되는 부분을 마디라고 부른다. 문자열을 입력 받아 마디의 길이를 출력하는 프로그램을 작성하라.
// [제약 사항]

// 각 문자열의 길이는 30이다. 마디의 최대 길이는 10이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에는 길이가 30인 문자열이 주어진다.

// [출력]
// 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
// (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

// 유의사항 1. test_case가 1씩 증가할 때 마다 마디의 정보를 담고 있는 문자열 변수를 초기화해주어야한다.
// 유의사항 2. 문장의 첫 단어와 같은 단어가 등장했다고 해서 마디가 끝난게 아닐수도 있다. 마디안에 중복된 단어가 있을수도 있기 때문. 
//            마디 전체와 마디 길이만큼의 다음 인덱스들을 다 비교해주어야 함.

import java.io.*;

class Solution2007 {
    public static String word = "";

    public static boolean checkSame(int index, String str) {
        boolean same = true;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != str.charAt(index + i))
                same = false;
        }
        return same;

    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String sen = br.readLine();
            word += sen.charAt(0);

            for (int i = 1; i < sen.length() - 1; i++) {
                if (sen.charAt(0) == sen.charAt(i)) {
                    if (checkSame(i, sen)) {
                        System.out.printf("#%d %d", test_case, word.length());
                        System.out.println();
                        break;
                    }
                }
                word += sen.charAt(i);
            }
            word = "";

        }
    }
}
