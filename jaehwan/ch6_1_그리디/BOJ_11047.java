import java.util.Scanner;

public class BOJ_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int k=sc.nextInt();
        int[] A= new int[n];
        for(int i=0;i<n;i++){
            A[i]=sc.nextInt();
        }
        int count=0;
        for(int i=n-1;i>=0;i--){//e뒤에서부터 탐색
            if(A[i]<=k){//현재 동전보다 작은지 검사
                count+=(k/A[i]);//나눠진 몫을 더해줌
                k=k%A[i];//현재 돈은 나눈 값으로 업데이트 해준다
            }
        }
        System.out.println(count);
    }
}
//그리디 알고리즘을 사용하는 대표적인 동전문제 
/*
뒤에 오는 동전이 앞에오는 동전의 배수라는 조건으로 그리디 알고리즘의 조건을 알려준다.
뒤에서 부터 계산하면 내림차순이 보장되고 남은 금액이 순차적으로 생기기 때문이다.
*/
