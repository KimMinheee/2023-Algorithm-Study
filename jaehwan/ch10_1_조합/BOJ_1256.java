import java.util.Scanner;

public class BOJ_1256 { //[BOJ_1256]사전 jaehwan solved - dp 사용
    final static int MAX=1000000001;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int M=sc.nextInt();
        int K=sc.nextInt();

        int max =N+M;
        int max1=1;
        for(int i=1;i<=max;i++){
            max1 *=i;
        }
        int max2= 1;
        for(int i=1;i<=(max-K);i++){
            max2 *=i;
        }
        int max3= 1;
        for(int i=1;i<=K;i++){
            max3 *=i;
        }
        int T = max1 / (max2*max3);
        //T = 순열의 경우의 수

        int[][] D=new int[202][202];
        //전체 개수 중에서 뽑아야하는 경우의 수를 계산 = N+M의 최대 값 200 + 각자리수 +1 =202
        for(int i=0;i<=200;i++){
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) D[i][j]=1; //처음 1 세팅 & 중앙선 1세팅
                else {
                    D[i][j]=D[i-1][j-1]+D[i-1][j];
                    if(D[i][j]>1000000000) D[i][j] = MAX;
                }
            }
        }
        if(D[max][M] < K){
            System.out.println("-1");
        }
        else{
            while(!(N==0 && M==0)){
                if(D[N-1+M][M]>=K){
                    System.out.print("a");
                    N--;
                }else {
                    System.out.print("z");
                    K=K-D[N-1+M][M];
                    M--;
                }
            }
        }

    }
}
/*
k=1 => aazz 2=> azaz 3 => azza 4=> zaaz zaza zzaa
순열식
d(4,2) (4*3*2*1 ) / 2*1*(2) =24 / 4 = 6가지
*/
