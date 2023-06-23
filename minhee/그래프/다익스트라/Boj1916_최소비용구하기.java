package minhee.그래프.다익스트라;

import java.io.*;
import java.util.*;
public class Boj1916_최소비용구하기 {
    static int N,M;
    static List<List<Connect>> list = new ArrayList<>();
    static int[] answer;
    static boolean[] check;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        //초기화
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        answer = new int[N+1];
        check = new boolean[N+1];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(start).add(new Connect(dest, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startPoint = Integer.parseInt(st.nextToken());
        int endPoint = Integer.parseInt(st.nextToken());

        init(startPoint);
        dijkstra(startPoint);

        bw.write(String.valueOf(answer[endPoint]));
        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int start){
        PriorityQueue<Connect> pq = new PriorityQueue<>();
        pq.offer(new Connect(start, 0));

        while(!pq.isEmpty()){
            Connect c = pq.poll();
            int dest = c.dest;

            if(!check[dest]){
                check[dest] = true;
                for(Connect tmpConnect : list.get(dest)){
                    int min = Math.min(answer[tmpConnect.dest] , (answer[dest]+ tmpConnect.cost));
                    answer[tmpConnect.dest] = min;
                    pq.add(new Connect(tmpConnect.dest, answer[tmpConnect.dest]));
                }
            }
        }

    }
    static void init(int startPoint){
        Arrays.fill(answer,MAX);
        answer[startPoint] = 0;
    }
}
class Connect implements Comparable<Connect>{
    int dest;
    int cost;

    public Connect(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }

    @Override
    public int compareTo(Connect c2){
        return this.cost - c2.cost;
    }

}
