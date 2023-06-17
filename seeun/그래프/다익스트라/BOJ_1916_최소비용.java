import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1916_최소비용 {

    static int n; //도시 수
    static private ArrayList<City>[] arr; //버스경로로 이어진 도시들 그래프 저장 리스트 배열
    static private int[] ans; //A도시에 대해 모든 도시까지의 최소비용 저장 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); //도시 수
        int m = Integer.parseInt(br.readLine()); //버스 수

        arr = new ArrayList[n + 1];
        ans = new int[n + 1];

        //리스트배열 초기화, 최소비용 배열 Integer최댓값으로 초기화
        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<>();
            ans[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            arr[start].add(new City(end, cost));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ACity = Integer.parseInt(st.nextToken()); //A도시
        int BCity = Integer.parseInt(st.nextToken()); //B도시

        if (ACity == BCity) {
            bw.write("0");
        }
        else{
            //A도시에 대해서 모든 도시까지의 최소비용 배열 구하기
            dijkstra(ACity);

            //최소비용 배열에서 B도시까지의 비용 출력
            bw.write(String.valueOf(ans[BCity]));
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void dijkstra(int A) {
        PriorityQueue<City> pq = new PriorityQueue<>((Comparator<City>) (o1, o2) -> o1.cost - o2.cost); //Comapartor 람다식, 비용이 최소인 버스부터 탐색

        boolean[] visited = new boolean[n + 1];
        pq.add(new City(A, 0)); //출발하는 A도시와 거리 0
        ans[A] = 0; //최소비용 배열 A도시에 대해서 저장

        while (!pq.isEmpty()) {
            City c = pq.poll();
            if (!visited[c.connCity]) {
                visited[c.connCity] = true;
                for (City next : arr[c.connCity]) {
                    if (ans[next.connCity] > ans[c.connCity] + next.cost) { //최소비용 업데이트 될 때만 큐에 넣기
                        ans[next.connCity] = ans[c.connCity] + next.cost;
                        pq.add(new City(next.connCity, ans[next.connCity])); //갱신된 비용으로 이어진 도시 큐에 넣기
                    }
                }
            }

        }
    }

    static private class City{
        int connCity;
        int cost;

        public City(int connCity, int cost) {
            this.connCity = connCity;
            this.cost = cost;
        }
    }
}
