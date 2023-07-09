package haein.그래프.최소신장트리;
import java.io.*;
import java.util.*;

public class 최소스패닝트리 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(u, v, w));
        }

        int result = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (find(edge.u) != find(edge.v)) {
                union(edge.u, edge.v);
                result += edge.w;
            }
        }

        System.out.println(result);
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);
        parent[xRoot] = yRoot;
    }
}
