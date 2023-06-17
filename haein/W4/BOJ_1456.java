import java.io.*;
import java.util.*;
// 1456. 거의 소수 구하기
public class Main {
    static final int MAX = (int)1e7;
    static boolean[] prime = new boolean[MAX+1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int i = 2; i*i <= MAX; i++) {
            if (prime[i]) {
                for (int j = i*i; j <= MAX; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= MAX; i++) {
            if (prime[i]) {
                long num = (long) i * i;
                while (num <= B) {
                    if (num >= A) {
                        count++;
                    }
                    if (B / num < i) {
                        break;
                    }
                    num *= i;
                }
            }
        }
        System.out.println(count);
    }
}
