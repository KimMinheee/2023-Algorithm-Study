import java.util.*;

public class BOJ_11437 { //[BOJ_11437]최소공통조상 jaehwan solved - LCA,BFS 사용
    static ArrayList<Integer>[] tree;//인접리스트
    static int[] depth;  //깊이
    static int[] parent; //대표 노드
    static boolean[] visited; //방문확인

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //노드 수
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<Integer>();
        }
        //인전리스트에 그래프 저장
        for (int i = 0; i < N - 1; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            tree[s].add(e); //양방향
            tree[e].add(s);
        }
        depth = new int[N + 1];
        parent = new int[N + 1];
        visited = new boolean[N + 1];

        BFS(1); //depth 구하기

        int M = sc.nextInt(); //질문 수
        for (int i = 0; i < M; i++) { //공통조상 구할 노드 입력
            int a = sc.nextInt();
            int b = sc.nextInt();
            int LCA = LCA(a, b); //공통조상 구하기
            System.out.println(LCA);
        }
    }

    //depth값을 기준으로 낮은걸 똑같아질때까지 올리고 부모가 같을때까지 또 올림
    static int LCA(int a, int b) { 
        if (depth[a] < depth[b]) { //앞을 기준으로 하기 때문에 뒤가 더크면 바꿔줌 
            int temp = a;
            a = b;
            b = temp;
        } 
        while (depth[a] != depth[b]) { //깊이 맞추기
            a = parent[a];
        }
        while (a != b) { //공통 부모노드가 나올때까지
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
    private static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        visited[node] = true;
        int level = 1;    //depth
        int now_size = 1; //현재 depth의 크기
        int count = 0;    //현재 depth에서 내가 몇개의 노드를 처리했는지 알려주는 변수
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (int next : tree[now_node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    parent[next] = now_node; //이전노드이기 때문에
                    depth[next] = level;     //노드 깊이 저장
                }
            }
            count++; //처음에 루트노드 처리가 끝나면
            if (count == now_size) { //처음에 1:1로 만남
                count = 0;
                now_size = queue.size(); //처음에 2
                level++;
            }
        }
    }
}

/*
일반적인 LCA 문제 (시간복잡도가 영향 거의 없음)
* */
