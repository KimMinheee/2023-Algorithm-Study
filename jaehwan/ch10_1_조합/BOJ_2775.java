import javax.xml.crypto.dsig.keyinfo.KeyName;
import java.util.Scanner;

public class BOJ_2775 {//[BOJ_2775]부녀회장 jaehwan solved - dp 사용
    static int N,K;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        dp=new int[10][15];
        dpSet();
        int q= sc.nextInt();
        for(int i=0;i<q;i++){
            K=sc.nextInt();
            N=sc.nextInt();
            System.out.println(dp[K][N]);
        }
    }
    private static void dpSet() {
        for(int i=0; i < 10; i++){
            dp[i][1]=1;//i층의 1호는 항상 1의 값
        }
        for(int i=0; i < 15; i++){
            dp[0][i]=i;//주어진 초기화 0층
        }
        for(int i=1;i<10;i++){
            for(int j=2;j<15;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
    }
}
/*
k가 몇인지 케이스가 없음

0층이 있음 0,1,2,3,4 총 최대 5층 14호
밑에서 위로 올라와야하는 구조
자기 왼쪽칸 + 자기 아래칸이 점화식
D[a][b]=D[a][b-1]+D[a-1][b]
*/
