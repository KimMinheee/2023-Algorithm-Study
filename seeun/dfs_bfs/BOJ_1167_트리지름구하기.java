/**
 *임의의 노드로 bfs를 수행해서 각 다른 노드까지의 거리를 dis배열에 저장한다.
 *(bfs는 레벨 순서로 탐색하므로 가장 멀리 떨어진 노드를 먼저 찾을 수 있음)
 * 
 * dis배열에서 가장 값이 큰(임의의 노드로부터 최장거리에 있는 노드) 것을 구한다. 해당 노드는 가장 가중치가 큰 엣지를 가짐
 *
 * 해당 노드로 다시 bfs를 수행해서 그래프의 최장거리 구하기(트리지름, 가장 멀리 떨어진 노드들 사이의 거리)
 */

import java.io.*;
import java.util.*;

public class BOJ_1167_트리지름구하기 {

    private static ArrayList<Edge> arr[];
    private static boolean[] visited;

    private static int[] dis;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int v = Integer.parseInt(br.readLine());

        arr = new ArrayList[v + 1];

        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < v; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1)
                    break;
                int weight = Integer.parseInt(st.nextToken());
                arr[start].add(new Edge(end, weight));
            }
        }

        dis = new int[v+1];
        visited = new boolean[v + 1];
        bfs(1);

        int max = 1;
        //bfs 후 업데이트 된 각 거리 중 최대값 구하기
        for (int i = 2; i <= v; i++) {
            if (dis[i] > dis[max]) {
                max = i;
            }
        }

        dis = new int[v+1];
        visited = new boolean[v + 1];
        bfs(max);

//        다시 계산한 거리중 가장 긴 거리 고르기
        Arrays.sort(dis);
        bw.write(dis[v] + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
    
    private static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;
        q.add(n);

        while (!q.isEmpty()) {
            int node = q.poll();
            ListIterator<Edge> listIterator = arr[node].listIterator(); //연결되어있는 노드 탐색
            while (listIterator.hasNext()) {
                Edge next = listIterator.next();
                int e = next.e;
                int weight = next.weight;
                if(!visited[e]) { //방문하지 않았다면
                    q.add(e);
                    visited[e] = true;
                    dis[e] = dis[node] + weight;//이전 문제와 비슷하게 현재 거리+1
                }
            }
        }
    }
}

class Edge {
    int e;
    int weight;

    public Edge(int e, int weight) {
        this.e = e;
        this.weight = weight;
    }
}
