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

        int pl = start;
        int pr = end;
        int pivot = num[(pl+pr)/2]; //가운데 수를 pivot으로

        do{
            while(num[pl]<pivot) pl++;
            while(num[pr]>pivot) pr--;

            if(pl <= pr)
                swap(num, pl++, pr--); //더이상 옮길 수 없으면
        }while(pl <= pr);
        
        if(start < pr) quickSort(num, start, pr); //start포인터가 현재 오른쪽 포인터보다 작으면
        if(pl > end) quickSort(num, pl, end); //end포인터가 현재 왼쪽 포인터보다 작으면
    }

    private static void swap(int[] num, int idx1, int idx2){
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }
}
