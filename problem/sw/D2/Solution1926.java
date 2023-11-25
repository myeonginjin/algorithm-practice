package D2;
// SWEA 1926. 간단한 369게임

// 3 6 9 게임을 프로그램으로 제작중이다. 게임 규칙은 다음과 같다.
// 1. 숫자 1부터 순서대로 차례대로 말하되, “3” “6” “9” 가 들어가 있는 수는 말하지 않는다.
//   1 2 3 4 5 6 7 8 9…
// 2. "3" "6" "9"가 들어가 있는 수를 말하지 않는대신, 박수를 친다. 이 때, 박수는 해당 숫자가 들어간 개수만큼 쳐야 한다.  
// 예를 들어 숫자 35의 경우 박수 한 번, 숫자 36의 경우 박수를 두번 쳐야 한다.
// 입력으로 정수 N 이 주어졌을 때, 1~N 까지의 숫자를
// 게임 규칙에 맞게 출력하는 프로그램을 작성하라.
// 박수를 치는 부분은 숫자 대신, 박수 횟수에 맞게 “-“ 를 출력한다.
// 여기서 주의해야 할 것은 박수 한 번 칠 때는 - 이며, 박수를 두 번 칠 때는 - - 가 아닌 -- 이다. 
// [제약사항]
// N은 10이상 1,000이하의 정수이다. (10 ≤ N ≤ 1,000)
// [입력]
// 입력으로 정수 N 이 주어진다.
// [출력]
// 1 ~ N까지의 숫자를 게임 규칙에 맞게 출력한다.

// 솔루션 : 매 숫자마다 String으로 변한해준 뒤(Integer.toString()) 먼저 3,6,9를 포함하는지 확인한다(String.contains(""))
//         없으면 그대로 출력하고, 있으면 for문을통해 해당 문자열을 탐색하며 3,6,9가 나올때마다 버터드라이터에 -를 써준다. 마지막에 공백추가 필수

import java.util.Scanner;
import java.io.*;

class Solution1926 {
    public static void main(String args[]) throws Exception {

        try (Scanner sc = new Scanner(System.in)) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                String num = Integer.toString(test_case);

                if (num.contains("3") || num.contains("6") || num.contains("9")) {
                    for (int j = 0; j < num.length(); j++) {
                        if (num.charAt(j) == '3' || num.charAt(j) == '6' || num.charAt(j) == '9')
                            bw.write("-");
                    }
                    bw.write(" ");
                }

                else
                    bw.write(num + " ");

            }
            bw.close();
        }
    }
}