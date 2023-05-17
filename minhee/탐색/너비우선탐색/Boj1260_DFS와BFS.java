package minhee.탐색.너비우선탐색;
/**
 * BOJ1260 - DFS와 BFS
 */

import java.util.*;
import java.io.*;
public class Boj1260_DFS와BFS {
    static int N,M,V; //정점의 개수, 간선의 개수, 탐색 시작 정점 번호
    static List<List<Integer>> data = new ArrayList<>();
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];
        for(int i=0; i<=N; i++){
            data.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data.get(a).add(b); //양방향
            data.get(b).add(a);
        }

        //정렬
        for(int i=1; i<=N; i++){
            Collections.sort(data.get(i));
        }


        dfs(V);
        sb.append("\n");
        Arrays.fill(visit,false);
        bfs(V);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        br.close();
    }

    static void dfs(int start){
        if(visit[start]) return;

        visit[start] = true;
        sb.append(start).append(" ");

        for(int i=0; i<data.get(start).size(); i++){
            if(!visit[data.get(start).get(i)]){
                dfs(data.get(start).get(i));
            }
        }
    }
    static void bfs(int start){
        Queue<Integer> que = new LinkedList<>();

        visit[start] = true;
        que.add(start);

        while(!que.isEmpty()){
            int num = que.poll();
            sb.append(num).append(" ");

            for(int i=0; i<data.get(num).size(); i++){
                if(!visit[data.get(num).get(i)]){
                    visit[data.get(num).get(i)] = true;

                    que.add(data.get(num).get(i));
                }
            }

        }
    }
}
