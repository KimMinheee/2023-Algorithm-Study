import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197 {//[BOJ_1197]최소신장트리 jaehwan solved - 우선순위 큐 사용
    static int[] parent;
    static PriorityQueue<pEdge> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        queue = new PriorityQueue<>();
        parent = new int[N + 1];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int v = sc.nextInt();
            queue.add(new pEdge(s, e, v));
        }
        int useEdge = 0;//사용한 에지
        int result = 0;//결과
        while (useEdge < N - 1) { //n-1번 만큼 반복
            pEdge now = queue.poll();
            if (find(now.s) != find(now.e)) {//시작 노드 대표값과 도착노드 대표값 비교
                union(now.s, now.e);//다르면 합침
                result = result + now.v;//결과값에 가중치 더해줌
                useEdge++;
            }
        }
        System.out.println(result); //출력
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }

    public static int find(int a) {//속한 집합의 대표 노드 반환
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]); //값이 대표값과 다르면 바꿔주고 반환
    }
}
class pEdge implements Comparable<pEdge> {
    int s;
    int e;
    int v;

    pEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(pEdge o) {
        // TODO Auto-generated method stub
        return this.v - o.v;
    }
}
