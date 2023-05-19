package ch05_1_탐색;

import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_13023_친구관계파악하기 {

    static int n;
    static ArrayList<Integer>[] list;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list[a].add(b);
            list[b].add(a);
        }

        for(int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i, 0);
        }
        System.out.println(0);
    }

    public static void dfs(int x, int len) {
        if(len == 4) {
            System.out.println(1);
            System.exit(0);
        }

        visited[x] = true;
        for(int i = 0; i < list[x].size(); i++) {
            int temp = list[x].get(i);
            if(visited[temp] == false) {
                visited[temp] = true;
                dfs(temp, len + 1);
                visited[temp] = false;
            }
        }
    }
}
