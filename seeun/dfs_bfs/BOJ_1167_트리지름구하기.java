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
                if(end != -1)
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
        bw.write(dis[v]);
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
