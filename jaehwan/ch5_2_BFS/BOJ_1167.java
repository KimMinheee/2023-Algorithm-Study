import java.util.*;

public class Main { //트리의 지름구하기
    static boolean visited[];
    static int[] distance;
    static ArrayList<Edge_1677>[] A;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<Edge_1677>();
        }
        for (int i = 0; i < N; i++) {
            int S = sc.nextInt();
            while (true) {
                int E = sc.nextInt();
                if (E == -1) {
                    break;
                }
                int V = sc.nextInt();
                A[S].add(new Edge_1677(E, V));
            }
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(1);
        int Max = 1;
        for (int i = 2; i <= N; i++) {
            if (distance[Max] < distance[i])
                Max = i;
        }
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        BFS(Max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }
    private static void BFS(int index) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);
        visited[index] = true;
        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            for (Edge_1677 i : A[now_node]) {
                int e = i.e;
                int v = i.value;
                if (!visited[e]) {
                    visited[e] = true;
                    queue.add(e);
                    distance[e] = distance[now_node] + v;
                }
            }
        }
    }
}
class Edge_1677 {
    int e;
    int value;
    public Edge_1677(int e, int value) {
        this.e = e;
        this.value = value;
    }
}
/*
문제해설 
트리 = 싸이클이 없다 =단일 노선이다
노드사이의 가장 긴거리를 찾는 아이디어를 찾는게 중요한 문제
아이디어:모든 임의의 노드에서 가장 긴 경로로 연결된 노드는 트리의 지름에 해당하는 두 노드 중 하나이다.
시작점에서 최장거리노드로 간다음 그 노드를 기준으로 다시 BFS를 시행하면 위에서 언급한 단일 노선과 가장 긴 에지를 가지는 노드가 포함되는걸 찾게되므로 두번 시행하는 방법을 알아내는게 중요하다.
*/
