import java.util.Scanner;

public class BOJ_2193 {//[BOJ_2193]이친수 jaehwan solved - dp 사용
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();

        long[] D = new long[N+1];

        D[0]=0; //없는셈
        D[1]=1;
        /* 
        i=1 -> 1 -> 1개
        i=2 -> 10 -> 1개
        i=3 -> 100, 101 -> 2개
        i=4 -> 1000, 1001, 1010 -> 3개
        i=5 -> 10000, 10001, 10101, 10100, 10010 -> 5개
        */

        for(int i=2; i <= N;i++){ //피보나치 수열 규칙과 동일한 개수를 보인다
            D[i] = D[i-1] + D[i-2];
        }
        System.out.println(D[N]);
    }
}
/*
문제 예제 틀림
100000
100001
100010
100100
100101
101010
101000
101001 총 8개
*/
