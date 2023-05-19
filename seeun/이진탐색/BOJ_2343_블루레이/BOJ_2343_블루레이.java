package week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2343_블루레이 {

    private static int[] lec; //레슨 시간 담는 배열
    private static int n; //레슨 수
    private static int m; //블루레이 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lec = new int[n]; //레슨 배열
        st = new StringTokenizer(br.readLine());
        int sum = 0; //블루레이 크기 최댓값구하기 위한 레슨시간 전체 합
        int timeMax = 0; //블루레이 크기 최솟값구하기 위한 레슨시간 최댓값
        for (int i = 0; i < n; i++) { //각 레슨 저장
            lec[i] = Integer.parseInt(st.nextToken());
            sum += lec[i];
            if(timeMax < lec[i])
                timeMax = lec[i];
        }

        int min = timeMax; //블루레이 크기 최솟값
        int max = sum; //블루레이 크기 최댓값

        //블루레이 개수 m개로 전체 레슨을 나누기 위해서 블루레이 크기로 이진탐색을 해서 적당한 블루레이 크기를 찾는다
        //총 개수 m개로 모든 레슨을 넣을 수 있는 적당한 블루레이 크기를 찾고 들어간 각 레슨시간 중 최솟값 얻는 함수
        bw.write(String.valueOf(getMinTime(min, max, m)));
        bw.flush();
        br.close();
        bw.close();

    }

    private static int getMinTime(int min, int max, int num) {
        while (min <= max) {
            int mid = (min + max) / 2;

            int cnt = 0; //크기에 따라 나누어지는 수
            int sum = 0; //레슨시간 합
            for (int i = n - 1; i >= 0; i--) {
                sum +=lec[i];
                if (mid < sum) { //시간 넘어가면 다음 블루레이에 포함
                    cnt++;
                    sum=lec[i];
                }
                if(cnt>num) { //num 넘어간다면 미리 끝내기
                    break;
                }
            }
            //sum에 무언가 남아있으면 아직 남아있는 레슨있다는 뜻으로 블루레이 하나 추가해야함
            if (sum != 0) {
                cnt++;
            }
            //나눈 블루레이 cnt가 m보다 클 경우, 개수를 줄이기 위해 크기를 키워야 함
            if (cnt > num) {
                min = mid+1;
            }
            //나눈 블루레이 cnt가 m보다 작을 경우, 개수를 늘리기 위해 크기를 줄여야 함
            //나눈 블루레이 cnt가 m와 같을 경우, 크기 더 줄일 수 있는지 확인해야함
            else{
                max = mid-1;
            }
        }
        //원하는 개수로 나누어진다면 제일 최소시간 리턴, max = mid-1로 min이 max보다 커지고 끝나므로 min이 정답
        return min;
    }
}
