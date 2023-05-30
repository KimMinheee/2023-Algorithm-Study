package ch07_3_유클리드;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_1033_칵테일 {

    static ArrayList<cNode>[] A;
    static long lcm;
    static boolean visited[];
    static long D[];

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = sc.nextInt(); // 재료 개수
        A = new ArrayList[N]; // 인접 리스트
        visited = new boolean[N]; // dfs 탐색할 때 탐색 여부 저장할 배열
        D = new long[N]; // 각 노드값 저장할 배열
        lcm = 1; // 최소 공배수
        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<cNode>(); // 인접 리스트 배열에 엣지 정보 저장
        }
        for (int i = 0; i < N - 1; i++) { // 재료(엣지)개수 - 1
            int a = sc.nextInt(); // 인접 리스트 배열에 엣지 정보 저장
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            A[a].add(new cNode(b, p, q));
            A[b].add(new cNode(a, q, p));
            lcm *= (p * q / gcd(p, q));
        }
        D[0] = lcm;
        DFS(0);
        long mgcd = D[0];
        for(int i = 1; i < N; i++){
            mgcd =  gcd(mgcd, D[i]);
        }
        for(int i = 0; i < N; i++){
            System.out.print(D[i] / mgcd + " ");
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void DFS(int Node) {
        visited[Node] = true; //visited 배열에 현재 노드 방문 기록
        for (cNode i : A[Node]) {
            int next = i.getB();
            if (!visited[next]) {
                // 다음 노드값 = 현재 노드의 값 * 배율
                D[next] = D[Node] * i.getQ() / i.getP(); // 주어진 비율로 다음 노드값 갱신
                DFS(next);
            }
        }
    }
}

class cNode { // 노드 클래스 선언

    int b; // 다음 노드
    int p; // 비율 1
    int q; // 비율 2

    public cNode(int b, int p, int q) {
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
