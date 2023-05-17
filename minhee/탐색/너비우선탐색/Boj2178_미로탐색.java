package minhee.탐색.너비우선탐색;

import java.util.*;
import java.io.*;
public class Boj2178_미로탐색 {
    static int[][] map;
    static boolean[][] check;
    static int N,M; //행, 열
    static int answer = 0;
    static int[] dn = {0,0,-1,1};
    static int[] dm = {1,-1,0,0};
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        check = new boolean[N+1][M+1];

        for(int i=1; i<=N; i++){
            String[] line = br.readLine().split("");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }
        bfs();

        System.out.println(answer);
        br.close();
    }
    static void bfs(){
        Queue<Point> que = new LinkedList<>();
        que.add(new Point(1,1,1));
        check[1][1] = true;

        while(!que.isEmpty()){
            Point p = que.poll();
            if(p.n == N && p.m == M){
                answer = p.count;
                return;
            }

            for(int i=0; i<4; i++){
                int tn = p.n + dn[i];
                int tm = p.m + dm[i];
                if(tn<1 || tm<1 || tn>N || tm>M) continue;

                if(map[tn][tm] == 1 && check[tn][tm]==false){
                    check[tn][tm] = true;
                    que.add(new Point(tn,tm,p.count+1));
                }
            }

        }
    }
}
class Point{
    int n;
    int m;
    int count; //누적 이동 횟수

    public Point(int n, int m, int count){
        this.n = n;
        this.m = m;
        this.count = count;
    }
}
