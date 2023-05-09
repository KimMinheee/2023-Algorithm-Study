package ch05_1_탐색;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1167_트리의지름구하기 {

    static boolean visit[];
    static List<Point>[] list;
    static int max = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        list = new List[V + 1];
        visit = new boolean[V + 1];
        for (int i = 0; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < V + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nn = Integer.parseInt(st.nextToken());
            while (true) {
                int n = Integer.parseInt(st.nextToken());
                if (n == -1) {
                    break;
                }
                list[nn].add(new Point(n, Integer.parseInt(st.nextToken())));
            }
        }
        visit[1] = true;
        dfs(1);
        System.out.println(max);
    }

    static int dfs(int num) {
        int val = 0;
        int secVal = 0;
        for (Point p : list[num]) {
            if (visit[p.x]) {
                continue;
            }
            visit[p.x] = true;
            int dVal = dfs(p.x) + p.y;
            if (val < dVal) {
                secVal = val;
                val = dVal;
            } else if (secVal < dVal) {
                secVal = dVal;
            }
        }

        max = Math.max(max, val + secVal);
        return val;
    }
}