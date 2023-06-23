package haein.그래프.다익스트라;
import java.util.*;
import java.io.*;
public class Boj1854_K번째최단경로찾기 {
//    무한대를 나타내는 노드
        private static final int INF = 1000000;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());



//            각 노드에 연결된 인접 노드와 그 간선의 가중치를 저장하는 인접 리스트
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




////         우선 순위 큐로(다익스트라 알고리즘에서 사용) 비용이 가장 적은 노드를 먼저 방문하도록 함.
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.offer(new Pair(1, 0));



//         각 노드까지의 K번째 최단 거리를 저장하기 위한 2차원 배열.
//         dist[i][j] = i번 노드까지의 j번째 최단 거리
            int[][] dist = new int[n + 1][k + 1];
            for (int[] row : dist) {
                Arrays.fill(row, INF);
            }
            dist[1][0] = 0;


//            다익스트라 알고리즘.
//            우선순위 큐에서 노드를 하나씩 꺼내며 인접한 노드들을 방문

//            방문한 노드까지의 비용이 현재 저장된 비용보다 작을 경우,
//            비용을 갱신하고 그 노드를 우선순위 큐에 추가
//            이 과정을 우선순위 큐가 비어있을 때까지 반복
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



//            각 노드까지의 K번째 최단 거리를 출력.
//            노드까지의 K번째 최단 거리가 계산되지 않았으면 -1을 출력.
            for (int i = 1; i <= n; i++) {
                System.out.println(dist[i][k - 1] == INF ? -1 : dist[i][k - 1]);
            }
        }



//        노드와 그 노드까지의 비용을 쌍으로 저장하는 클래스.
//        Comparable 인터페이스를 구현하여
//        우선순위 큐에서 비용이 적은 순서대로 정렬
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
