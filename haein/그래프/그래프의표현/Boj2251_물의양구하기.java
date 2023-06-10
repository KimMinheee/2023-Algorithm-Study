package haein.그래프.그래프의표현;
//BFS

import java.util.*;
public class Boj2251_물의양구하기 {
    static int A, B, C;
    static boolean[][] check = new boolean[201][201];
    static boolean[] ans = new boolean[201];

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, C});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int a = now[0], b = now[1], c = now[2];

            if (check[a][b]) continue;
            check[a][b] = true;

            if (a == 0) ans[c] = true;

            // a->b
            if (a + b > B) queue.add(new int[]{a+b-B, B, c});
            else queue.add(new int[]{0, a+b, c});

            // a->c
            if (a + c > C) queue.add(new int[]{a+c-C, b, C});
            else queue.add(new int[]{0, b, a+c});

            // b->a
            if (a + b > A) queue.add(new int[]{A, a+b-A, c});
            else queue.add(new int[]{a+b, 0, c});

            // b->c
            if (b + c > C) queue.add(new int[]{a, b+c-C, C});
            else queue.add(new int[]{a, 0, b+c});

            // c->a
            if (a + c > A) queue.add(new int[]{A, b, a+c-A});
            else queue.add(new int[]{a+c, b, 0});

            // c->b
            if (b + c > B) queue.add(new int[]{a, B, b+c-B});
            else queue.add(new int[]{a, b+c, 0});
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();

        bfs();

        for (int i = 0; i <= C; i++) {
            if (ans[i]) System.out.print(i + " ");
        }
    }

}
