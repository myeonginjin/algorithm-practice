package D2;

// SWEA 1928. Base64 Decoder

// 다음과 같이 Encoding 을 한다.

// 1. 우선 24비트 버퍼에 위쪽(MSB)부터 한 byte씩 3 byte의 문자를 집어넣는다.

// 2. 버퍼의 위쪽부터 6비트씩 잘라 그 값을 읽고, 각각의 값을 아래 [표-1] 의 문자로 Encoding 한다.

// 유의사항 : 직접 decoder, encoder를 구현하지 않고 java패키지를 활용할 수 있다.
/*
impoer java.util.Base64;

base64 인코딩: 8비트×3글자 → 6비트×4글자로 변환
base64 디코딩: 6비트×4글자 → 8비트×3글자로 변환

String decodeStr = new String(Base.getDecoder().decode(encodeStr));
 */

import java.util.Base64;
import java.io.*;
import java.lang.StringBuilder;

class Solution1928 {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            String encodeStr = br.readLine();
            String DecodeStr = new String(Base64.getDecoder().decode(encodeStr));

            sb.append("#" + test_case + " " + DecodeStr + "\n");

        }
        System.out.print(sb);

    }

}