package minhee.자료구조.스택과큐;
import java.util.*;
import java.io.*;

/**
 * pq 사용 -> 시간초과 발생
 */

public class Boj17298_오큰수 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        //데이터 입력
        for(int i=0; i<N; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N-1; i++){
            PriorityQueue<Data> pq = new PriorityQueue<>();
            for(int j=i+1; j<N; j++){
                if(data[j] > data[i]) pq.add(new Data(j,data[j]));
            }

            if(!pq.isEmpty()){
                Data tmp = pq.poll();
                sb.append(tmp.value+" ");
            }
            else{
                sb.append("-1 ");
            }
        }
        sb.append(-1);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
class Data implements Comparable<Data>{
    int index;
    int value;

    public Data(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Data d2){
        return this.index - d2.index;
    }

}
