import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1517_버블소트프로그램2 {

    private static long[] num;
    private static long[] ans;
    private static long cnt;
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        num = new long[N];
        ans = new long[N];
        cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(num, 0, N-1);
        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
    private static void mergeSort(long[] num, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2; //중간 인덱스
            mergeSort(num, start, mid); //왼쪽 그룹
            mergeSort(num, mid + 1, end); //오른쪽 그룹
            merge(num, start, mid, end); //왼쪽 그룹과 오른쪽 그룹 병합정렬
        }
    }

    //정렬하면서 병합
    private static void merge(long[] num, int start, int mid, int end) {
        int lStart = start;
        int RStart = mid+1;
        int idx = start; //정답배열 인덱스


        //오름차순으로 배열에 넣기
        while (lStart <= mid && RStart <= end) { //범위 동안

            //오른쪽 그룹의 수가 더 작을 때, 뒤쪽에 더 작은 수가 있어서 먼저 삽입하는 경우이므로 swap이 된 것으로 볼 수 있음
            if (num[lStart] <= num[RStart]) {
                ans[idx++] = num[lStart++];
            }
            //왼쪽 그룹의 수가 더 작을 때
            else {
                ans[idx++] = num[RStart++];
                //움직인 인덱스만큼 swap됨, 저장된 idx인덱스까지의 거리 = swap된 횟수
                cnt += mid - lStart + 1; //오른쪽 그룹시작 인덱스 - 지금까지 왼쪽그룹 저장된 마지막 인덱스
            }
        }

        if(lStart > mid) {
            //왼쪽 그룹 모두 정답배열에 들어갔을 경우, 못들어간 오른쪽 그룹 나머지 다 넣어줌
            while (RStart <= end) {
                ans[idx++] = num[RStart++];
            }
        } else{
            //오른쪽 그룹 모두 정답배열에 들어갔을 경우, 못들어간 왼쪽 그룹 나머지 다 넣어줌
            while (lStart <= mid) {
                ans[idx++] = num[lStart++];
            }
        }

        //정렬완료한 정답배열 실제 배열에 복사
        for (int i = start; i <= end; i++) {
            num[i] = ans[i];
        }
    }
}