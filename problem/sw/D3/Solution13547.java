
package D3;

import java.util.Scanner;
// import java.io.*;

class Solution13457 {
    public static void main(String args[]) throws Exception {

        try (Scanner sc = new Scanner(System.in)) {
            int T;
            T = sc.nextInt();

            for (int test_case = 1; test_case <= T; test_case++) {
                String str = sc.next();

                int life = 7;

                for (int i = 0; i < str.length(); i++) {
                    char chr = str.charAt(i);
                    if (chr == 'x')
                        life--;
                }

                String ans = life >= 0 ? "YES" : "NO";

                System.out.print("#" + test_case + " " + ans + "\n");

            }
        }
    }
}