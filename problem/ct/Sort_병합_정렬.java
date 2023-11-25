import java.lang.StringBuilder;
import java.util.StringTokenizer;
import java.io.*;

public class Sort_병합_정렬 {
    public static int n;
    public static int[] arr = new int[1000001];

    public static void merge(int low, int mid, int high) {

        int[] s = new int[high - low + 1];

        int sIndex = 0;

        int i = low, j = mid + 1;

        while (i <= mid && j <= high) {

            if (arr[i] < arr[j]) {
                s[sIndex++] = arr[i++];
            } else {
                s[sIndex++] = arr[j++];
            }
        }

        while (i <= mid)
            s[sIndex++] = arr[i++];

        while (j <= high)
            s[sIndex++] = arr[j++];

        for (int k = 0; k < sIndex; k++) {
            arr[low++] = s[k];
        }

    }

    public static void mergeSort(int low, int high) {

        int mid = (high + low) / 2;

        if (high > low) {

            mergeSort(low, mid);
            mergeSort(mid + 1, high);

            merge(low, mid, high);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        st = new StringTokenizer(str);

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.print(sb);

    }
}