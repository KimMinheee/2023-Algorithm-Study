package week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253_좋은수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //수의 개수
        int[] arr = new int[N]; //수 배열

        //수의 개수가 3개미만일 경우 좋은 수 없음
        if (N < 3) {
            bw.write("0");
            bw.flush();
            bw.close();
            return;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        //배열 정렬
        Arrays.sort(arr);

        int testPtr = 0; //테스트 수의 인덱스
        int ptr1; //포인터1
        int ptr2; //포인터2
        int cnt = 0; //좋은수 카운트

        //N개 요소 하나씩 테스트
        while (testPtr < N) {

            if(testPtr == 0) //테스트 수가 첫번째 요소일 때
                ptr1 = 1;
            else
                ptr1 = 0;

            if (testPtr == N - 1) //테스트 수가 마지막 요소일 때
                ptr2 = N - 2;
            else
                ptr2 = N - 1;

            //좋은 수인지 탐색
            while (ptr1 < ptr2) {
                System.out.println("testPtr = " + testPtr);
                System.out.println("ptr1 = " + ptr1);
                System.out.println("ptr2 = " + ptr2);
                System.out.println("cnt = " + cnt);

                //좋은 수 조건을 가질 수 있는지 확인
                int sum = arr[ptr1] + arr[ptr2]; //두수 합
                int val = arr[testPtr]; //테스트 수

                //좋은 수!
                if (sum == val) {
                    System.out.println("좋은 수를 찾았다");
                    cnt++;
                    break;
                }

                //합이 테스트 수보다 작을 경우
                else if (sum < val) {
                    System.out.println("테스트 수보다 작다");
                    ptr1++;
                    if (ptr1 == testPtr) ptr1++;
                }
                //합이 테스트 수보다 클 경우
                else {
                    System.out.println("테스트 수보다 크다");
                    ptr2--;
                    if (ptr2 == testPtr) ptr2--;
                }
            }
            testPtr++;
            System.out.println("한 턴 끝!");
            System.out.println();

        }
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
