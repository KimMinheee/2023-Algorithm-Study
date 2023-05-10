import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11724 {//DFS 파트: 연결요소의 개수 구하기
    static ArrayList<Integer>[] A;//그래프 저장할 인접리스트 한줄마다 리스트가 된다.
    static boolean visited[];

    public static void main(String[] args) throws IOException {
    //노드 개수 , 에지 개수에 그래프 데이터까지 받아야함 버퍼드
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); //버퍼드 짝꿍
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        visited=new boolean[n+1]; //0번 인덱스 빼기
        A=new ArrayList[n+1]; //실제 모든 객체를 선언한건 아님 일자 1칸만 선언해준거임
        for(int i=1;i<n+1;i++){
            A[i]=new ArrayList<Integer>();//이렇게 해야 줄마다 ArrayList가 생김(초기화)
        }
        for(int i=0;i<m;i++){//인점 리스트에 그래프 데이터 저장하기(엣지만큼반복 엣지 정보를 인접리스트로)
            st=new StringTokenizer(br.readLine());
            int s=Integer.parseInt(st.nextToken());
            int e=Integer.parseInt(st.nextToken());
            A[s].add(e);//시작점에서 종료점으로
            A[e].add(s);//종료점에서 시작점으로 (양방향)
        }
        int count=0;// DFS 반복회수
        for(int i=1;i<n+1;i++){
            if(!visited[i]){//방문하지 않은 노드라면
                count++;//연결요소 개수 ++
                DFS(i); //현재있는 노드(방문하지 않은 노드)에서 시작
            }
        }
        System.out.println(count);
    }

    static void DFS(int v) {
        if(visited[v]){
            return;
        }
        //방문노드아니면
        visited[v]=true;
        for(int i : A[v]){//현재 노드에서 연결되어 있는 모든 노드 찾기
            if(visited[i]==false){ //노드 찾다가 처음 방문하는 노드를 찾으면 그 친구 기준으로
                DFS(i); //다시 실행
            }
        }
    }
}
/*
* 문제 해설
* 방향이 없는 그래프가 주어졌을때 연결요소를 구하라 = 에지로 이어져있는 노드의 덩어리 개수를 구하여라
*
* 문제 풀이
* 하나의 노드에서 연결된 모든 노드의 탐색이 필요하다 -> 트리완전탐색이 필요하다 -> 대표적인 개념이 DFS이다.
* 하나의 DFS탐색이 끝나면 하나의 덩어리가 끝난것이고 모든 노드를 방문했을때 시행된 DFS의 개수가 곧 정답이다.
* */
