package ch07_1_정수론;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1016_제곱아닌수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        boolean[] ans = new boolean[(int) (max - min + 1)]; // false 가 나눠지지 않는 것

        ArrayList<Long> modNums = new ArrayList<>();
        for (long i = 2; i <= Math.sqrt(max); i++) {
            modNums.add(i * i);
        }

        for (long num : modNums) {
            // num 으로 나눠지는 min 이상인 첫번째 수를 찾음
            // 그 숫자가 위치하는 배열의 인덱스부터 +num 한 인덱스만 처리하면 되기때문에
            double t = (double) min / (double) num;
            long start = (long) ((num * Math.ceil(t)) - min);

            for (long i = start; i < ans.length; i += num) {
                ans[(int) i] = true;
            }
        }

        int count = 0;

        for (int i = 0; i < ans.length; i++) {
            if (!ans[i]) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}

