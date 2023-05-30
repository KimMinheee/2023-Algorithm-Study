import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1850_최대공약수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long min = Math.min(a, b);
        long max = Math.max(a, b);
        long rslt = getRslt(max, min);

        StringBuilder sb = new StringBuilder();

        while (rslt-- != 0) {
            sb.append("1");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();

    }

    public static long getRslt(long max, long min) {
        if(min == 0) return max;
        else return getRslt(min, max % min);

    }
}
