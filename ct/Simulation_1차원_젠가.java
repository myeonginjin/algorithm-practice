
// 배열의 길이 변수에 잘 저장해놓을 것. 
// 출력 조건을 잘 살펴볼 것.

import java.util.Scanner;

public class Simulation_1차원_젠가 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int[] arr = new int[n];

            int[] nextArr = new int[n];
            int[] lastArr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int s1 = sc.nextInt() - 1;
            int e1 = sc.nextInt() - 1;

            int nextCnt = 0;
            for (int i = 0; i < n; i++) {
                if (i < s1 || i > e1) {
                    nextArr[nextCnt++] = arr[i];
                }
            }

            int s2 = sc.nextInt() - 1;
            int e2 = sc.nextInt() - 1;

            int lastCnt = 0;

            for (int i = 0; i < nextCnt; i++) {
                if (i < s2 || i > e2) {
                    lastArr[lastCnt++] = nextArr[i];
                }
            }

            System.out.println(lastCnt);

            for (int i = 0; i < lastCnt; i++) {
                System.out.println(lastArr[i]);
            }
        }
    }
}