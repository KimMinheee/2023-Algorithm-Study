import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < N - 1; i += 2) {
            if (arr[i] > 1 && arr[i + 1] > 1) {
                sum += arr[i] * arr[i + 1];
            } else if (arr[i] <= 0 && arr[i + 1] <= 0) {
                sum += arr[i] * arr[i + 1];
                i--;
            } else {
                break;
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < N - 1; i += 2) {
            if (arr[i] <= 0 && arr[i + 1] <= 0) {
                sum += arr[i] * arr[i + 1];
            } else {
                break;
            }
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) {
                sum += arr[i];
            }
        }

        System.out.println(sum);
    }
}
