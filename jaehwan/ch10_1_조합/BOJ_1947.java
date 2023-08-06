import java.util.Scanner;

public class BOJ_1947 {//[BOJ_1947]선물전달 jaehwan solved - dp 사용
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] D=new int[N+1];
        D[1]=0; //자기 자신에게 선물 불가
        D[2]=1; //서로 교환
        D[3]=2; // A=>B B=>C C=>A // B=>A A=>C C=>B 정방향 역방향 두개 존재
        //피보나치 수열에 N-1 곱
        for(int i=4;i<=N;i++){
            D[i]=(i-1)*(D[i-1] + D[i-2]);
        }
        System.out.println(D[N]);
    }
}
