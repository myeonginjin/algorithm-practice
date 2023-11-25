
// 좌표 평면의에 사각형을 그려서 넓이를 구하는 문제의 경우, 그래프를 오른쪽으로 90도 회전시킨 2차원 배열로 생각하여 문제 접근
// 그렇게 될 경우, x축은 행이되고 y축은 열이 된다. 
// 또한, 사각형의 넓이는 사각형에 해당하는 구간의 배열값들을 1로 채워줌으로써 구하는데, 주의해야할 점은
// 겹치는 구간을 구할때처럼 x의 끝지점과 y지점의 끝지점 -1을 하여 범위를 성정한 뒤, 1씩 채워줘야한다.
// 예를들어, x1, x2, y1 , y2 좌표값을 받았을 때(단, x1 < x2 y1 < y2) 배열로 눞혓을 때 사격형의 높이에 해당하는 
// x구간 길이는 x1~x2-1이고, 이 구간만 1씩 채워준다. 동일하게 사각형의 넓이에 해당하는 y구간 길이는 y1 ~ y2-1
// 그 후, 배열을 완전탐색하며, sum이라는 변수에 배열에 모든 값을 더해준다면, 1로 채워진 사각형의 범위가 넓이를 만들어준다. 
// 좌표 음수값도 있을 시에, 오프셋 이용하는 것 동일

import java.util.Scanner;

public class ssafy_겹치지_않는_사각형의_넓이 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[][] arr = new int[2001][2001];

            int ax = sc.nextInt() + 1000;
            int ay = sc.nextInt() + 1000;
            int bx = sc.nextInt() + 1000;
            int by = sc.nextInt() + 1000;

            int cx = sc.nextInt() + 1000;
            int cy = sc.nextInt() + 1000;
            int dx = sc.nextInt() + 1000;
            int dy = sc.nextInt() + 1000;

            for (int i = ax; i < bx; i++) {
                for (int j = ay; j < by; j++) {
                    arr[i][j] = 1;
                }
            }

            for (int i = cx; i < dx; i++) {
                for (int j = cy; j < dy; j++) {
                    arr[i][j] = 1;
                }
            }
            int x1 = sc.nextInt() + 1000;
            int y1 = sc.nextInt() + 1000;
            int x2 = sc.nextInt() + 1000;
            int y2 = sc.nextInt() + 1000;

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    arr[i][j] = 0;
                }
            }

            int sum = 0;

            for (int i = 0; i < 2001; i++) {
                for (int j = 0; j < 2001; j++) {
                    sum += arr[i][j];
                }
            }
            System.out.print(sum);
        }

    }
}