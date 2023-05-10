import java.util.*;
import java.io.*;

public class BOJ_10989 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();

        int[] cnt = new int[10001];

        int n = fr.nextInt();
        for (int i = 0; i < n; i++) {
            int x = fr.nextInt();
            cnt[x]++; //등장한 숫자를 카운트
        }

        StringWriter stringWriter = new StringWriter();
        BufferedWriter buffWriter = new BufferedWriter(stringWriter);

        for (int i = 0; i <= 10000; i++) {
            while(cnt[i]!=0){
                buffWriter.write(i + "\n");
                cnt[i]--;
            }
        }
        // Flush the buffer writer
        buffWriter.flush();
        System.out.println(stringWriter.getBuffer());
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public FastReader(String s) throws FileNotFoundException { br = new BufferedReader(new FileReader(new File(s))); }
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try { st = new StringTokenizer(br.readLine()); }
                catch (IOException e) { e.printStackTrace(); }
            }
            return st.nextToken();
        }
        int nextInt() { return Integer.parseInt(next()); }
        long nextLong() { return Long.parseLong(next()); }
        double nextDouble() { return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }
}
/*
문제해설 
주어진 숫자를 오름차순으로 정렬하면 되는 문제이다.

문제풀이
이 문제는 예전에 나동빈 강사님께 들었던 특강이 백준에 기록으로 남아있어 카운팅 소트를 복습해보았다
시간복잡도 문제로 일반 sort는 통하지 않는 문제이다. 빠른 정렬 로직이 필요하고 카운팅 소트는 O(kn)이다.
*/
