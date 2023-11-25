
// 시간 경과에 따른 위치 변화를 확인하는 문제는, 시간에 변화에 따른 (1초 혹은 1분 등) 현재 위치를 배열의 원소로 가지는 배열을 선언해주면된다.
// 기준 시간 경과값은 인덱스의 증가값이 되며, (예로 1초 지남이 기준이라면 인덱스 1이 증가할때 마다 1초 뒤 위치를 나타낸다) 배열의 크기는 총 경과시간이 된다.
// 배열 탐색을 통해 각 초 혹은 분마다 어느 위치에 있어는지 알 수 있게된다 
// 입력값이 크더라도 중복 반복문으로 짤거아니라면 겁먹지 말고 자료구조 쵀대한 활용하기 (굳이 시간 복잡도 낮출 생각 x)
// 그 전 배열 원소 값에 특정 수 더한 뒤 다음 배열 원소 인덱스 위치에 넣어주는거 한줄로 줄여 작성하면 안되고 , 
// 값 넣어 준뒤 인덱스로 사용하는 int타입 변수 ++; 해야됨 

import java.util.Scanner;

public class ssafy_만나는_그_순간 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            int[] A = new int[1000001];
            int[] B = new int[1000001];

            int indexA = 1;
            int indexB = 1;

            int timeA = 0;
            // int timeB = 0;

            for (int i = 1; i <= n; i++) {

                char type = sc.next().charAt(0);
                int num = sc.nextInt();

                timeA += num;

                if (type == 'R') {
                    for (int j = 0; j < num; j++) {
                        A[indexA] = A[indexA - 1] + 1;
                        indexA++;
                    }
                } else {

                    for (int j = 0; j < num; j++) {
                        A[indexA] = A[indexA - 1] - 1;

                        indexA++;
                    }
                }
            }

            for (int i = 1; i <= m; i++) {

                char type = sc.next().charAt(0);
                int num = sc.nextInt();

                // timeB += num;

                if (type == 'R') {
                    for (int j = 0; j < num; j++) {
                        B[indexB] = B[indexB - 1] + 1;
                        indexB++;
                    }
                } else {

                    for (int j = 0; j < num; j++) {
                        B[indexB] = B[indexB - 1] - 1;
                        indexB++;
                    }
                }
            }

            int ans = -1;

            for (int i = 1; i <= timeA; i++) {
                if (A[i] == B[i]) {
                    ans = i;
                    break;
                }

            }

            // for (int i = 1; i<100; i++){
            // System.out.println(A[i]+" "+B[i]);
            // }
            System.out.print(ans);
        }

    }
}