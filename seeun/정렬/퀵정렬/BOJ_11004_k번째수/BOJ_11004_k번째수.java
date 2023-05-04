package week2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11004_k번째수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int k = Integer.parseInt(st.nextToken()); //k번째 수

        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(num, 0, N-1);

        bw.write(String.valueOf(num[k - 1]));
        bw.flush();
        bw.close();
    }

    private static void quickSort(int[] num, int start, int end) {

        int boundary = partition(num, start, end); //경계값 얻기

        //pivot왼쪽에 정렬할 데이터가 있을 경우
        if(start < boundary-1) quickSort(num, start, boundary-1);

        //pivot오른쪽에 정렬할 데이터가 있을 경우
        if(end > boundary) quickSort(num, boundary, end);
    }

    //파티션을 나눠주고 나눠진 경계 인덱스+1을 리턴하는 함수
    private static int partition(int[] num, int start, int end) {

        int pivot = num[(start + end) / 2]; //중앙 인덱스를 피봇으로
        while (start <= end) {
            while(num[start] < pivot) start++; //값이 pivot보다 작은 동안 ++
            while (num[end] > pivot) end--; //값이 pivot보다 큰 동안 --
            if (start <= end) {
                swap(num, start++, end--); //pivot보다 큰 값과 작은 값 서로 바꿔주기
            }
        }
        return start; //swap된 부분 오른쪽 인덱스 리턴
    }

    private static void swap(int[] num, int idx1, int idx2){
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }
}
