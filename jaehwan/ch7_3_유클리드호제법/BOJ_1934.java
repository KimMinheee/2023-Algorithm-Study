import java.util.Scanner;

public class BOJ_1934 {//최소 공배수 구하기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            int a= sc.nextInt();
            int b=sc.nextInt();
            int result = a*b/gcd(a,b);
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        if(b==0){
            return a;
        }
        else {
            return gcd(b,a%b);
        }
    }
}
/*
* 최대 공배수를 구하는 간단한 문제로 유클리드 호제법을 사용해보는 문제였다.
* 재귀적인형태로 나머지가 0이 될때까지 배치해 간단히 구현이 가능하다. 
* */
