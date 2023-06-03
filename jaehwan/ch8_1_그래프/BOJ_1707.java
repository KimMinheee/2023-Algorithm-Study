import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1707 {

    static ArrayList<Integer>[] A; //인접리스트 가중치x
    static int[] check;
    static boolean visited[];
    static boolean IsEven; //정답출력

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int testCase=Integer.parseInt(br.readLine());
        for(int i=0;i<testCase;i++){//주어진 테스트 케이스만큼
            String[] s= br.readLine().split(" ");
            int V=Integer.parseInt(s[0]); //노드
            int E=Integer.parseInt(s[1]);//에지
            A=new ArrayList[V+1]; //노드에서 1부터 V까지라함
            visited =new boolean[V+1];
            check=new int[V+1];
            IsEven =true;
            for(int j=1;j<=V;j++){
                A[j]=new ArrayList<Integer>();
            }
            //에지 데이터 저장
            for(int h=0;h<E;h++){ //A 인접 리스트에 그래프 저장
                s=br.readLine().split(" ");
                int Start=Integer.parseInt(s[0]);
                int End = Integer.parseInt(s[1]);
                A[Start].add(End); //방향성이 없으니 양쪽 가능
                A[End].add(Start);
            }
            //모든 노드에서 DFS를 실행해야함 WHY? 그래프가 이어져 있다는 보장이 없음
            for(int h=1;h<=V;h++){ //모든 노드에서 실행
                if(IsEven){ DFS(h); }
                else{break;}
            }
            if(IsEven)System.out.println("YES");
            else{System.out.println("NO");}
        }
    }
    public static void DFS(int node){ //시작점 노드 받음
        visited[node]=true;
        for(int i:A[node]){//시작점에서 연결된 모든 노드 탐색
            //인접한 노드는 같은 집합이 아니므로 이전 노드와 다른 집합으로 처리
            if(!visited[i]){
                check[i]=(check[node]+1)%2; //그 바로 직전에 있는 노드와 다른 집합으로 분류함
                //바로전에 있던 노드+1 나머지 나누기 0,1 로 나누기 위해서 이렇게 사용
                DFS(i);
            }
            //이미 바문한 노드가 현재 내 노드와 같은 집합이면 이분 그래프가 아님.
            else if(check[node]==check[i]){
                IsEven=false; //
            }
        }
    }
}
