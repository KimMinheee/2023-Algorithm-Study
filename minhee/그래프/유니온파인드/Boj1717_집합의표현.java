package minhee.그래프.유니온파인드;

import java.io.*;
import java.util.*;

public class Boj1717_집합의표현 {
    static int N,M;
    static int[] data;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //초기화 : 자기 자신 가리킴
        data = new int[N+1];
        for(int i=1; i<=N; i++){
            data[i] = i;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0){
                //합치기
                union(a,b);
            }
            else{
                //확인
                bw.write(checkGroup(a,b)+"\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
    static String checkGroup(int a, int b){ //a와 b가 같은 집단에 있는지 확인
        int rootA = find(a);
        int rootB = find(b);

        if(rootA == rootB) return "YES";
        else return "NO";
    }
    static int find(int a){ //a의 루트노드 반환
        if(data[a] == a) return a;
        else return data[a] = find(data[a]); //-> 속도 최적화
    }
    static void union(int a, int b){//a와 b를 한 집단으로 합침
        if(a > b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        int rootA = find(a);
        int rootB = find(b);
        if(rootA < rootB) data[rootA] = rootB;
        else data[rootB] = rootA;
    }
}
