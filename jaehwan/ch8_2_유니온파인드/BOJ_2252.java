import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2252 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();//인접리스트
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1]; //진입차수배열
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            // A에서 인덱스 S에 해당하는 리스트를 반환
            //add(E)를 호출하여 E를 해당 리스트에 추가하게 되면, S에서 E로 가는 간선 정보가 추가
            A.get(S).add(E);// S에서 E로 향하는 간선이 있다는것
            indegree[E]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {//진입 차수가 0인 노드들을 큐에 저장
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int next : A.get(now)) {//현재 노드에서 갈 수 있는 노드의 개수
                indegree[next]--; //해당 노드가 가리키는 노드의 진입차수를 1씩 빼준다
                if (indegree[next] == 0) {//만약 감소했을때 진입차수가 0이 되면 노드를 큐에 넣는다
                    queue.offer(next);
                }
            }
        }
    }
}
/*
위상정렬이라는것을 알아차리는게 중요한 문제이다.
*/
