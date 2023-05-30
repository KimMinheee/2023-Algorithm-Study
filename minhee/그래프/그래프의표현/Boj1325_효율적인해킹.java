package minhee.그래프.그래프의표현;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [DFS/BFS]p1325_효율적인해킹
 * 아이디어:
 * - 오->왼 방향으로 인접리스트에 값 넣기
 * - visited,결과 배열(연결된 컴 수 저장)
 */
class Boj1325_효율적인해킹 {
    static int N,M; //컴수,신뢰관계수
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    static int cnt=0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화
        answer = new int[N+1];
        //visited = new boolean[N+1];
        for(int i=0; i<=N; i++){
            list.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int slave = Integer.parseInt(st.nextToken());
            int master = Integer.parseInt(st.nextToken());
            list.get(master).add(slave);
        }

        //1~n 경우
        for(int a = 1; a<=N; a++){
            visited = new boolean[N+1];
            bfs(a);
            answer[a] = cnt;
            max = Math.max(max,cnt);
            cnt=0;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            if(answer[i]==max) sb.append(i+" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        visited[start] = true;
        Queue<Integer> que = new LinkedList<>();
        que.add(start);

        while(!que.isEmpty()){
            int master = que.poll();
            for(int i=0; i<list.get(master).size();i++){
                int tmp = list.get(master).get(i);
                if(visited[tmp]==false){
                    cnt++;
                    visited[tmp] = true;
                    que.add(tmp);
                }
            }
        }
    }
}


