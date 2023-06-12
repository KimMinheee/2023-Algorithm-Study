import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1016_제곱아닌수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] check = new boolean[(int)(max-min+1)]; //제곱수로 나누어지지 않는 수 체크 배열, max-min의 최대크기로 설정

        //제곱수가 max이하일 때까지 -> 제곱수의 제곱근이 max제곱근 이하까지
        int sqrtMax = (int) Math.sqrt(max);
        
        for(long i=2; i<=sqrtMax; i++){ //1보다 큰 제곱수(4, 9, 16,..)로 나누어떨어지지 않는 "제곱이 아닌 수" 찾기

            // min이상부터 카운팅 해줘야 함, 따라서 min안에 제곱수 배수가 몇개가 들어가는지 카운팅 필요
            // min이 제곱수로 나누어진다면  min을 제곱수로 나누어지는 만큼 시작값 뒤로 보내주기
            // min이 제곱수로 나누어지지 않으면  min을 제곱수로 나누고 + 1만큼 시작값 뒤로 보내주기
            long start = min % (i*i) == 0 ? min/(i*i) : min/(i*i) + 1;

            for (long j = start; j * (i * i) <= max; j++) {
                //제곱수의 배수 제외시키기, 실제값 : j * (i * i), 해당 인덱스: j * (i * i) - min
                check[(int) (j * (i * i) - min)] = true;
            }
        }

        int cnt = 0;
        for (boolean val : check) {
            if (!val) {
                cnt++;
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
