package D3;

// abcdabcde abcd와 같은 경우 고려해야됨.

// 부분문자열의 길이만큼 탐색을 할 길이가 남았는지 확인하는 out of index검사 함수를 따로 파서, 부분문자열의 길이만큼 비교할 길이가 안남았으면 false
// if 문 앞에 아웃오브 인덱스 검사 함수를 먼저 적어서 아웃 오브 인덱스 에러가 나는 것을 방지

import java.util.StringTokenizer;
import java.io.*;
import java.lang.StringBuilder;

class Solution15758 {

    public static boolean indexOk(int num, int len) {
        return num < len;
    }

    public static boolean check(String parseStr, String str, int index) {

        // System.out.println(parseStr+" " +str+" " + index);

        for (int i = 0; i < parseStr.length(); i++) {

            if (!indexOk(i + index, str.length()) || str.charAt(i + index) != parseStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            String st1 = st.nextToken();
            String st2 = st.nextToken();

            if (st1.equals(st2)) {
                sb.append("#" + test_case + " " + "yes" + "\n");
                continue;
            }

            String st1Par = "";
            String st2Par = "";

            st1Par += st1.charAt(0);
            st2Par += st2.charAt(0);

            for (int i = 1; i < st1.length(); i++) {
                if (st1Par.charAt(0) == st1.charAt(i)) {
                    if (check(st1Par, st1, i)) {
                        i += st1Par.length() - 1;
                    } else {
                        st1Par += st1.charAt(i);
                    }

                }

                else {
                    st1Par += st1.charAt(i);
                }
            }

            for (int i = 1; i < st2.length(); i++) {
                if (st2Par.charAt(0) == st2.charAt(i)) {
                    if (check(st2Par, st2, i)) {
                        i += st2Par.length() - 1;
                    } else {
                        st2Par += st2.charAt(i);
                    }

                }

                else {
                    st2Par += st2.charAt(i);
                }
            }

            if (st1Par.equals(st2Par))
                sb.append("#" + test_case + " " + "yes" + "\n");
            else
                sb.append("#" + test_case + " " + "no" + "\n");

        }
        System.out.print(sb);
    }
}