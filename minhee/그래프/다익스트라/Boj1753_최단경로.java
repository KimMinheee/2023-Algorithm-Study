package minhee.그래프.다익스트라;

import java.io.*;
import java.util.*;

public class Boj1753_최단경로 {
    public static final int INF = Integer.MAX_VALUE;
    static int V,E; //정점의 개수 V, 간선의 개수 E
    static List<List<Edge>> adjacencyList = new ArrayList<>();
    static int[] answer;
    static boolean[] isVisit;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        int startNode = Integer.parseInt(br.readLine());

        //인접 리스트 초기화
        for(int i=0; i<=V; i++){
            adjacencyList.add(new ArrayList<>());
        }
        answer = new int[V+1]; //0 고려
        isVisit = new boolean[V+1];

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjacencyList.get(start).add(new Edge(end, cost));
        }

        init(startNode);

        pq.add(new Edge(startNode,0));
        dijkstra(startNode);
        print();

    }
    static void dijkstra(int startNode){
        while(!pq.isEmpty()){
            Edge e = pq.poll();

            if(!isVisit[e.node]) {
                isVisit[e.node] = true;
                for(Edge edge : adjacencyList.get(e.node)){
                    int min = Math.min(answer[edge.node], edge.cost+answer[e.node]);
                    answer[edge.node] = min;
                    pq.add(new Edge(edge.node, min));
                }
            }
        }
    }
    static void init(int startNode){
        //startNode는 0으로 나머지는 INF로 answer 배열 초기화
        Arrays.fill(answer,INF);
        answer[startNode] = 0;
    }
    static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=V; i++){
            if(answer[i] == INF) sb.append("INF\n");
            else sb.append(answer[i]+"\n");
        }
        System.out.print(sb.toString());
    }
}
class Edge implements Comparable<Edge>{
    int node;
    int cost;

    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e2){
        return this.cost - e2.cost; //가중치 작은 거 부터
    }
}
