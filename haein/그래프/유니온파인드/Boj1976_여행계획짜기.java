package haein.그래프.유니온파인드;
import java.util.*;
public class Boj1976_여행계획짜기 {
    public static int[] parent;

    // Find 연산
    public static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    // Union 연산
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y)
            parent[y] = x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int temp = sc.nextInt();
                if (temp == 1)
                    union(i, j);
            }
        }

        int[] plan = new int[M];
        for (int i = 0; i < M; i++)
            plan[i] = sc.nextInt();

        boolean flag = true;
        for (int i = 0; i < M - 1; i++) {
            if (find(plan[i]) != find(plan[i + 1])) {
                flag = false;
                break;
            }
        }

        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");

        sc.close();
    }

}
