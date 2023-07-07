import java.io.*;
import java.util.*;

public class BOJ_17472 {//[BOJ_17472]다리만들기 jaehwan solving - bfs,mst 사용
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Node>[] list; //각 섬의 정보
    static PriorityQueue<Mst_Node> pq;
    static int[] parent;//각 섬의 부모 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //행
        m = Integer.parseInt(st.nextToken()); //열
        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬마다 고유 숫자를 부여 - bfs 사용
        list = new ArrayList[7]; //섬 개수 최대 6개 2~6
        visited = new boolean[n][m];
        int num = 1;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) {
                    list[num] = new ArrayList<>();
                    bfs(i, j, num);
                    num++;
                }
            }
        }

        //각 섬을 연결할 수 있는 방법을 모두 구한다.
        pq = new PriorityQueue<>();
        for(int i = 1; i < num; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                Node island = list[i].get(j);
                for(int k = 0; k < 4; k++) {
                    find_bridge(island.x, island.y, i, k, -1);
                }
            }
        }

        //mst알고리즘으로 최소 간선을 선택한다.
        System.out.println(kruskal(num));
    }

    public static int kruskal(int num) {
        parent = new int[num];
        for(int i = 1; i < num; i++) {
            parent[i] = i;
        }

        boolean[] link = new boolean[num];
        int result = 0;
        int bridge = 0;
        while(!pq.isEmpty()) {
            Mst_Node current = pq.poll();

            int p1 = find(current.n1);
            int p2 = find(current.n2);

            if(p1 != p2) {
                union(p1, p2);
                link[current.n1] = true;
                link[current.n2] = true;
                result += current.length;
                bridge++;
            }
        }

        if(result == 0) return -1;
        if(bridge != num - 2) return -1;
        return result;
    }

    public static int find(int node) {
        if(parent[node] == node) return node;
        else return parent[node] = find(parent[node]);
    }

    public static void union(int a, int b) {
        parent[a] = b;
    }

    public static void find_bridge(int x, int y, int num, int dir, int len) {
        if(map[x][y] != 0 && map[x][y] != num) { //다른 섬을 만남
            if(len >= 2) pq.offer(new Mst_Node(num, map[x][y], len));
            return;
        }

        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if(nx < 0 || ny < 0 || nx >= n || ny >= m) return;
        if(map[nx][ny] == num) return;
        find_bridge(nx, ny, num, dir, len + 1);
    }

    public static void bfs(int x, int y, int num) { //섬 라벨링 함수
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        visited[x][y] = true;

        while(!q.isEmpty()) {
            Node current = q.poll();

            map[current.x][current.y] = num; //좌표 map 값에 숫자값 입력
            list[num].add(new Node(current.x, current.y)); //리스트에도 추가

            for(int i = 0; i < 4; i++) { //상하좌우
                int nx = current.x + dx[i]; // {0, 1, 0, -1};
                int ny = current.y + dy[i]; //{-1, 0, 1, 0};
                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue; //배열의 범위를 벗어나는지 확인
                if(visited[nx][ny] || map[nx][ny] != 1) continue; //이미 방문한 좌표인지 || 다음좌표가 섬이 맞는지
                visited[nx][ny] = true;  //방문한적이 없음 = 방문체크
                q.offer(new Node(nx, ny)); //큐에 다음 좌표 넘김
            }
        }
    }

    public static class Mst_Node implements Comparable<Mst_Node> { //최소 신장 트리 간선
        int n1, n2, length;

        public Mst_Node(int n1, int n2, int length) {
            this.n1 = n1;
            this.n2 = n2;
            this.length = length;
        }

        @Override
        public int compareTo(Mst_Node mst_n) {
            return this.length - mst_n.length;
        }
    }

    public static class Node { //섬 좌표
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
