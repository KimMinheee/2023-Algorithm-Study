package haein.그래프.벨만포드;
import java.util.*;
import java.io.*;

public class 타임머신{
        static final int INF = 10000 * 6000; // 최대 가능 비용
        static int N, M;
        static Edge[] edges;
        static long[] dist;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            edges = new Edge[M];
            dist = new long[N + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0; // 1번 도시에서의 비용은 0

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                int C = Integer.parseInt(st.nextToken());
                edges[i] = new Edge(A, B, C);
            }

            bellmanFord();

            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) System.out.println("-1");
                else System.out.println(dist[i]);
            }
        }

        static void bellmanFord() {
            for (int i = 1; i <= N; i++) {
                for (Edge edge : edges) {
                    if (dist[edge.src] != INF && dist[edge.dest] > dist[edge.src] + edge.cost) {
                        dist[edge.dest] = dist[edge.src] + edge.cost;
                        if (i == N) {
                            System.out.println("-1");
                            System.exit(0);
                        }
                    }
                }
            }
        }

        static class Edge {
            int src, dest, cost;

            Edge(int src, int dest, int cost) {
                this.src = src;
                this.dest = dest;
                this.cost = cost;
            }
        }
    }

    class

}