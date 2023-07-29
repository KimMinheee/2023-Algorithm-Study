import java.util.Scanner;

public class BOJ_13251 {//[BOJ_13251]조약돌꺼내기 jaehwan solved - 확률 사용
    static int N=0; //총 개수
    static double answer=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int M=sc.nextInt();
        int[] arr = new int[M];
        for(int i = 0; i < M; i++){
            arr[i] = sc.nextInt();
            N += arr[i];
        }
        int K= sc.nextInt();

        for(int i = 0; i < M; i++){
            if(arr[i] < K) //같은 색의 조약돌 수가 K개보다 적으면 계산 x
                continue;

            double tmp = 1.0; //모두 뽑을 확률 처음 1.0 = 100%

            for(int j = 0; j < K; j++){
                //i색깔을 모두 뽑을 확률 * 현재 색깔 개수 -k / 전체 색깔 개수 - k
                tmp *= (double)(arr[i] - j) / (N - j);
            }
            answer += tmp;
        }

        System.out.println(answer);


    }
}// 확률 문제라 확률로 풀었음
