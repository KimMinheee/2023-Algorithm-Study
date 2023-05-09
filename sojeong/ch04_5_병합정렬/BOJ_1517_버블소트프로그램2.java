package ch04_5_병합정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1517_버블소트프로그램2 {

    public static long solve(int[] a, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        int[] b = new int[end - start + 1];
        long ans = solve(a, start, mid) + solve(a, mid + 1, end);
        {
            int index1 = start; //앞부분 인덱스
            int index2 = mid + 1; //뒷부분 인덱스
            int k = 0;
            while (index1 <= mid || index2 <= end) { // &&이 아닌 ||로 while문 하나로 처리
                //index2 > end || ->로 앞부분에 남아있을 경우를 처리
                if (index1 <= mid && (index2 > end || a[index1] <= a[index2])) {
                    b[k++] = a[index1++];
                } else {
                    ans += (long) (mid - index1 + 1); //왼쪽의 남은 크기 만큼 더함
                    b[k++] = a[index2++];
                }
            }
        }
        for (int i = start; i <= end; i++) {
            a[i] = b[i - start];
        }
        return ans;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] a = new int[n];
        String[] line = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.valueOf(line[i]);
        }
        long ans = solve(a, 0, n - 1);
        System.out.println(ans);
    }
}