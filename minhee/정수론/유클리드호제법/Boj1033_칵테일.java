package minhee.정수론.유클리드호제법;

import java.io.*;
import java.util.*;

/**
 * 최소공배수 관련 변수 long으로 선언해야 통과 O
 */
public class Boj1033_칵테일 {
    static ArrayList<Node>[] data;
    static boolean visit[];
    static long[] tmp;
    static long lcm = 1; //최소공배수
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        data = new ArrayList[N];
        visit = new boolean[N];
        tmp = new long[N];

        //세팅
        for(int i=0; i<N; i++){
            data[i] = new ArrayList<Node>();
        }

        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            data[a].add(new Node(b,p,q));
            data[b].add(new Node(a,q,p)); //반대로!
            lcm *= (p * q / gcd(p,q)); //최소공배수 구함 -> 두수의 곱을 최대공약수로 나눈다.
        }
        //임의의 한점 0을 최소공배수로 위에서 구한 최소 공배수로 세팅
        tmp[0] = lcm;

        //dfs 탐색 수행
        dfs(0);

        //최대공약수 구하기
        long tmpGcd = tmp[0];
        for(int i=1; i<N; i++){
            tmpGcd = gcd(tmpGcd, tmp[i]);
        }
        for(int i=0; i<N; i++){
            bw.write((tmp[i] / tmpGcd)+" ");
        }
        bw.flush();
        br.close();
        bw.close();

    }
    static long gcd(long a, long b){
        if(b!=0) return gcd(b, a%b);
        else return a;
    }

    static void dfs(int num){
        visit[num] = true;
        for(Node n : data[num]){
            int next = n.b; //연결
            if(!visit[next]){
                tmp[next] = tmp[num] * n.q / n.p;
                dfs(next);
            }
        }
    }
}
class Node{
    int b;
    int p;
    int q;

    public Node(int b, int p, int q){
        this.b = b;
        this.p = p;
        this.q = q;
    }
}
