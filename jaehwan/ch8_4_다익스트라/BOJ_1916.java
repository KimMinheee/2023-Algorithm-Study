import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node_1916 implements Comparable<Node_1916> {
    int targetNode_1916;
    int value;

    Node_1916(int targetNode_1916, int value) {
        this.targetNode_1916 = targetNode_1916;
        this.value = value;
    }

    @Override
    public int compareTo(Node_1916 o) {
        return value - o.value;
    }
}

public class BOJ_1916 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static ArrayList<Node_1916>[] list;
    static int[] distance;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        distance = new int[N + 1];
        visit = new boolean[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE); //거리 배열에 전부 최대값 집어 넣어놓음
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<Node_1916>();
        }
        for (int i = 0; i < M; i++) { //버스의 개수만큼
            st =new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[start].add(new Node_1916(end, cost));
        }
        st =new StringTokenizer(br.readLine());
        int startIndex = Integer.parseInt(st.nextToken());
        int endIndex = Integer.parseInt(st.nextToken());
        bw.write(dStra(startIndex, endIndex) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dStra(int start, int end) {
        PriorityQueue<Node_1916> pq = new PriorityQueue<>();
        pq.add(new Node_1916(start, 0));
        distance[start] = 0;//최단거리 배열
        while (!pq.isEmpty()) {
            Node_1916 nowNode = pq.poll();
            int now = nowNode.targetNode_1916;
            if (visit[now]) continue;
            visit[now] = true;
            for (Node_1916 n : list[now]) {//에지 개수만큼
                //타깃노드의 최단거리 > 현재 선택된갓 노드값 + 가중치
                //distance 더 작은 값으로 갱신
                if (distance[n.targetNode_1916] > distance[now] + n.value) {
                    distance[n.targetNode_1916] = distance[now] + n.value;
                    pq.add(new Node_1916(n.targetNode_1916, distance[n.targetNode_1916]));
                }
            }

        }
        return distance[end];
    }
}

/*
특정 노드부터 특정 노드까지의 최단거리를 구하는 문제 -> 다익스트라 음수가 가중치에 없으므로 다익스트라가 좋다.
*/
