package D3;

// 예외 상황을 확실히 체크할 것. a부터 시작해서 얼마나 알파벳 순서를 따르는지 검사하는 것임으로 알파벳 순서에 어긋나는 순간 탐색을 종료해야한다.

// import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution15230 {
    public static void main(String args[]) throws Exception {

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        // StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            String abc = "abcdefghijklmnopqrstuvwxyz";
            char[] arr = abc.toCharArray();

            String inputStr = br.readLine();

            int cnt = 0;

            for (int i = 0; i < inputStr.length(); i++) {
                if (arr[i] == inputStr.charAt(i)) {
                    cnt++;
                } else {
                    break;
                }
            }

            sb.append("#" + test_case + " " + cnt + "\n");

        }
        System.out.print(sb);
    }
}
