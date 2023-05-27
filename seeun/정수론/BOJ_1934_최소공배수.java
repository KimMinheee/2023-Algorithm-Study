import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1934_최소공배수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int max = Math.max(a, b);
            int min = Math.min(a, b);

            int mul = max* min;

            //나머지가 0이 아닌동안 작은수를 큰수로, 나머지를 작은수로 업데이트
            while (max % min != 0) {
                int currMax = max;
                int currMin = min;
                max = currMin;
                min = currMax % currMin;
            }
            //최소공배수는 처음 max * min을 최대공약수로 나누어준 수
            int lcm = mul / min;

            bw.write(lcm + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }
}
