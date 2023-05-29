package minhee.그래프.그래프의표현;

import java.io.*;
import java.util.*;

public class Boj1325_효율적인해킹 {
    static int N,M;
    static List<List<Integer>> computers = new ArrayList<>();
    static int[] answer;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[N+1]; //정답 개수 저장
        for(int i=0; i<=N; i++){ //N+1개
            computers.add(new ArrayList<>());
        }

        //신뢰 관계 연결
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            connect(A,B);
        }

        boolean[] visit = new boolean[N+1];
        for(int i=1; i<=N; i++){
            answer[i] = checkTrust(i, 0, visit);
            Arrays.fill(visit,false);
        }

        int max = Arrays.stream(answer).max().getAsInt();
        for(int i=1; i<=N; i++){
            if(answer[i] == max) sb.append(i).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
    static void connect(int A, int B){
        computers.get(B).add(A);
    }
    static int checkTrust(int com, int cnt, boolean[] visit){
        int tmp = cnt;
        for(int trust : computers.get(com)){
            if(!visit[trust]){
                visit[trust] = true;
                tmp = checkTrust(trust,cnt+1,visit);
            }
        }
        return tmp;
    }
}
