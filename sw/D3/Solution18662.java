package D3;

// 등차수열의 원리를 이용해야 하는 문제. 등차수열은 무조건 가운데수 *2 = 왼쪽 오른쪽의 합이다.

// 가운데 수를 건들였건, 왼쪽이든 오른쪽이든 어떤걸 건들이는 것과 상관 없이 결과가 가운데수 *2 = 왼쪽 오른쪽의 합 이어야 하므로 
// 현재의 왼+오 값과 가운데 수 *2 한 값의 차이를 절댓값으로 구한다면, 현재 3개짜리 숫자 순열에서 얼마만큼의 변화 폭이 있어야 등차수열이 되는지 알 수 있게된다.

import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.io.*;

class Solution18662 {
    public static void main(String args[]) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String str;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            double z = Double.parseDouble(st.nextToken());

            sb.append("#" + test_case + " " + Math.abs((2 * y - (x + z)) / 2) + "\n");

        }
        System.out.print(sb);
    }
}
