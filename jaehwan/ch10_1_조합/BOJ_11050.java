import java.util.Scanner;

public class BOJ_11050 {//[BOJ_11050]이항계수1 jaehwan solved - dp 사용
    static int N,K;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        dp=new int[N+1][N+1];
        dpSet();
        System.out.println(dp[N][K]);
    }
    private static void dpSet() {
        for(int i=0; i <= N; i++){
            dp[i][0]=1;//i개에서 1개도 선택하지 않는 경우의 수는 1개
            dp[i][1]=i;//i개에서 1개 선택 경우의 수는 i개
            dp[i][i]=1;//i개에서 모두 선택하는 경우의 수는 i개
        }
        for(int i=2;i<=N;i++){
            for(int j=1;j<i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
    }
}
/*
이항계수란?
조합론에서 사용되는 개념으로, 주어진 크기의 집합에서 특정한 개수의 원소를 선택하는 경우의 수
"n choose k" 또는 C(n, k)로 표기
C(n, k) = n! / (k! * (n - k)!)
C(5, 2) = 5! / (2! * (5 - 2)!) = 5! / (2! * 3!) = (5 * 4) / (2 * 1) = 10
*/
