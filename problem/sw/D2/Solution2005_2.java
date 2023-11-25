package D2;
// 파스칼의 삼각형 배열로 푸는 방법 !

// SWEA 2005. 파스칼의 삼각형

// 크기가 N인 파스칼의 삼각형을 만들어야 한다.

// 파스칼의 삼각형이란 아래와 같은 규칙을 따른다.

// 1. 첫 번째 줄은 항상 숫자 1이다.

// 2. 두 번째 줄부터 각 숫자들은 자신의 왼쪽과 오른쪽 위의 숫자의 합으로 구성된다.

// N을 입력 받아 크기 N인 파스칼의 삼각형을 출력하는 프로그램을 작성하시오.

// 유의사항 : 배열 초기화 위치
// 개선사항 : 배열을 바꿔치기 하는 하드코딩 부분

import java.util.Scanner;

class Solution2005_2 {
    public static void main(String args[]) throws Exception {

        try (Scanner sc = new Scanner(System.in)) {
            int T;
            T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                int n = sc.nextInt();
                int[][] arr = new int[n][n];

                for (int i = 0; i < n; i++) {
                    arr[i][0] = 1;
                    arr[i][i] = 1;
                }

                for (int j = 2; j < n; j++) {
                    for (int k = 1; k <= j - 1; k++) {
                        arr[j][k] = arr[j - 1][k - 1] + arr[j - 1][k];
                    }
                }

                System.out.println("#" + test_case);
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print(arr[i][j] + " ");
                    }
                    System.out.println();
                }

            }
        }
    }
}
