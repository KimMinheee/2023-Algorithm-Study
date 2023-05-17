package minhee.탐색.깊이우선탐색;

import java.io.*;
import java.util.*;
public class Boj11724_연결요소의개수_2 {
    static int N,M; //정점의 개수, 간선의 개수
    static int[] arr; //root 노드 저장하는 배열
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hashSet = new HashSet<>();


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1]; //N이 1부터

        initializeRootArray(); //부모노드를 자기자신으로 세팅

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a,b);
        }

        //모든 정점을 순회하면서 root의 개수를 구한다 = 그룹의 개수(연결 요소)를 구한다.
        for(int i=1; i<=N; i++){
            hashSet.add(findRoot(i));
        }
        System.out.println(hashSet.size());
        br.close();

    }
    static void union(int a, int b){
        int aRoot = findRoot(a);
        int bRoot = findRoot(b);

        if(aRoot < bRoot) arr[bRoot] = aRoot;
        else arr[aRoot] = bRoot;
    }
    static int findRoot(int num){
        if(arr[num] == num) return num;
        return arr[num] = findRoot(arr[num]);
    }
    static void initializeRootArray(){
        for(int i=1; i<=N; i++){
            arr[i] = i;
        }
    }
}
