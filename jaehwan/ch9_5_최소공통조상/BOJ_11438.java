import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11438 {//[B0J_11438]최소공통조상2 jaehwan solving
    static ArrayList<Integer>[] tree;
    static int[] depth;
    static int kmax; //k최대값
    static int[][] parent; //부모 노드
    static boolean[] visited;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N=Integer.parseInt(br.readLine());
        tree=new ArrayList[N+1];
        for(int i=1;i<=N; i++){
            tree[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<=N-1;i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            tree[s].add(e);
            tree[e].add(s);
        }
        depth=new int[N+1];
        visited =new boolean[N+1];
        //N이 노드의 개수

        int temp=1;
        kmax=0;
        while (temp<=N) { //kmax 구하는 방법
            temp<<=1; //temp를 2씩 곱함
            kmax++;
        }
        parent=new int[kmax+1][N+1];
        BFS(1);
    }
}
