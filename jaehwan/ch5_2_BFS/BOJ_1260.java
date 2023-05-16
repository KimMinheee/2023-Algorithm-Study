import java.util.*;

public class BOJ_1260 {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Start=sc.nextInt(); //처음에 입력 받는 3가지
        A = new ArrayList[N+1];
        for(int i=1;i<=N; i++){
            A[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            int S = sc.nextInt();
            int E = sc.nextInt();
            A[S].add(E);
            A[E].add(S);
        }
        for(int i=1;i<=N;i++){
            Collections.sort(A[i]); //번호가 작을것을 먼저 방문하기 위해 정렬
        }
        visited =new boolean[N+1];
        DFS(Start);
        System.out.println();
        visited=new boolean[N+1];
        BFS(Start);
        System.out.println();
    }

    public static void BFS(int N) {
        Queue<Integer> queue= new LinkedList<Integer>();
        queue.add(N);
        visited[N]=true;
        while (!queue.isEmpty()){
            int now_Node=queue.poll();
            System.out.print(now_Node + " ");
            for(int i:A[now_Node]){
                if(!visited[i]){
                    visited[i]=true;
                    queue.add(i);
                }
            }
        }
    }

    public static void DFS(int N){
        System.out.print(N +" ");
        visited[N]=true;
        for(int i:A[N]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
     
}
/*
문제 풀이
노드 개수, 에지 개수 ,시작점으로 DFS,BFS탐색 결과를 출력하는 문제
 */
