
// 최대값 요구하는지 최소값 요구하는지 잘 확인하기.
// 00함에 주의하라 했을 경우 그 상황이 답에 포합될 수 있는 조건인지, 예외처리 하여 그 상황은 답에 영향을 끼칠 수 없는 것인지 잘 판단하라. 
// 예를들어 이 문제는 사각형의 넓이의 최솟값을 구하는 문제이고, 사각형이 그려지지않아 넓이가 0이 되는경우도 0의 넓이를 가진 사각형으로 답안에 일부가 될 수 있음을 깨달아야함

import java.util.Scanner;

public class ssafy_물체_하나를_정하여_완전탐색 {
    public static int n;
    public static int[] x = new int[100];
    public static int[] y = new int[100];
    public static int ans = Integer.MAX_VALUE;

    public static void simul() {
        for (int i = 0; i < n; i++) {

            int maxX = 0;
            int minX = 400001;

            int maxY = 0;
            int minY = 400001;

            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;
                maxX = Math.max(maxX, x[j]);
                minX = Math.min(minX, x[j]);
                maxY = Math.max(maxY, y[j]);
                minY = Math.min(minY, y[j]);
            }

            ans = Math.min(ans, (maxX - minX) * (maxY - minY));

        }

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
        }
        simul();
        System.out.print(ans);

    }
}