import java.io.*;

public class BOJ_11689_오일러함수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        long rslt = getRslt(n);

        bw.write(rslt + "\n");
        bw.close();
        br.close();
    }

    public static long getRslt(long n) {
        double rest = n;
        int sqrtN = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrtN; i++) {
            if (n % i == 0) { //i로 나누어진다면, 합성수
                while (n % i == 0) { //나누어지는 동안 i로 계속 나누어주기, i가 n의 소인수
                    n /= i;
                }
                rest *= (1 - (1 / (double) i)); //n에 곱해진 소인수들 빼주기
            }
        }
        //나누어지는 소인수가 없어서 1까지 나누어지지 않은 경우 소수임
        //n이 소수일 때 1부터 n까지의 소수 개수는 n-1
        if(n != 1)
            rest *= (1 - (1 / (double)n));
        return (long)rest;
    }
}
