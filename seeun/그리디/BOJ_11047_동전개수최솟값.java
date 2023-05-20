import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11047_동전개수최솟값 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] money = new int[n];

        for (int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        //큰 돈부터 시작해서 나눔
        int cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k / money[i] >= 1) { //동전 한개라도 사용할 수 있다면 나눈다.
                cnt += k / money[i]; //나눈 동전 개수
                k %= money[i]; //나눈 결과로 금액 업데이트
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
