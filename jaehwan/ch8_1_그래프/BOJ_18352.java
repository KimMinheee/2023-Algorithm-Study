import java.util.*;

public class BOJ_18352 {
    static int visited[]; //방문거리 저장 배열
    static ArrayList<Integer>[] A; //그래프 데이터 저장 인접리스트
    static int N,M,K,X; //노드,에지,목표거리,시작점
    static List<Integer> answer; //정답리스트
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        N=sc.nextInt();
        M=sc.nextInt();
        K=sc.nextInt();
        X=sc.nextInt();
        A=new ArrayList[N+1];
        answer=new ArrayList<>();
        for(int i=1; i<=N;i++){
            A[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<M;i++){
            int S= sc.nextInt();
            int E= sc.nextInt();
            A[S].add(E); //인접리스트에 그래프 데이터 저장
        }
        visited=new int[N+1];
        for(int i=0;i<=N;i++){
            visited[i]=-1;
        }
        BFS(X);//주어진 시작점 기준으로 실행돌림
        for(int i=0;i<=N;i++){
            if(visited[i]==K){
                answer.add(i);
            }
        }
        if(answer.isEmpty()){ //비었으면 -1
            System.out.println("-1");
        }
        else{ //하나라도 있으면 오름차순 정렬후 출력
            Collections.sort(answer);
            for(int temp:answer){
                System.out.println(temp);
            }
        }
    }
    private static void BFS(int Node){
        Queue<Integer> queue =new LinkedList<Integer>(); //큐선언
        queue.add(Node);//출발노드 더해줌
        visited[Node]++;//방문한 자리수 배열 ++
        while(!queue.isEmpty()){ //큐가 빌때까지
            int now_Node=queue.poll();//큐에서 노드 데이터를 가져옴
            for(int i: A[now_Node]){
                if (visited[i]==-1){ //방문하지 않은 노드
                    queue.add(i);//큐에 데이터 삽입
                    visited[i]=visited[now_Node]+1; //방문거리를 기록하는데 잊너 노드의 방문거리 +1로 기록한다
                }
            }
        }
    }
}

/*
문제해설
단방향 도로, 모든거리 1, 주어진 시작점에서 주어진 거리만큼 떨어진 거리의 노드를 찾는 문제

문제풀이 
인접리스트로 가중치 없는 인접리스트를 구성한다 이후 주어진 시작점을 기준으로 BFS를 시작하는데 방문 배열에 각도시로 가는 최단거리를 입력한다.

*/
