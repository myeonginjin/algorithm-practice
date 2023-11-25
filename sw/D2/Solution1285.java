package D2;

// SWEA 1285. 아름이의 돌 던지기

// 아름이를 포함하여 총 N명의 사람이 돌 던지기 게임을 하고 있다.
// 이 돌 던지기 게임은 앞으로 돌을 던져 원하는 지점에 최대한 가깝게 돌을 던지는 게임이다.
// 정확하게 말하면 밀리미터 단위로 -100,000에서 100,000까지의 숫자가 일렬로 써져 있을 때, 사람들은 숫자 100,000이 써져 있는 위치에 서서 최대한 0에 가까운 위치로 돌을 던지려고 한다.
// N명의 사람들이 던진 돌이 떨어진 위치를 측정한 자료가 주어질 때, 가장 0에 가깝게 돌이 떨어진 위치와 0 사이의 거리 차이와 몇 명이 그렇게 돌을 던졌는지를 구하는 프로그램을 작성하라.

// 유의사항 : 오차범위를 구하기 때문에 Math.abs(num)를 사용하여 절댓값을 구한다.
import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;
import java.util.Arrays;

class Solution {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            str = br.readLine();
            st = new StringTokenizer(str);

            int scores[] = new int[n];

            for (int i = 0; i < n; i++) {
                int score = Math.abs(Integer.parseInt(st.nextToken()));
                scores[i] = score;
            }

            Arrays.sort(scores);

            int winner = scores[0];
            int cnt = 1;
            for (int i = 1; i < scores.length; i++) {
                if (winner == scores[i])
                    cnt++;
            }

            sb.append("#" + test_case + " " + winner + " " + cnt + "\n");

        }
        System.out.print(sb);
    }
}