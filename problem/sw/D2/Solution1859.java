package D2;

// SWEA D2 1859.

// 25년 간의 수행 끝에 원재는 미래를 보는 능력을 갖게 되었다. 이 능력으로 원재는 사재기를 하려고 한다.

// 다만 당국의 감시가 심해 한 번에 많은 양을 사재기 할 수 없다.

// 다음과 같은 조건 하에서 사재기를 하여 최대한의 이득을 얻도록 도와주자.

//     1. 원재는 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있다.
//     2. 당국의 감시망에 걸리지 않기 위해 하루에 최대 1만큼 구입할 수 있다.
//     3. 판매는 얼마든지 할 수 있다.

// 예를 들어 3일 동안의 매매가가 1, 2, 3 이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익을 얻을 수 있다.

// 함정 1. 배열 완전 탐색으로 for문 2개 돌리면 시간초과로 테스트케이스 7/10 통과.
// 함정 2. 최대 이익 값은 최대 100억이 될 수 있기 떄문에 (N최댓값 1,000,000 * 매매가 차이값 최대 9,999) int타입(범위 약 21억)으로 값 지정시 메모리 초과.

// 솔루션 1. 배열의 뒤에서 부터 탐색을 시작한다. 후일이 판매일이고 앞선 날이 구매일이기 때문. 하지만 차이값을 구하기 전 더 비싸게 팔 수 있는 날을 찾으면 그 날을 기준으로 다시 잡고 탐색을 이어간다. 이런 경우 이 날에 얻는 수익은 없다. 
// 솔루션 2. 해당 날의 총 최대이익값을 저장하는 변수를 long타입으로 선언.

import java.io.*;

import java.util.StringTokenizer;

class Solution1859 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T;
        T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            long score = 0;
            StringTokenizer str = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str.nextToken());
            }
            int maxPrice = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (arr[j] > maxPrice)
                    maxPrice = arr[j];
                score += maxPrice - arr[j];
            }

            bw.write("#" + test_case + " " + score + "\n");
            bw.flush();
        }
        br.close();

    }
}