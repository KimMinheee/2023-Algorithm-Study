import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class BOJ_1850 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
        long a= sc.nextLong();
        long b= sc.nextLong();
        long result=gcd(a,b);
        for(int i=0;i<result;i++){
            bw.write("1");
        }
        bw.flush();
        bw.close();
    }

    private static long gcd(long a, long b) {
        if(b==0){ //나누어 떨어질때까지
            return a;
        }
        return gcd(b,a%b);
    }
}

/*
문제 해설 
최대 공약수를 구하고 그 수만큼 1을 이어서 출력하라

문제풀이 
gcd를 이용해서 최대 공략수를 구하고 출력하는 단순한 문제 하지만 출력하려는 자리수가 많아 long형이 필요하다
*/
