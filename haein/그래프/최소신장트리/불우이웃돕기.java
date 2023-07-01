package haein.그래프.최소신장트리;

import java.io.*;
import java.util.*;

public class 불우이웃돕기 {
    static final int MAX_VALUE = 987654321;
    static int[][] graph;
    static boolean[] visited;
    static int[] minEdge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N];
        minEdge = new int[N];
        Arrays.fill(minEdge, MAX_VALUE);

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) != '0') {
                    int length = line.charAt(j) >= 'a' ? line.charAt(j) - 'a' + 1 : line.charAt(j) - 'A' + 27;
                    graph[i][j] = length;
                }
            }
        }

        minEdge[0] = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            int minIndex = -1;
            int minValue = MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && minEdge[j] < minValue) {
                    minIndex = j;
                    minValue = minEdge[j];
                }
            }
            if (minIndex == -1) {
                System.out.println(-1);
                return;
            }
            visited[minIndex] = true;
            result += minValue;
            for (int j = 0; j < N; j++) {
                if (!visited[j] && graph[minIndex][j] != 0 && graph[minIndex][j] < minEdge[j]) {
                    minEdge[j] = graph[minIndex][j];
                }
            }
        }

        System.out.println(result);
    }
}
