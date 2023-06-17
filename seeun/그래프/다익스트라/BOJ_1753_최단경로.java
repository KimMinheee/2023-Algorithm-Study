import java.io.*;
import java.util.*;

public class BOJ_1753_최단경로 {

    static ArrayList<Node>[] arr; //노드에 연결된 엣지, 가중치 저장 리스트배열
    static int[] ans; //출발노드에 대해 모든 노드 최단거리 저장배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken()); //노드 개수
        int e = Integer.parseInt(st.nextToken()); //에지 개수
        int startNo = Integer.parseInt(br.readLine()); //출발노드 번호

        arr = new ArrayList[v + 1];
        ans = new int[v + 1];

        //노드 수만큼 리스트배열 초기화
        for (int i = 1; i <= v; i++) {
            arr[i] = new ArrayList<>();
            ans[i] = Integer.MAX_VALUE; //가중치가 10이하 자연수이고 최단거리 구해야 하므로 11로 초기화
        }

        //에지 개수만큼 정보 인접리스트에 저장
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr[start].add(new Node(end, weight)); //임의의 노드에 대해 연결된 노드와 엣지 가중치 저장한 Node객체 저장
        }

        //출발노드로부터 모든 노드 최단거리 구하기
        dijkstra(startNo);

        //최종적으로 저장된 최단거리 배열
        //엣지로 연결되어 있지 않은 경우 거리 업데이트되지 않음, INF처리
        //거리 업데이트 되었다면 그대로 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }
            else{
                sb.append(ans[i] + "\n");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int startNo) {
        //가중치 더 작은 것 먼저 탐색하기 위한 우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight - o2.weight; //오름차순 정렬
            }
        });

        pq.add(new Node(startNo, 0)); //출발노드 넣어주기
        ans[startNo] = 0; //출발노드 거리 0

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            for (int i = 0; i < arr[n.connNode].size(); i++) {
                Node link = arr[n.connNode].get(i);
                if(ans[link.connNode] > n.weight + link.weight){
                    //배열에 저장된 최단거리보다 현재 노드에서 이어졌을 때 거리가 더 작은 경우만
                    // 갱신하고 큐에 넣는다
                    ans[link.connNode] = n.weight + link.weight;
                    pq.add(new Node(link.connNode, ans[link.connNode]));
                }
            }
        }
    }

    //연결된 노드와 엣지의 가중치 클래스
    static class Node{
        int connNode;
        int weight;

        public Node(int connNode, int weight) {
            this.connNode = connNode;
            this.weight = weight;
        }
    }
}
