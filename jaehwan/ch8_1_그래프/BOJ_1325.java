import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1325 {
    static int N,M; //노드,에지
    static boolean visited[];//방문배열
    static int answer[];//정답 배열
    static ArrayList<Integer> A[]; //그래프 데이터 저장 인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        A=new ArrayList[N+1];
        answer =new int[N+1];
        for(int i=1;i<=N;i++){ //초기화
            A[i]=new ArrayList<>();
        }
        for(int i =0;i<M;i++){ //그래프 데이터 저장
            st=new StringTokenizer(br.readLine());
            int S=Integer.parseInt(st.nextToken());
            int E=Integer.parseInt(st.nextToken());
            A[S].add(E);
        }
        for(int i=1;i<=N;i++){ //방문배열 돌며
            visited =new boolean[N+1];//생성 초기화
            BFS(i);//BFS 실행
        }
        int maxVal=0;
        for(int i=1;i<=N;i++){
            maxVal=Math.max(maxVal,answer[i]);
        }
        for(int i=1;i<=N;i++){
            if(answer[i]==maxVal){System.out.print(i+" "); }
        }
    }
    public static void BFS(int index){
        Queue<Integer> queue=new LinkedList<Integer>();
        queue.add(index);
        visited[index]=true;
        while(!queue.isEmpty()){
            int now_Node=queue.poll();
            for(int i:A[now_Node]){
                if(visited[i]==false){
                    visited[i]=true;
                    answer[i]++;
                    queue.add(i);
                }
            }
        }
    }
}
/*
해킹을 했을때 가장 깊게 이어지는 노드를 찾는 문제 
*/
