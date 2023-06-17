package minhee.그래프.위상정렬;

import java.io.*;
import java.util.*;

public class Boj1516_게임개발하기 {
    static int n;
    static int[] time;
    static int[] answer;
    static List<Integer>[] connect;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        time = new int[n+1];
        answer = new int[n+1];
        connect = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            connect[i] = new ArrayList<>();
        }

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break; //-1이면 끝
                connect[i].add(num);
            }
        }

        for(int i=1; i<=n; i++){
            dfs(i);
            bw.write(answer[i]+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static int dfs(int start){
        if(answer[start]==0){
            answer[start] += time[start];
            int max = 0;
            for(int i=0; i<connect[start].size(); i++){
                max = Math.max(max, dfs(connect[start].get(i)));
            }
            answer[start] += max;
            return answer[start];
        }
        return answer[start];
    }
}
