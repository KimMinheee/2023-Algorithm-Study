import java.io.*;

public class BOJ_2751_수정렬하기2 {

    private static int[] ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        ans = new int[N];

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }


        mergeSort(num, 0, N-1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(num[i] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    //분할해서 병합정렬 함수에 보냄
    private static void mergeSort(int[] num, int start, int end) {

        if (start < end) {
            int mid = (start + end) / 2; //중간 인덱스
            mergeSort(num, start, mid); //왼쪽 그룹
            mergeSort(num, mid + 1, end); //오른쪽 그룹
            merge(num, start, mid, end); //왼쪽 그룹과 오른쪽 그룹 병합정렬
        }
    }

    //정렬하면서 병합
    private static void merge(int[] num, int start, int mid, int end) {
        int lStart = start;
        int RStart = mid+1;
        int idx = start; //정답배열 인덱스

        //오름차순으로 배열에 넣기
        while (lStart <= mid && RStart <= end) { //범위 동안

            //왼쪽 그룹의 수가 더 작을 때
            if (num[lStart] <= num[RStart]) {
                ans[idx++] = num[lStart++];
            }
            //오른쪽 그룹의 수가 더 작을 때
            else {
                ans[idx++] = num[RStart++];
            }
        }
            
        //왼쪽 그룹 모두 정답배열에 들어갔을 경우, 못들어간 오른쪽 그룹 나머지 다 넣어줌
        if(lStart> mid){
            while (RStart <= end) {
                ans[idx++] = num[RStart++];
            }
        }

        //오른쪽 그룹 모두 정답배열에 들어갔을 경우, 못들어간 왼쪽 그룹 나머지 다 넣어줌
        else{
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
