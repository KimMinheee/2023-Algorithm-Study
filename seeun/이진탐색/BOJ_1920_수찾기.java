import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920_수찾기 {

    static int[] A;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(findNum(Integer.parseInt(st.nextToken())) + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static int findNum(int num) {
        int start = 0;
        int end = A.length-1;

        while (start <= end) {
            int mid = (start+end)/2;

            //중간값과 같을 경우
            if (A[mid] == num) {
                return 1;
            }
            //중간값보다 작을 경우
            if(A[mid] > num){
                end = mid-1;
            }

            //중간값보다 클 경우
            else{
                start = mid+1;
            }
        }
        //결국 num이 속해있지 않을 경우
        return 0;
    }
}
