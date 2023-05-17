package minhee.탐색.깊이우선탐색;
/**
 * BOJ 11724 - 연결 요소의 개수
 * - DFS 이용한 풀이
 * : 방문 여부 확인하면서 크게 한번 돌때 count++;
 */

import java.io.*;
import java.util.*;
public class Boj11724_연결요소의개수 {
    static int N,M; //정점의 개수, 간선의 개수
    static List<List<Integer>> data = new ArrayList<>();
    static boolean[] visit;
    static int answer = 0;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visit = new boolean[N+1];

        for(int i=0; i<=N; i++){
            data.add(new ArrayList<>());
        }

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            data.get(a).add(b);
            data.get(b).add(a);
        }

        for(int i=1; i<=N; i++){
            if(!visit[i]){
                answer++;
                dfs(i);
            }
        }
        bw.write(answer+"");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int start){
        if(visit[start]) return;

        visit[start] = true;
        for(int i=0; i<data.get(start).size(); i++){
            dfs(data.get(start).get(i));
        }
    }
}
