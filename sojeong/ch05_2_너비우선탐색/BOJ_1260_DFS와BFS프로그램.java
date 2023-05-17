package ch05_2_너비우선탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_1260_DFS와BFS프로그램 {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(); // 노드 개수
        int M = scan.nextInt(); // 엣지 개수
        int Start = scan.nextInt(); // 시작점

        arr = new ArrayList[N + 1]; // 인덱스는 0부터 시작하니까 1로 변경해주기
        for (int i =1;i<=N; i++) {
            arr[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            arr[a].add(b);
            arr[b].add(a); // 양방향 엣지 이어주기
        }
        //노드 오름차순 정렬
        for (int i = 1; i < N; i++) {
            Collections.sort(arr[i]);
        }
        visited = new boolean[N + 1]; //방문 배열 초기화
        dfs(Start);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(Start);
        System.out.println();
    }

    public static void dfs(int Node) { // 깊이우선탐색 구현
        System.out.print(Node + " ");
        visited[Node] = true;
        for (int i:arr[Node]){
            if(!visited[i]){
                dfs(i); // 재귀로 구현
            }
        }
    }

    public static void bfs(int Node){
        Queue<Integer> q = new LinkedList<Integer>();// 전역변수로 생성하면 메모리 차지하니까 지역변수로 함수 내부에 만드는게 나음
        q.add(Node); // queue에 시작노드 추가
        visited[Node] = true;

        while(!q.isEmpty()){
            int now_Node = q.poll();
            System.out.print(now_Node+" ");
            for(int i:arr[now_Node]){
                if(!visited[i]){
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}