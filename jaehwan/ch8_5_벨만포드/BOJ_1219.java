import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1219 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());  // 노드의 수
        int SC = Integer.parseInt(stk.nextToken()); // 시작도시
        int EC = Integer.parseInt(stk.nextToken()); // 도착 도시
        int M = Integer.parseInt(stk.nextToken());  // 에지의 수
        edges = new Edge[M + 1];
        long[] dist = new long[N + 1];
        long [] money = new long[N+1];
        for (int i = 0; i < M; i++) { //에지 리스트에 데이터 담기
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            edges[i] = new Edge(a, b, w);
        }
        stk = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            money[i] = Integer.parseInt(stk.nextToken());
        }

        // 벨만 포드 알고리즘
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[SC] = money[SC];

        for(int i = 0 ; i <= N+100; i++){ //양수 사이클을 위해서 여유롭게 돌리기 21 부터 정답인거 확인
            for(int j = 0 ; j < M; j++){ //모든 에지에 대해서 반복
                Edge now_edge = edges[j];
                if(dist[now_edge.st]==Long.MIN_VALUE) //방문전이면 패스
                    continue;
                else if(dist[now_edge.st]==Long.MAX_VALUE){//출발 노드가 양수 사이클에 연결된 노드라면 종료 노드도 연결 노드로 업데이트
                    dist[now_edge.end] = Long.MAX_VALUE;
                }
                //더 많은 돈을 벌 수 있는 새로운 경로가 발견됐을때 새로운 경로값으로 업데이트
                //도착 도시값 < 시작 도시값 + 도착 도시값 - 에지 가중치
                else if(dist[now_edge.end] < dist[now_edge.st]+money[now_edge.end]-now_edge.cost){
                    dist[now_edge.end] = dist[now_edge.st]+money[now_edge.end]-now_edge.cost;
                    if(i>=N) //사이클이 생기면 어차피 무수히 많이 돔
                        dist[now_edge.end] = Long.MAX_VALUE;
                }
            }
        }
        if(dist[EC] == Long.MIN_VALUE)
            bw.write("gg\n");
        else if(dist[EC] == Long.MAX_VALUE)
            bw.write("Gee\n");
        else bw.write(dist[EC]+"\n");
        bw.flush();
        bw.close();
    }

    static class Edge {
        int st;
        int end;
        int cost;

        public Edge(int s, int e, int c) {
            this.st = s;
            this.end = e;
            this.cost = c;
        }
    }
}
/*
최던거리가 아닌 최대 거리를 구하는 문제
오민식이 벌 수 있는 돈이 무한대 = 양의 사이클 Gee

하지만 출발 노드와 도착노드 사이에 양의 사이클이 없다면 양의 사이클로 가지 않는다
https://usedto-wonderwhy.tistory.com/entry/%EB%B0%B1%EC%A4%80-1219-%EC%98%A4%EB%AF%BC%EC%8B%9D%EC%9D%98-%EA%B3%A0%EB%AF%BC-JAVA 참고
* */
