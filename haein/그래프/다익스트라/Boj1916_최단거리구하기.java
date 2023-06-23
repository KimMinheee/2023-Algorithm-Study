package haein.그래프.다익스트라;
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    public it end, weight;
    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
    publc int compareTo(Node N) {
return this.weight - N.weight;
    }
}
public class Boj1916_최단거리구하기 {
    public static final int INF = (int)1e9;
    public static ArrayList<ArrayList<Node>> arr;
    public static int[] dist;
    public static void dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, 0));
        dist[start] = 0;

        while(!q.isEmpty()) {
            Node node = q.poll();
            int d = node.weight;
            int now = node.end;

            if(dist[now] < d) continue;
            for(int i = 0; i < arr.get(now).size(); i++) {
                int cost = dist[now] + arr.get(now).get(i).weight;
                if(cost < dist[arr.get(now).get(i).end]) {
                    dist[arr.get(now).get(i).end] = cost;
                    q.offer(new Node(arr.get(now).get(i).end, cost));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for(int i = 0; i <= n; i++) arr.add(new ArrayList<>());
        dist = new int[n+1];
        Arrays.fill(dist, INF);

        StringTokenizer st;
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            arr.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine(), " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }
}
