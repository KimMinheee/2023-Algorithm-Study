package week6;

import java.io.*;
import java.util.*;

public class BOJ_1325_효율적인해킹 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;

    private static int[] ans;//컴퓨터를 인덱스로 해킹 수를 값으로 가지는 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int com = Integer.parseInt(st.nextToken());
        int trust = Integer.parseInt(st.nextToken());

        arr = new ArrayList[com + 1]; //컴퓨터 노드 저장 리스트 배열
        ans = new int[com + 1]; //정답 리스트
        for (int i = 1; i <= com; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < trust; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            //신뢰하는 컴 저장
            arr[from].add(to);
        }


        int maxHacked = 0; //최대로 해킹하는 수
        for (int i = 1; i <= com; i++) {
            visited = new boolean[com + 1]; //방문 여부 배열 탐색 새로 시작할 때마다 초기화
            bfs(i);
        }
        
        //해킹 최대로 많이한 컴퓨터 찾기, 위의 반복문과는 같이 못돌린다. visited배열이 계속 초기화되기 때문!
        for(int i=1; i<=com; i++){
            if(maxHacked < ans[i])
                maxHacked = ans[i];
        }

        for (int i = 1; i <= com; i++) {
            if (ans[i] == maxHacked) {
                bw.write(i + " ");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    private static void bfs(int curr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(curr);
        visited[curr] = true;

        while(!q.isEmpty()){
            int next = q.poll();
            for (int i : arr[next]) {
                if(!visited[i]) {
                    visited[i] = true;
                    ans[i]++;
                    q.add(i);
                }
            }
        }
    }
}
