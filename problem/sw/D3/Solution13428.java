
// 배열 지정값 확인 유의
// 초기화 위치 유의
// Sting str = new String(arr); 혹은 String str = String.valueOf(arr); 로 char배열 문자열로 변환

package D3;

import java.lang.StringBuilder;
import java.io.*;

class Solution13428 {
    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {

            String num = br.readLine();

            int minNum = Integer.parseInt(num);
            int maxNum = Integer.parseInt(num);

            for (int i = 0; i < num.length() - 1; i++) {
                for (int j = i + 1; j < num.length(); j++) {

                    char[] arr = num.toCharArray();

                    char temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;

                    if (arr[0] == '0')
                        continue;

                    String newNum = new String(arr);

                    if (Integer.parseInt(newNum) > maxNum)
                        maxNum = Integer.parseInt(newNum);
                    if (Integer.parseInt(newNum) < minNum)
                        minNum = Integer.parseInt(newNum);

                }
            }

            sb.append("#" + test_case + " " + minNum + " " + maxNum + "\n");

        }
        System.out.print(sb);
    }
}
