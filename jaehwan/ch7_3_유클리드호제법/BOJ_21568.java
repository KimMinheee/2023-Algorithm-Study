import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_21568 {  //Ax+By = C
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long gcd = gcd(a,b); //최대공약수
        //Ax+By = C 는 c % gcd != 0 일 경우에만 정수해를 가짐 (문제에서 정수해를 요구함)
        if(c % gcd != 0) { System.out.println(-1); } //c가 최대공약수의 배수가 아닐경우 바로 끝냄
        else {  //답이 있는 경우
            int mok = (int) (c / gcd);
            long[] ret = Excute(a, b); //재귀 함수 호출하는 유클리드 호제법 함수 호출
            System.out.println(ret[0]*mok + " " + ret[1]*mok); //결과값에 c/최대 공약수의 값을 곱한 후 해당 값을 출력하기
        }
    }
    private static long[] Excute(long a, long b) { //유클리드 호제법
        long[] ret = new long[2];
        if(b==0) { //나머지 0될때까지
            ret[0] = 1;
            ret[1] = 0;
            return ret;
        }
        long q = a/b;
        long[] v = Excute(b, a%b); //재귀 여기서 계산 걸림 b
        //몫을 계산하는 역산 로직 역순으로 올라오면서 x,y값을 계산
        ret[0] = v[1];          //x = 이전 y
        ret[1] = v[0] - v[1]*q; // y = 이전 x - 이전 y * 몫
        return ret; //재귀에서 빠져나오는 영역에서 실행하면 자연스럽게 역순이 됨
    }
    private static long gcd(long a, long b) {
        //반복문을 사용해서 비재귀적으로 나타냄
        while(b!= 0) {  
            long temp = a % b;
            a=b;
            b=temp;
        }
        /*
        초기값: a = 24, b = 36
        1회 반복: temp = 24 % 36 = 24, a = 36, b = 24
        2회 반복: temp = 36 % 24 = 12, a = 24, b = 12
        3회 반복: temp = 24 % 12 = 0, a = 12, b = 0
        */
        return Math.abs(a); //절대값 반환 
    }
}

/*
문제해설 
Ax+By=C 를 만족하는 (X,Y)쌍을 찾으라는 문제 
확장 유클리드 호제법을 그대로 구현하는 문제로 단순하지만 기본적인 유클리드 호제법에 재귀적인 사용법이 추가되어 있다.
*/
