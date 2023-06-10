package ch08_1_그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프판별 {

    static ArrayList<Integer>[] arr;
    static int[] check;
    static boolean[] visited;
    static boolean IsBipa;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        for (int t = 0; t < testCase; t++)// 주어진 테스트 케이스만큼 돌리기
        {
            String[] s = br.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            arr = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsBipa = true; // 이분그래프 true로 초기화
            for (int i = 1; i <= V; i++) {
                arr[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < E; i++) { // 엣지 데이터 저장하기
                s = br.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                arr[start].add(end);
                arr[end].add(start);
            }
            for (int i = 1; i < V; i++) { // 모든 노드에서 dfs실행
                if (IsBipa) {
                    dfs(i);
                }
                break;
            }
            if (IsBipa) {
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
    private static void dfs(int start) {
        visited[start] = true;
        // 인접리스트로 받아서 start에서 연결된 모든 노드를 탐색
        for(int i: arr[start]){
            if(!visited[i]){
                //바로 직전에 있는 노드와 다른 집합으로 분류 해주는 것이 필요
                check[i] = (check[start] +1) % 2;
                dfs(i);
            }
            else if(check[start] == check[i]){
                IsBipa = false;
            }
        }
    }
}
