import java.io.*;
import java.util.*;
public class BOJ_1456_거의소수{

    private static int cnt = 0;
    private static double a;
    private static double b;
    private static int M = 10000000; //최대 10^14의 제곱근까지만 범위로
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Double.parseDouble(st.nextToken());
        b = Double.parseDouble(st.nextToken());
        boolean[] check = new boolean[M+1];

        //소수 리스트 생성, b의 제곱근까지만 체크
        int bSqrt = (int)Math.sqrt(b);
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2; i<=bSqrt; i++){
            if(!check[i]){
                arr.add(i); //소수만 넣기
                for(int j=i; j<=M; j+=i) //배수들 모두 소수불가 하므로 true처리
                    check[j] = true;
            }
        }
        checkAlmostPrime(arr); //거의 소수 판별

        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    //소수 리스트를 가지고 a부터 b범위의 거의소수를 카운트하는 메서드
    public static void checkAlmostPrime(ArrayList<Integer> arr){

        int len = arr.size();
        double powPrime; //소수의 n제곱, 거의소수 후보 변수
        for (int i=0; i<len; i++) {
            double val = (double)arr.get(i);
            powPrime = val * val; //소수 제곱
            if(powPrime>b) break; //제곱한번 했을 때 범위를 넘어선다면 종료
            for(;powPrime <= b; powPrime *= val){ //b범위 내의 소수의 n제곱들
                if(powPrime>=a) { //a범위도 고려했을 때 벗어나지 않는다면
                    cnt++; //거의소수 개수 증가
                }
            }
        }
    }
}