import java.util.Scanner;

public class BOJ_11726 {//[BOJ_11726]타일채우기 jaehwan solved - dp사용
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();

        long[] D=new long[n+1];
        D[0]=0;
        D[1]=1;
        D[2]=2;
        for(int i=3;i<n+1;i++){
            D[i]=(D[i-1] + D[i-2]) % 10007;
        }
        System.out.println(D[n]);
    }
}
//예제에서 주어진 9와 55 를 보고 D[2]를 직접 그려보고 피보나치 수열임을 발견했다.
