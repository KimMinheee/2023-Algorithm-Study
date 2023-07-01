package haein.그래프.최소신장트리;

import java.util.*;
import java.io.*;

public class 트리의부모찾기 {
    static ArrayList<Integer>[] adjList;
    static int[] parents;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        bfs();

        for (int i = 2; i <= N; i++) {
            System.out.println(parents[i]);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int node : adjList[current]) {
                if (!visited[node]) {
                    parents[node] = current;
                    visited[node] = true;
                    queue.add(node);
                }
            }
        }
    }
}
