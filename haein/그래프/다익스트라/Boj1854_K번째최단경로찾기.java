package haein.그래프.다익스트라;
import java.util.*;
import java.io.*;
public class Boj1854_K번째최단경로찾기 {
        private static final int INF = 1000000;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ArrayList<Pair>[] adj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adj[u].add(new Pair(v, w));
            }

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.offer(new Pair(1, 0));
            int[][] dist = new int[n + 1][k + 1];
            for (int[] row : dist) {
                Arrays.fill(row, INF);
            }
            dist[1][0] = 0;

            while (!pq.isEmpty()) {
                Pair cur = pq.poll();
                if (cur.cost > dist[cur.node][k - 1]) continue;
                for (Pair next : adj[cur.node]) {
                    int cost = cur.cost + next.cost;
                    if (cost < dist[next.node][k - 1]) {
                        dist[next.node][k - 1] = cost;
                        pq.offer(new Pair(next.node, cost));
                        Arrays.sort(dist[next.node]);
                    }
                }
            }

            for (int i = 1; i <= n; i++) {
                System.out.println(dist[i][k - 1] == INF ? -1 : dist[i][k - 1]);
            }
        }

        static class Pair implements Comparable<Pair> {
            int node, cost;

            Pair(int node, int cost) {
                this.node = node;
                this.cost = cost;
            }

            @Override
            public int compareTo(Pair o) {
                return Integer.compare(this.cost, o.cost);
            }
        }
    }

}
