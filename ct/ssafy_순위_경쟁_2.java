
// 함수로 프로세스 쪼갤 수 있으면 하드코딩말고 함수로 쪼개서 코드 작성하기
// 리턴 값 활용해서 문제 풀어나가기

import java.util.Scanner;

public class ssafy_순위_경쟁_2 {
    public static int n;
    public static int aScore = 0, bScore = 0;
    public static int[] score = new int[100];
    public static char[] winner = new char[100];
    public static int cnt = 0;

    public static char getWinner(int scoreA, int scoreB) {
        if (scoreA > scoreB)
            return 'A';
        else if (scoreB > scoreA)
            return 'B';

        else
            return 'N';

    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                winner[i] = sc.next().charAt(0);
                score[i] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            if (winner[i] == 'A') {
                if (getWinner(aScore, bScore) != getWinner(aScore + score[i], bScore)) {

                    cnt++;
                }
                aScore += score[i];
            } else {
                if (getWinner(aScore, bScore) != getWinner(aScore, bScore + score[i])) {
                    cnt++;
                }
                bScore += score[i];
            }
        }
        System.out.print(cnt);
    }
}