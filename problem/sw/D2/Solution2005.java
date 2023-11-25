package D2;

// SWEA 2005. 파스칼의 삼각형

// 크기가 N인 파스칼의 삼각형을 만들어야 한다.

// 파스칼의 삼각형이란 아래와 같은 규칙을 따른다.

// 1. 첫 번째 줄은 항상 숫자 1이다.

// 2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.

// N을 입력 받아 크기 N인 파스칼의 삼각형을 출력하는 프로그램을 작성하시오.

// 유의사항 : 배열 초기화 위치
// 개선사항 : 배열을 바꿔치기 하는 하드코딩 부분

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

class Solution2005 {
    public static void main(String args[]) throws Exception {

        try (Scanner sc = new Scanner(System.in)) {
            int T;
            T = sc.nextInt();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for (int test_case = 1; test_case <= T; test_case++) // 다음 삼각형
            {
                int n = sc.nextInt();
                System.out.println("#" + test_case);
                ArrayList<Integer> arr = new ArrayList<>();
                for (int i = 0; i < n; i++) { // 삼각형 만들어 출력하

                    if (i <= 1) { // 삼각형의 2번째 줄까
                        arr.add(1);

                    }

                    else {
                        ArrayList<Integer> arr2 = new ArrayList<>();
                        // 세번째줄 시작
                        arr2.add(1);

                        for (int t = 0; t < arr.size() - 1; t++) { // 배열 다시 만들어 주기
                            arr2.add(arr.get(t) + arr.get(t + 1));
                        }
                        arr2.add(1);

                        for (int k = 0; k < arr2.size(); k++) { // 실질적으로 삼각형 출
                            bw.write(Integer.toString(arr2.get(k)) + " ");

                        }
                        bw.write("\n");

                        arr.clear();
                        for (int s = 0; s < arr2.size(); s++) {
                            arr.add(arr2.get(s));
                        }
                        continue;
                    }

                    for (int k = 0; k < arr.size(); k++) { // 2번쨰 줄까지 여기서 출
                        bw.write(Integer.toString(arr.get(k)) + " ");
                    }

                    bw.write("\n");

                }
                bw.flush();

            }
        }
    }
}

// #1
// 1
// 1 1
// 1 2 1
// 1 3 3 1
// 1 4 6 4 1
