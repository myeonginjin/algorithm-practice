import java.util.Scanner;
import java.util.Arrays;

class Elem implements Comparable<Elem> {
    int v;
    int i;

    public Elem(int value, int index) {
        this.v = value;
        this.i = index;
    }

    public int compareTo(Elem elem) {
        return this.v - elem.v;
    }
}

public class Sort_빠른_정렬 {
    public static int n;
    public static int[] arr = new int[100001];

    public static void makeP(int l, int h) {

        Elem low = new Elem(arr[l], l);
        Elem mid = new Elem(arr[(l + h) / 2], (l + h) / 2);
        Elem high = new Elem(arr[h], h);

        Elem[] numArr = new Elem[] { low, mid, high };
        Arrays.sort(numArr);

        int pIndex = numArr[1].i;

        int temp = arr[h];

        arr[pIndex] = temp;
        arr[h] = numArr[1].v;

    }

    public static void quickSort(int l, int h) {

        if (l < h) {

            makeP(l, h);

            int p = partition(l, h);

            quickSort(l, p - 1);
            quickSort(p + 1, h);
        }
    }

    public static int partition(int l, int h) {

        int pIndex = l - 1;

        for (int i = l; i < h; i++) {
            if (arr[i] < arr[h]) {
                pIndex++;

                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;
            }

        }

        int temp = arr[pIndex + 1];
        arr[pIndex + 1] = arr[h];
        arr[h] = temp;

        return pIndex + 1;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
        }
        quickSort(0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}