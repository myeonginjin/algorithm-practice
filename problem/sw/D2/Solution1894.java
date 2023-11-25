package D2;
//SWEA 1984. 중간 평균값 구하기

// 10개의 수를 입력 받아, 최대 수와 최소 수를 제외한 나머지의 평균값을 출력하는 프로그램을 작성하라.
// (소수점 첫째 자리에서 반올림한 정수를 출력한다.)

// [제약 사항]

// 각 수는 0 이상 10000 이하의 정수이다.

// [입력]
// 가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
// 각 테스트 케이스의 첫 번째 줄에는 10개의 수가 주어진다.

// [출력]
// 출력의 각 줄은 '#t'로 시작하고, 공백을 한 칸 둔 다음 정답을 출력한다.
// (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

// 유의사항 : 평균을 계산하는 과정에서 double 선언함과 더불어 나누는 값을 실수로 만들어야 나누기가 딱 떨어지는 상황에도 실수로 저장된다. 나누는 수 뒤에 .0 붙여주기
// 유의사항 : String.format("%.0f", num) 사용해서 반올림해주기

import java.io.*;

import java.util.StringTokenizer;

class Solution1894 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int sum = 0;

            int maxNum = 0;
            int minNum = 1001;

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(st.nextToken());

                if (maxNum < num)
                    maxNum = num;
                else if (minNum > num)
                    minNum = num;
                sum += num;
            }

            double ansNum = (sum - minNum - maxNum) / 8.0;
            String strNum = String.format("%.0f", ansNum);

            System.out.print("#" + test_case + " " + strNum);
            System.out.println();

        }
    }
}
