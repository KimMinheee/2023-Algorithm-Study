package week2;

import java.io.*;

public class BOJ_1427_내림차순정렬 {

    private static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String N = br.readLine();

        int len = N.length();
        num = new int[len];
        for(int i=0; i<len; i++){
            num[i] = Integer.parseInt(N.substring(i, i + 1)); //한자리 씩 int형으로 변환해서 배열에 저장
        }

        for(int i=0; i<len; i++){
            int maxIdx = i; //최댓값의 인덱스
            for(int j=i; j<len; j++){
                if(num[maxIdx]<num[j]){
                    maxIdx = j;
                }
            }
            swap(i, maxIdx); //현재 사이클의 최댓값과 정렬완료부분의 가장 뒤의 인덱스와 swap
            sb.append(num[i]); //정렬된 부분 sb에 붙이기
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static void swap(int idx1, int idx2) {
        int tmp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = tmp;
    }
}
