import java.util.*;

public class BOJ_13023 {
    static boolean visited[];//방문 기록
    static ArrayList<Integer>[] A;
    static boolean arrive; //도착 확인할 변수
    public static void main(String[] args) {
        int N;//노드
        int M;//에지
        arrive = false;//정답 1/0
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        M = scan.nextInt();
        A = new ArrayList[N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {//인접 리스트 초기화
            A[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int S = scan.nextInt();
            int E = scan.nextInt();
            A[S].add(E);//방향성 없는 에지이므로 양방향으로 추가
            A[E].add(S);
        }
        for (int i = 0; i < N; i++) {
            DFS(i, 1);
            if (arrive)
                break;
        }
        if (arrive)
            System.out.println("1");
        else
            System.out.println("0");
    }

    public static void DFS(int now, int depth) { //DFS 재귀로 구현
        if (depth == 5 || arrive) { //깊이가 5면 자동 종료
            arrive = true;
            return;
        }
        visited[now] = true; //방문 노드 추가
        for (int i : A[now]) {
            if (!visited[i]) {
                DFS(i, depth + 1); //재귀 호출이 될때마다 1추가 총 5까지
            }
        }
        visited[now] = false;
    }
}
/*
문제해설 
주어진 친구 관계의 해석이 5개가 나란히 이어지는것이다. 주어진 조건에서 5칸이 이어지는 경우가 있는지를 찾는 문제

문제풀이
DFS로 모든 노드를 탐색하며 최대 5개가 까지 탐색하는 DFS가 있는지 찾는다. 시간복잡도는 크게 고려하지 않아도 된다.
*/
