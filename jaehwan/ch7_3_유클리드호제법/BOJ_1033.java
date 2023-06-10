import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.*;

public class BOJ_1033 {
    static long lcm;//최소공배수
    static long[] D;//각 노드값 저장배열
    static ArrayList<Node>[] A; //인접리스트
    static boolean[] visited; //방문여부 저장

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();//재료 개수
        A = new ArrayList[n];
        visited = new boolean[n];
        D = new long[n];
        lcm = 1;
        for (int i = 0; i < n; i++) { //인접리스트 초기화
            A[i] = new ArrayList<Node>();
        }
        for (int i = 0; i < n - 1; i++) { //재료 입력
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new Node(b, p, q)); //
            A[b].add(new Node(a, q, p)); //
            lcm *= (p * q / gcd(p, q)); //최소공배수 업데이트 a,b의 최소공배수 = a * b / 최대 공약수
        }
        // 4/0 = 1/1
        // 4/1 = 3/1
        // 4/2 = 5/1
        // 4/3 = 7/1
        //105 35 21 15 105
        D[0] = lcm; //처음은 최소 공배수
        DFS(0);
        long mgcd = D[0]; //최소공배수
        for (int i = 1; i < n; i++) {
            mgcd = gcd(mgcd, D[i]); //각 최소공배수 업데이트
        }
        for (int i = 0; i < n; i++) {
            System.out.print(D[i] / mgcd + " "); //각 값 출력
        }
    }
    public static long gcd(long a, long b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }
    public static void DFS(int node) { //각 노드 방문후
        visited[node] = true; //처음 방문체크
        for (Node i : A[node]) {
            int next = i.getB();
            if (!visited[next]) {//방문한적 없다면 D배열 업데이트
                D[next] = D[node] * i.getQ() / i.getP();
                DFS(next);
            }
        }
    }
}
class Node {
    int b;
    int p;
    int q;

    public Node(int b, int p, int q) {//b는 다음 노드의 번호, p는 분자, q는 분모
        super();
        this.b = b;
        this.p = p;
        this.q = q;
    }

    public int getB() {
        return b;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }
}
/*
문제 해설
N개의 재료, N-1개의 레시피 이들을 조합해서 N개의 재료의 질량비를 알아내는 문제이다.

문제 풀이
재료들을 연결하면 TREE구조,각 재료를 NODE 각 레시피를 EDGE라고 볼 수 있다.
TREE의 점 하나를 찍고 그 점을 임시로 전체 레시피의 최소 공배수를 넣음 그점부터 시작해 재료간의 질량비를 이용해 전체 질량비를 구함
* */
