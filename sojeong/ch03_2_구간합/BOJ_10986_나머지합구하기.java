package ch03_2_구간합;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10986_나머지합구하기 {

    public static void main(String[] args) throws Exception {
        //누적합 나머지 합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long ans = 0;
        long[] mod = new long[(int) m];
        long[] sumArr = new long[n + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            long num = Long.parseLong(st.nextToken());
            //i인덱스까지의 누적합을 구해서 저장
            sumArr[i] = sumArr[i - 1] + num;
            //누적합의 나머지가 0이라면 바로 답++
            if (sumArr[i] % m == 0) {
                ans++;
            }
            //같은 나머지끼리 몇개인지 저장
            mod[(int) (sumArr[i] % m)] += 1;

        }
        //같은 나머지 개수로 조합을 구하여 답에 추가한다
        for (int i = 0; i < m; i++) {
            ans += mod[i] * (mod[i] - 1) / 2;
        }

        System.out.println(ans);
    }
}
