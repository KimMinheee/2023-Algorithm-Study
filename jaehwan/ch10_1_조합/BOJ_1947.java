import java.util.Scanner;

public class BOJ_1947 {//[BOJ_1947]선물전달 jaehwan solved - dp 사용
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        int[] D=new int[N+1];
        D[1]=0; //자기 자신에게 선물 불가
        D[2]=1; //서로 교환
        D[3]=2; 
        /*
        각 사람이 선물을 주는 대상을 선택할 때, 첫 번째 사람은 2명의 대상 중 한 명을 선택할 수 있습니다.
        두 번째 사람은 남은 2명 중 한 명을 선택할 수 있으며,
        마지막으로 세 번째 사람은 남은 1명에게 선물을 줄 수 있습니다.
        */
        //피보나치 수열에 N-1 곱
        for(int i=4;i<=N;i++){
            D[i]=(i-1)*(D[i-1] + D[i-2]);
        }
        System.out.println(D[N]);
    }
}
