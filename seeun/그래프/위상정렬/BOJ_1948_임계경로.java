import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1948_임계경로 {

    static int n;
    static ArrayList<Edge>[] arr;
    static ArrayList<Edge>[] Rarr;

    static int[] pass;
    static boolean[] visited;
    static int roadCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine()); //도시 개수
        int m = Integer.parseInt(br.readLine()); //도로 개수

        arr = new ArrayList[n + 1]; //위상정렬용 리스트 배열
        Rarr = new ArrayList[n + 1]; //백트래킹용 리스트 배열
        pass = new int[n + 1]; //진입차수
        visited = new boolean[n + 1]; //방문 여부 저장 배열

        //리스트 배열들 초기화
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>();
            Rarr[i] = new ArrayList<>();
        }

        //도로 개수만큼 그래프 정보 입력 받기
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            arr[start].add(new Edge(start, end, time)); //이어진 도시들 리스트에 추가
            Rarr[end].add(new Edge(end, start, time)); //백트래킹용
            pass[end]++; //진입차수 + 1

        }

        //시작도시, 도착도시 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());

        int maxDis = solution(startCity, endCity);

        bw.write(maxDis + "\n" + roadCnt);
        bw.flush();
        br.close();
        bw.close();
    }

    //위상정렬로 시작도시부터 도착도시까지 최장거리를 구하고
    //백트래킹으로 최장거리 루트들의 모든 도로 수를 중복없이 구하는 함수
    public static int solution(int startCity, int endCity){

        //위상정렬로 최대시간 찾기
        Queue<Integer> q = new LinkedList<>();
        int[] dis = new int[n + 1];

        q.add(startCity);

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < arr[c].size(); i++) {
                Edge rq = arr[c].get(i);
                pass[rq.end]--; //진입차수 - 1
                //진입차수 0이고 아직 방문 안한 도로일 경우
                if (pass[rq.end] == 0 && !visited[rq.end]) {
                    q.add(rq.end); //이어진 도시 큐에 넣기
                    visited[rq.end] = true; //이어진 도시 방문 표시
                }
                //지금까지 도시들 지나온 시간 + 지금 도로 건너는 시간과
                //저장된 이어진 노드까지 거리 배열 값 중 큰 것 저장
                dis[rq.end] = Math.max(dis[rq.end], dis[c] + rq.time);
            }
        }

        //백트래킹 시작
        q = new LinkedList<>();
        roadCnt = 0;
        q.add(endCity); //도착 도시부터 시작

        while (!q.isEmpty()) {
            int c = q.poll();
            for (int i = 0; i < Rarr[c].size(); i++) {
                Edge check = Rarr[c].get(i);
                //최대거리로 진행하는 루트만 주목하기 위해서
                //다음 도시의 dis와 현재 도시의 dis의 차이가 도시간 거리와 같을 때만 진행
                //같지 않고 도시간 거리가 더 짧은 경우 해당 루트는 더 빠른 루트임
                if (check.time != 0 && dis[c] - dis[check.end] == check.time) {
                    q.add(check.end);
                    roadCnt++; //최장시간 루트 중 도로 + 1
                    check.time = 0; //도로 방문 표시 해줘야 하는데 도시정보로는 불가..그냥 0으로 바꿔서 방문 표시
                }
            }
        }
        return dis[endCity];
    }

    static class Edge{
        int start;
        int end;
        int time;

        public Edge(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }
}
