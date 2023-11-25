package D2;
// SWEA 1983. 조교의 성적 매기기

// 학기가 끝나고, 학생들의 점수로 학점을 계산중이다.
// 학점은 상대평가로 주어지는데, 총 10개의 평점이 있다.
// 학점은 학생들이 응시한 중간/기말고사 점수 결과 및 과제 점수가 반영한다.
// 각각 아래 비율로 반영된다.
// 10 개의 평점을 총점이 높은 순서대로 부여하는데,
// 각각의 평점은 같은 비율로 부여할 수 있다.
// 예를 들어, N 명의 학생이 있을 경우 N/10 명의 학생들에게 동일한 평점을 부여할 수 있다.
// 입력으로 각각의 학생들의 중간, 기말, 과제 점수가 주어지고,
// 학점을 알고싶은 K 번째 학생의 번호가 주어졌을 때,
// K 번째 학생의 학점을 출력하는 프로그램을 작성하라.

// [제약사항]
// 1. N은 항상 10의 배수이며, 10이상 100이하의 정수이다. (10 ≤ N ≤ 100)
// 2. K는 1 이상 N 이하의 정수이다. (1 ≤ K ≤ N)
// 3. K 번째 학생의 총점과 다른 학생의 총점이 동일한 경우는 입력으로 주어지지 않는다.

// [입력]
// 입력은 첫 줄에 총 테스트 케이스의 개수 T가 온다.
// 다음 줄부터 각 테스트 케이스가 주어진다.
// 테스트 케이스의 첫 번째 줄은 학생수 N 과, 학점을 알고싶은 학생의 번호 K 가 주어진다.
// 테스트 케이스 두 번째 줄 부터 각각의 학생이 받은 시험 및 과제 점수가 주어진다.

// [출력]
// 테스트 케이스 t에 대한 결과는 “#t”을 찍고, 한 칸 띄고, 정답을 출력한다.
// (t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

// 유의사항!!!! : 등수 정보를 가지고 있는 temp변수는 1부터 시작하고 학점 정보를 순서대로 가지고 있는 배열 인덱스는 0부터 시작하기 떄문에,
//              temp에서 1을 뻬주거나, 등수를 0등부터 시작하는걸로 해야됨.

/* 
// 유의사항 !!! : 배열 오름차순 정리 -> Arrays.sort(arr);

동적리스트 오름차순 정리 -> Collections.sort(arr);
동적리스트 내림차순 정리 -> Collections.sort(arr, Collections.reverseOrder());

배열 내림차순 정리 -> Arrays.sort(arr, Collections.reverseOrder());     (단, integer형 배열에만 가능)
int형 배열 integer로 바꾸기 -> Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
*/

// 유의사항 : 객체 정렬을 쓰지 않아도 되는 문제는 배열 완전 탐색으로 풀자

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution1983 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T;

        T = Integer.parseInt(br.readLine());

        String[] strScore = new String[] { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

        for (int test_case = 1; test_case <= T; test_case++) {
            String str2 = br.readLine();

            StringTokenizer st2 = new StringTokenizer(str2);

            int n = Integer.parseInt(st2.nextToken());
            int k = Integer.parseInt(st2.nextToken());

            int[] arr = new int[n];

            for (int i = 1; i <= n; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str);

                int midScore = Integer.parseInt(st.nextToken());
                int lastScore = Integer.parseInt(st.nextToken());
                int praScore = Integer.parseInt(st.nextToken());

                int sum = (midScore * 35) + (lastScore * 45) + (praScore * 20);
                arr[i - 1] = sum;
            }

            int kScore = arr[k - 1];

            int temp = 0;
            Arrays.sort(arr); // 오름차순 정렬
            for (int i = n - 1; i >= 0; i--) {
                temp++;
                if (arr[i] == kScore) {
                    break;
                }

            }
            // 10 -> 1[0]

            // 20 -> 1, 2[0,1]

            // 30 -> 1 2 3 [0,1,2]

            if (temp <= n / 10)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 2)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 3)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 4)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 5)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 6)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 7)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 8)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else if (temp <= n / 10 * 9)
                bw.write("#" + test_case + " " + strScore[(temp - 1) / (n / 10)] + "\n");
            else
                System.out.println("#" + test_case + " " + strScore[temp / (n / 10)] + "\n");

            // 20명일 때 1~2 3~4 5~6 7~8 9~10
            // 100명일 때 1~10 11~20

        }
        bw.close();
        br.close();

    }
}