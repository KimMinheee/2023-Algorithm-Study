package week1;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class BOJ_1940_주몽의명령 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //재료 개수
        int M = Integer.parseInt(br.readLine()); //필요 수

        int[] igd = new int[N]; //재료 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            igd[i] = Integer.parseInt(st.nextToken());
        }
        //배열 정렬
        Arrays.sort(igd);
        
        int ptr = 0; //앞의 포인터
        int cnt = 0; //만들 수 있는 카운트
        
        //두수의 합이 M이 되는 경우 구하기
        List<Integer> list = Arrays.stream(igd).boxed().collect(Collectors.toList()); //int형 배열의 스트림을 wrapper클래스로 바꿔주고 리스트로 변경
        int stop = N;
        while(ptr < stop){
            //만약 M/2인 값이 재료에 포함되어있다면 탐색과정에서 제외
            if(list.get(ptr)*2 == M){
                ptr++;
                continue;
            }
            int val = M-list.get(ptr); //M-ptr1인덱스에 있는 요소
            //해당 요소가 리스트에 있다면
            if(list.contains(val)){
                stop = list.indexOf(val); //탐색 범위 좁혀주기
                cnt++;
            }
            ptr++;
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
