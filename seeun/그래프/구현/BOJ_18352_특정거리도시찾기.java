import java.io.*;
import java.util.*;

public class BOJ_18352_특정거리도시찾기 {

    private static ArrayList<Integer>[] arr;

    private static int dis;
    private static int start;
    private static int[] distance;
    private static ArrayList<Integer> ans; //정답 리스트

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int city = Integer.parseInt(st.nextToken()); //노드 개수
        int road = Integer.parseInt(st.nextToken()); //엣지 개수
        dis = Integer.parseInt(st.nextToken()); //start에서 최단거리가 dis인 도시 찾기
        start = Integer.parseInt(st.nextToken()); //시작 도시

        arr = new ArrayList[city + 1]; //노드 연결상태 저장 리스트 배열
        distance = new int[city + 1]; //거리 저장 배열
        ans = new ArrayList<>(); //정답 도시들 저장할 리스트
        //인접리스트 초기화
        for (int i = 1; i <= city; i++) {
            arr[i] = new ArrayList<>();
        }

        //거리배열 초기화
        for (int i = 0; i <= city; i++) {
            distance[i] = -1;
        }

        for (int i = 0; i < road; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to); // 단방향 도로이므로 from에서 to로만
        }

        bfs(start); //시작 도시로부터 최단거리가 dis인 도시들을 찾는 것이므로 bfs활용
        //최단거리가 dis인 도시 정답 배열에 저장
        for(int i=1; i<=city; i++){
            if (distance[i] == dis) { //첫번째 도시부터 시작해서
                ans.add(i);
            }
        }

        if(ans.isEmpty()) //dis까지의 도시가 존재하지 않으면 -1 출력
            bw.write("-1");
        else{ //dis까지의 도시가 존재한다면
            Collections.sort(ans); //오름차순 정렬
            StringBuilder sb = new StringBuilder(); //bw버퍼 주기적인 flush로 출력초과날까봐 sb사용
            for (int c : ans) {
                sb.append(c + "\n"); //개행해주면서 출력
            }
            bw.write(sb.toString());
        }
        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int node) {

        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int n : arr[curr]) { //엣지만큼 탐색
                if(distance[n] == 0){ //방문 안한 도시일 때
                    distance[n] = distance[curr] + 1;
                    q.add(n);
                }
            }
        }
    }
}
