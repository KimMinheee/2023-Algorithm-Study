import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int maxDist;
    static int farthestNode;

    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        tree = new ArrayList[V+1];
        visited = new boolean[V+1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i <= V; i++) {
            int vertex = scanner.nextInt();
            while (true) {
                int node = scanner.nextInt();
                if (node == -1) break;
                int weight = scanner.nextInt();
                tree[vertex].add(new Node(node, weight));
            }
        }

        maxDist = 0;
        DFS(1, 0);

        visited = new boolean[V+1];
        maxDist = 0;
        DFS(farthestNode, 0);

        System.out.println(maxDist);
        scanner.close();
    }

    static void DFS(int node, int weight) {
        visited[node] = true;
        if (weight > maxDist) {
            maxDist = weight;
            farthestNode = node;
        }
        for (Node next : tree[node]) {
            if (!visited[next.vertex]) {
                DFS(next.vertex, weight + next.weight);
            }
        }
    }
}
