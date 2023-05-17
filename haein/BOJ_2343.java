import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] lectures;

    public static boolean isPossible(int mid) {
        int cnt = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (sum + lectures[i] > mid) {
                sum = lectures[i];
                cnt++;
            } else {
                sum += lectures[i];
            }
        }
        return cnt <= M;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lectures = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        int sum = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            max = Math.max(max, lectures[i]);
        }

        int left = max;
        int right = sum;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(mid)) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
