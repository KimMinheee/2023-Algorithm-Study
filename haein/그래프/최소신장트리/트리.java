package haein.그래프.최소신장트리;

import java.util.*;

public class 트리 {
    static int N, removeNode, leafCnt;
    static int[] parent;
    static ArrayList<Integer>[] childList;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N];
        childList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            childList[i] = new ArrayList<>();
        }

        int root = 0;
        for (int i = 0; i < N; i++) {
            parent[i] = sc.nextInt();
            if (parent[i] == -1) {
                root = i;
            } else {
                childList[parent[i]].add(i);
            }
        }

        removeNode = sc.nextInt();
        if (removeNode == root) {
            System.out.println(0);
            return;
        }
        removeNode(removeNode);
        dfs(root);

        System.out.println(leafCnt);
    }

    static void removeNode(int node) {
        childList[node].clear();
        if (parent[node] != -1) {
            childList[parent[node]].remove((Integer) node);
        }
    }

    static void dfs(int node) {
        if (node == removeNode) return;
        if (childList[node].isEmpty()) {
            leafCnt++;
            return;
        }

        for (int next : childList[node]) {
            dfs(next);
        }
    }
}
