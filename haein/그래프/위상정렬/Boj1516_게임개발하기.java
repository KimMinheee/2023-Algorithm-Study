package haein.그래프.위상정렬;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Boj1516_게임개발하기 {

        static int N;
        static int[] time, result, degree;
        static List<Integer>[] list;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(br.readLine());
            time = new int[N + 1];
            result = new int[N + 1];
            degree = new int[N + 1];
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                time[i] = Integer.parseInt(st.nextToken());
                while (true) {
                    int num = Integer.parseInt(st.nextToken());
                    if (num == -1) break;
                    list[num].add(i);
                    degree[i]++;
                }
            }

            topologicalSort();
        }

        public static void topologicalSort() {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                    result[i] = time[i];
                }
            }

            while (!queue.isEmpty()) {
                int current = queue.poll();
                for (int next : list[current]) {
                    result[next] = Math.max(result[next], result[current] + time[next]);
                    degree[next]--;
                    if (degree[next] == 0) queue.add(next);
                }
            }

            for (int i = 1; i <= N; i++) System.out.println(result[i]);
        }
    }

}
