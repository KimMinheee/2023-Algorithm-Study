import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_2750 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }
}//책에선 버블정렬 파트에 있지만 sort가 간단해서 sort를 사용했습니다.
