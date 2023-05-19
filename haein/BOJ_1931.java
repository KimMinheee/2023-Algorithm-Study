import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long k = sc.nextLong();
        sc.close();

        System.out.println(findBk(N, k));
    }

    private static long findBk(int N, long k) {
        long left = 1;
        long right = N * N;
        long mid;
        long count;
        long result = 0;

        while (left <= right) {
            mid = (left + right) / 2;
            count = 0;

            for (int i = 1; i <= N; i++) {
                count += Math.min(mid / i, N);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }
}
