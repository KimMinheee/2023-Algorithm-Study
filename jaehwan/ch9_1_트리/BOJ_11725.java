import java.util.*;

public class BOJ_11725 { //[BOJ_11725]트리의부모찾기 jaehwan solved - dfs 사용
    static int N;
    static boolean[] visit;
    static ArrayList<Integer>[] tree;
    static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        visit = new boolean[N + 1];
        tree = new ArrayList[N + 1];
        answer = new int[N + 1];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>(); //인접리스트 초기화
        }
        for (int i = 1; i < N; i++) {
            int n1 = sc.nextInt(); 
            int n2 = sc.nextInt();
            tree[n1].add(n2); //양방향 데이터 저장
            tree[n2].add(n1);
        }
        DFS(1);
        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }
    static void DFS(int number) {
        visit[number] = true;
        for (int i : tree[number]) {
            if (!visit[i]) {
                answer[i] = number;
                DFS(i);
            }
        }
    }
}

/*
인접리스트를 만들고 1부터 DFS를 돌린다
*/
