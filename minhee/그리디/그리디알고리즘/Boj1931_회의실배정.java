package minhee.그리디.그리디알고리즘;

import java.io.*;
import java.util.*;

public class Boj1931_회의실배정{
    static int N; //회의개수
    static List<Meeting> data = new ArrayList<>();
    static PriorityQueue<Meeting> pq = new PriorityQueue<>();
    static int time = 0;
    static int answer = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start  = Integer.parseInt(st.nextToken());
            int finish = Integer.parseInt(st.nextToken());

            data.add(new Meeting(start, finish));
            pq.add(new Meeting(start, finish));
        }

        //끝나는 시간을 오름차순으로 정렬
        Collections.sort(data);

        countMeeting();
        System.out.println(answer);
    }
    static void countMeeting(){
         Meeting m1 = pq.poll();
         time = m1.finish;
         answer++;

        while(!pq.isEmpty()){
            Meeting m = pq.poll(); //끝나는 시간이 가장 빠른 회의 정보

            if(time <= m.start){
                time = m.finish;
                answer++;
            }
        }
    }
}
class Meeting implements Comparable<Meeting>{
    int start;
    int finish;

    public Meeting(int start, int finish){
        this.start = start;
        this.finish = finish;
    }
    @Override
    public int compareTo(Meeting m2){
        int tmpFinish = this.finish - m2.finish;
        if(tmpFinish == 0) return this.start - m2.start;
        return tmpFinish;
    }
}