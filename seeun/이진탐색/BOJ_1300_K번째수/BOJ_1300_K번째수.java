package week4;

import java.io.*;

public class BOJ_1300_K번째수 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        long k = Long.parseLong(br.readLine());

        long start = 1;
        //n*n일 경우 내가찾는 k번째 수보다 너무나 많은 수들을 읽어야함, 애초에 k번째 수을 얻는 것이 목표이므로 k번째를 끝으로 시작하는 것이 효율적
        //n*n을 사용할 경우 최대 10^10 무조건 long 사용해야 함
        long end = n*n;
        long ans = 0;

        System.out.println("end = " + end);
        //i*j로 이루어진 1차원 요소를 가지고 이분탐색 시작
        while (start <= end) {
            long mid = (start+end)/2;

            //중간값보다 작거나 같은 수의 개수 찾기
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                long add = mid/i;
                if(add>n){
                    add = n;
                }
                cnt += add;
            }

            //개수의 합이 k보다 작을 경우
            if(cnt < k){
                start = mid+1;
            }
            //개수의 합이 k보다 크거나 같을 경우
            else{
                end = mid-1;
                ans = mid;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
