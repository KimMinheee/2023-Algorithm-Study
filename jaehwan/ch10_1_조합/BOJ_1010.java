import java.util.Scanner;

public class BOJ_1010 {//[BOJ_1010]다리놓기 jaehwan solved - dp 사용
    static int T,N,M;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();
        dp=new int[31][31]; //반복해서 물어보므로 한번에 구해놓는다
        dpSet();
        for(int i=0;i<T;i++) {
            N=sc.nextInt();
            M=sc.nextInt();
            System.out.println(dp[M][N]);
        }
    }
    private static void dpSet() {
        for(int i=0; i <= 30; i++){
            dp[i][0]=1;//i개에서 1개도 선택하지 않는 경우의 수는 1개
            dp[i][1]=i;//i개에서 1개 선택 경우의 수는 i개
            dp[i][i]=1;//i개에서 모두 선택하는 경우의 수는 i개
        }
        for(int i=2;i<=30;i++){
            for(int j=1;j<i;j++){
                dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
            }
        }
    }
}
/*
한번에 하나씩만 연결이 가능하다는걸 보고 M개에서 N개를 뽑는걸 알아내야 하는 문제이다.
*/
