import java.util.Scanner;

public class BOJ_1463 {//[BOJ_1463]1로만들기 jaehwan solved - dp사용
    static int N;
    static int[] D;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        D=new int[N+1];
        D[0]=0;
        D[1]=0;
        for(int i=2;i<=N;i++){
            D[i]=D[i-1]+1;
            if(i%2==0){D[i]=Math.min(D[i], D[i/2]+1);}
            if(i%3==0){D[i]=Math.min(D[i], D[i/3]+1);}
        }
        System.out.println(D[N]);
    }
}
