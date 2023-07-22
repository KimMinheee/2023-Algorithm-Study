import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11438 {//[B0J_11438]최소공통조상2 jaehwan solved - bfs, LCA 사용
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax; //k최대값
    static int[][] parent; //부모 노드
    static boolean[] visited;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        tree=new ArrayList[N+1]; // 1.s 인접리스트로 트리 데이터 구현
        for(int i=1;i<=N; i++){
            tree[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<N-1;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        //1.e
        depth=new int[N+1];
        visited =new boolean[N+1];
        //N이 노드의 개수

        int temp=1;
        kmax=0;
        while (temp<=N) { //kmax 구하는 방법
            temp<<=1; //temp를 2씩 곱함
            kmax++;
        }
        //15라면 3이될것
        parent=new int[kmax+1][N+1]; //4/16
        BFS(1); //2. 각 노드의 깊이 구하기
        for(int k=1; k<=kmax;k++){
            for(int n=1;n<=N;n++){
                parent[k][n] =parent[k-1][parent[k-1][n]]; //3. 점화식으로 parent배열 구하기
            }
        }
        int M= Integer.parseInt((br.readLine()));
        for(int i=0;i<M;i++){ //질문 받기
            StringTokenizer st =new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int LCA= excuteLCA(a,b);
            System.out.println(LCA);
        }
    }

    private static int excuteLCA(int a, int b) {
        if(depth[a] > depth[b]){ //앞이 큰수로 세팅
            int temp =a;
            a=b;
            b=temp;
        }
        for(int k=kmax; k >= 0 ; k--) { //높이 맞추기
            if(Math.pow(2,k) <= depth[b] - depth[a]){
                if(depth[a] <= depth[parent[k][b]]){
                    b = parent[k][b];
                }
            }
        }
        for(int k = kmax;k>=0;k--){ //같은 조상이 나올때까지 각 노드를 부모 노드로 변경
            if(parent[k][a]!=parent[k][b]){
                a=parent[k][a];
                b=parent[k][b];
            }
        }
        int LCA=a; //최소공통조상
        if(a!=b){
            LCA=parent[0][LCA];
        }
        return LCA;
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
                    parent[0][next] = now_node; //이전노드이기 때문에
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

