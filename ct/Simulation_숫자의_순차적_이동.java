
// 시뮬레이션 과정 디버깅 혹은 설계 철저하게 생각해서 구현하기

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

class Loc implements Comparable<Loc> {
    int n, r, c;

    public Loc(int num, int row, int col) {
        this.n = num;
        this.r = row;
        this.c = col;
    }

    public int compareTo(Loc loc) {
        return this.n - loc.n;
    }

}

public class Simulation_숫자의_순차적_이동 {

    public static Scanner sc = new Scanner(System.in);
    public static int n = sc.nextInt();
    public static int m = sc.nextInt();
    public static int[][] arr = new int[n][n];
    public static ArrayList<Loc> locArr = new ArrayList<>();

    public static boolean indexOk(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void move() {

        int[] dr = new int[] { -1, -1, -1, 0, 1, 1, 1, 0 };
        int[] dc = new int[] { -1, 0, 1, 1, 1, 0, -1, -1 };

        for (int i = 0; i < locArr.size(); i++) {
            int curR = locArr.get(i).r;
            int curC = locArr.get(i).c;

            int maxNum = 0;

            int changeR = 0;
            int changeC = 0;

            for (int j = 0; j < 8; j++) {
                int nextR = curR + dr[j];
                int nextC = curC + dc[j];

                if (indexOk(nextR, nextC) && arr[nextR][nextC] > maxNum) {

                    maxNum = arr[nextR][nextC];

                    changeR = nextR;
                    changeC = nextC;

                }
            }
            arr[changeR][changeC] = locArr.get(i).n;
            arr[curR][curC] = maxNum;
            locArr.get(maxNum - 1).r = curR;
            locArr.get(maxNum - 1).c = curC;

            locArr.get(i).r = changeR;
            locArr.get(i).c = changeC;

            // for (int k = 0; k<n; k++){
            // for(int s = 0; s<n; s++){
            // System.out.print(arr[k][s]+" ");
            // }
            // System.out.println();
            // }
            // System.out.println();
            // System.out.println();

        }

    }

    public static void main(String[] args) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = sc.nextInt();
                Loc loc = new Loc(num, i, j);
                locArr.add(loc);
                arr[i][j] = num;
            }
        }
        Collections.sort(locArr);

        // System.out.println(locArr.get(12).n +" "+locArr.get(12).r+"
        // "+locArr.get(12).c);

        while (m-- > 0) {

            move();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}