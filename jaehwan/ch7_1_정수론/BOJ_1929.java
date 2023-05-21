import java.util.Scanner;

public class BOJ_1929 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int start = sc.nextInt();
        int end =sc.nextInt();

        for(int i=start; i<=end;i++){
            int num=Prime(i);
            if(num > 0 ){
                System.out.println(i);
            }
        }
    }
    public static int Prime(int a) {
        int point = 0;
        if(a < 2) { return point; }
        if(a == 2) {point=1; return point; } //이 부분 빼면 틀린다.
        if(a % 2 == 0) { return point; }
        for(int i = 2; i <= Math.sqrt(a); i++) {
            if(a % i == 0) { return point; }
        }
        point = 1;
        return point;
    }
}

/*
문제풀이 
입력 받은 숫자 사이에 있는 소수를 판별해서 보여주면 되는 문제 제곱근까지만 계산하게 하고 2로 나뉘는건 건너뛰어 시간복잡도를 줄였다.


특이사항: 2를 별도로 처리해줘야 하는데 생각을 못해서 시간이 좀 걸렸다.*/
