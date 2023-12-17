

import java.util.StringTokenizer;
// import java.util.Arrays;
import java.io.*;
import java.lang.StringBuilder;




class Stu implements Comparable<Stu>{
    String name;
    int s1,s2,s3;

    public Stu(){
        this.name ="";
        this.s1 = 0;
        this.s2 = 0;
        this.s3 = 0;
    }

    public Stu(String name, int s1, int s2, int s3){
        this.name = name;
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
    }
    public int compareTo(Stu s){
        return (this.s1+this.s2+this.s3) - (s.s1+s.s2+s.s3);
    }
}



class Test {
    public static int cnt, n;
    public static int[] arr = new int[1000];
    public static int maxNum = 0;

    public static void dfs(int swap) {

        if (swap == cnt) {

            String numStr = "";

            for (int i = 0; i < n; i++) {
                numStr += arr[i];

            }

            maxNum = Math.max(maxNum, Integer.parseInt(numStr));
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = arr[i];

                arr[i] = arr[j];
                arr[j] = temp;

                dfs(swap + 1);

                int temp2 = arr[j];
                arr[j] = arr[i];
                arr[i] = temp2;
            }
        }
    }

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        String str;
        StringTokenizer st;

        for (int test_case = 1; test_case <= T; test_case++) {
            str = br.readLine();
            st = new StringTokenizer(str);
            String nums = st.nextToken();
            cnt = Integer.parseInt(st.nextToken());
            n = nums.length();

            if (n < cnt)
                cnt = n;

            for (int i = 0; i < nums.length(); i++) {
                arr[i] = Integer.parseInt(nums.substring(i, i + 1));

            }

            maxNum = 0;
            dfs(0);

            sb.append("#" + test_case + " " + maxNum + "\n");

        }
        System.out.print(sb);
    }
}
