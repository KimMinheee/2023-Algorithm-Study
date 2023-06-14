package week8;

import java.io.*;
import java.util.*;

public class BOJ_1516_게임개발 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] rqBuilds = new int[n + 1]; //먼저 지어져야 하는 건물 개수 저장 배열
        int[] times = new int[n + 1]; //건물 짓는데 걸리는 시간
        ArrayList<Integer>[] graph = new ArrayList[n + 1]; //먼저 지어지는 건물들과 연결하기 위한 리스트
        int[] ans = new int[n + 1]; //정답 배열
        
        //먼저 지어지는 건물들과 연결하는 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            times[i] = Integer.parseInt(st.nextToken()); //i번 건물 짓는데 걸리는 시간
            while (true) {
                int rq = Integer.parseInt(st.nextToken());
                if(rq == -1)
                    break;
                graph[rq].add(i);//먼저 지어져야하는 건물 번호에 현재 건물번호 저장
                rqBuilds[i]++; //현재 건물 짓기 위해 먼저 지어져야되는 건물 개수
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // 먼저 지어져야 하는 건물없는 건물이면 큐에 건물 번호 넣기
        for (int i = 1; i <= n; i++) {
            if (rqBuilds[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int b = q.poll();

            List<Integer> list = graph[b];
            for (int i = 0; i < list.size(); i++) {
                rqBuilds[list.get(i)]--; //먼저 지어야하는 건물 개수--
                //현재 ans에 저장된 시간(ans[list.get(i)])과
                //먼저 지어져야 하는 건물들 짓는 시간 합(ans[b] + times[b]) 비교해서 더 오래 걸리는 것으로 업데이트
                //이 연산에는 마지막 해당 건물 짓는 시간 포함X
                ans[list.get(i)] = Math.max(ans[list.get(i)], (ans[b] + times[b]));
                if (rqBuilds[list.get(i)] == 0) { //더이상 먼저 지을 건물 없다면
                    q.offer(list.get(i)); //큐에 건물 번호 넣기
                }

            }
        }
        for (int i = 1; i <= n; i++) {
            bw.write(ans[i] + times[i] + "\n"); //마지막으로 자신 짓는데 걸리는 시간 더하기
        }
        bw.flush();
        br.close();
        bw.close();
        
    }
}
