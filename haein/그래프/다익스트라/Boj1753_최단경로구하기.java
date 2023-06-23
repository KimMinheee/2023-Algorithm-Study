package haein.그래프.다익스트라;
import java.util.*;
import java.io.*;
public class Boj1753_최단경로구하기 {

        static final int INF = Integer.MAX_VALUE;
        static int V, E, K;
        static List<Pair>[] adjList;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            K = Integer.parseInt(br.readLine());

            adjList = new ArrayList[V+1];
            for (int i = 1; i <= V; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                adjList[u].add(new Pair(v, w));
            }

            int[] distance = dijkstra();

            for (int i = 1; i <= V; i++) {
                if (distance[i] == INF)
                    System.out.println("INF");
                else
                    System.out.println(distance[i]);
            }
        }

        public static int[] dijkstra() {
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            int[] distance = new int[V+1];
            Arrays.fill(distance, INF);
            distance[K] = 0;
            pq.offer(new Pair(K, 0));

            while (!pq.isEmpty()) {
                Pair current = pq.poll();
                if (distance[current.vertex] < current.weight)
                    continue;

                for (Pair next : adjList[current.vertex]) {
                    if (distance[next.vertex] > current.weight + next.weight) {
                        distance[next.vertex] = current.weight + next.weight;
                        pq.offer(new Pair(next.vertex, distance[next.vertex]));
                    }
                }
            }
            return distance;
        }
    }

    class Pair implements Comparable<Pair> {
        int vertex, weight;

        Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return weight - o.weight;
        }
    }

}
