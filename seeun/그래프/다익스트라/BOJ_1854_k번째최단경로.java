import java.io.*;
import java.util.*;

public class BOJ_1854_k번째최단경로 {

    static int n; //도시 개수
    static ArrayList<City>[] arr;
    static PriorityQueue<Integer>[] dis; //출발 도시부터 각 도시까지의 여러 루트들 저장, 적은순서 유지하는 우선순위큐

    static int k; //k번째 최단경로 찾기

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); //도로 개수
        k = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n + 1];
        dis = new PriorityQueue[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = new ArrayList<City>();
        }
        for (int i = 0; i <= n; i++) {
            dis[i] = new PriorityQueue<>(k, (o1, o2) -> o2 - o1); //내림차순으로 정렬해서 우선순위큐의 앞에 가장 큰값인 k번째 최소비용을 가지도록
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            arr[start].add(new City(end, time));
        }

        findKDis();

        for (int i = 1; i <= n; i++) {
            if(dis[i].size() == k)
                bw.write(dis[i].peek() + "\n");
            else{
                bw.write("-1\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static private void findKDis() {
        PriorityQueue<City> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time); //오른차순 정렬, 작은 시간인 도로를 먼저 탐색하도록
        pq.add(new City(1, 0));
        dis[1].add(0); //1까지오는데 최소시간 0 먼저 저장

        while (!pq.isEmpty()) {
            City c = pq.poll();
            if (arr[c.connCity].size() == 0) { //갈 도로가 없는 경우 탐색 끝
                continue;
            }
            for (City next : arr[c.connCity]) {
                //더 최단경로인지 판별하지 않고 모든 값을 저장
//                System.out.println(c.connCity + " - " + next.connCity + " -> " + (c.time + next.time));
                //k까지 저장되지 않았으면 그냥 저장
                if (dis[next.connCity].size() < k ) {
                    dis[next.connCity].add(c.time + next.time);
                    pq.add(new City(next.connCity, c.time + next.time));
                }
                //k개 저장되어있을 때 가장 마지막값(가장 큰값)보다 작은 값일 경우 마지막값 빼주고 넣어주기
                else if(dis[next.connCity].peek() > c.time + next.time){
                    dis[next.connCity].poll();
                    dis[next.connCity].add(c.time + next.time); //이전까지 비용 + 현재 도로 비용을 dis배열 현재도시 인덱스에 add
                    pq.add(new City(next.connCity, c.time + next.time));
                }
            }
        }
    }

    static private class City {
        int connCity;
        int time;

        public City(int connCity, int time) {
            this.connCity = connCity;
            this.time = time;
        }
    }
    
}
