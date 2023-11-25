
// 우선순위 큐 구현은 import java.util.Queue 와 import java.util.LinkedList; 
// Queue<객체타입> q = new LinkedList<>(); 꼭 명심하기 

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Push {
    int r, c;

    public Push(int row, int col) {
        this.r = row;
        this.c = col;

    }
}

public class ssaffy_가능한_상황을_나열하기 {
    public static char[][] arr = new char[10][10];
    public static Queue<Push> q = new LinkedList<>();
    public static int[][] dp = new int[10][10];
    public static int strI = -1;
    public static int strJ = -1;
    public static int lasI = -1;
    public static int lasJ = -1;

    public static boolean indexOk(int r, int c) {
        return r >= 0 && r < 10 && c >= 0 && c < 10;
    }

    public static void bfs() {
        int[] dr = new int[] { -1, 1, 0, 0 };
        int[] dc = new int[] { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            Push p = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextR = p.r + dr[i];
                int nextC = p.c + dc[i];

                if (indexOk(nextR, nextC) && arr[nextR][nextC] != 'R' && dp[nextR][nextC] == 0) {

                    dp[nextR][nextC] = dp[p.r][p.c] + 1;
                    Push p2 = new Push(nextR, nextC);
                    q.add(p2);
                }
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            for (int i = 0; i < 10; i++) {
                String str = sc.next();
                for (int j = 0; j < 10; j++) {
                    arr[i][j] = str.charAt(j);
                    if (arr[i][j] == 'B' || arr[i][j] == 'L') {
                        if (strI != -1) {
                            lasI = i;
                            lasJ = j;
                        } else {
                            strI = i;
                            strJ = j;
                        }
                    }
                }
            }
        }
        Push p = new Push(strI, strJ);

        q.add(p);
        bfs();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print(dp[lasI][lasJ] - 1);

    }
}
