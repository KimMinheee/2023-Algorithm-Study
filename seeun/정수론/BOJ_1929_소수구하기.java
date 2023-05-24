import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1929_소수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        
        if (m == 1){
            if(n == 1){ //m과 n이 모두 1인 경우 0출력
                bw.write("0");
                bw.flush();
                br.close();
                bw.close();
                return;
            }
            else{ //m만 1인 경우 1 제외 시키기
                m = 2;
            }
        }

        // m이상 n이하까지 소수라면 sb에 담기
        for (int i = m; i <= n; i++) {
            if(isPrime(i))
                sb.append(i + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    //소수인지 판별하는 함수, 제곱근까지 나누어지는 수 있으면 소수아님
    static public boolean isPrime(int num) {
        int sqrtNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtNum; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
