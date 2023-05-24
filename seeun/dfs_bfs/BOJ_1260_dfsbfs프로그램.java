import java.io.*;
import java.util.*;

public class BOJ_1260_dfsbfs프로그램 {

    static ArrayList<Integer> arr[];
    static boolean[] visited;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수
        int start = Integer.parseInt(st.nextToken()); //시작점 노드
        arr = new ArrayList[n + 1];

        //노드 정보 저장
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>(); //각 노드에 리스트 생성
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node].add(node2);
            arr[node2].add(node);
        }

        //연결되어 있는 노드들 중 작은 것부터 탐색될 수 있도록 정렬
        for(int i=1; i<=n; i++)
            Collections.sort(arr[i]);
        
        visited = new boolean[n+1];
        dfs(start);
        System.out.println();
        visited = new boolean[n+1];
        bfs(start);
    }

    private static void dfs(int n) throws IOException{
        visited[n] = true;
        bw.write(n + " ");
        bw.flush();
        ListIterator<Integer> listIterator = arr[n].listIterator();
        while (listIterator.hasNext()) {
            int next = listIterator.next();
            if(!visited[next]) //방문하지 않았다면
                dfs(next);
        }
    }

    private static void bfs(int n) throws IOException {

        Queue<Integer> q = new LinkedList<>();
        visited[n] = true;

        q.add(n);
        while (!q.isEmpty()) {
            int node = q.poll();
            bw.write(node + " "); //큐 안의 요소 꺼낸 후 출력
            bw.flush();
            ListIterator<Integer> listIterator = arr[node].listIterator(); //연결되어있는 노드 탐색
            while (listIterator.hasNext()) {
                int next = listIterator.next();
                if(!visited[next]) { //방문하지 않았다면
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
