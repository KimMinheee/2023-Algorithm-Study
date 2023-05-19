/**
 * 일정 깊이를 가지는 연결을 찾는 dfs
 * 방문한 노드 다시 방문 가능
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_13023_ABCDE {

    static boolean[] visited;
    static ArrayList<Integer> arr[];
    static boolean isRel = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수
        arr = new ArrayList[n];
        visited = new boolean[n];
        Arrays.fill(visited, false); //초기화

        //노드 정보 저장
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>(); //각 노드에 리스트 생성
        }
        //간선 정보 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node].add(node2);
            arr[node2].add(node);
        }

        br.close();
        for(int i=0; i<n; i++){
                dfs(i, 1);
                if(isRel){
                    bw.write("1");
                    bw.flush();
                    bw.close();
                    return;
                }
        }
        bw.write("0");
        bw.flush();
        bw.close();
    }

    static private void dfs(int i, int n) {
        if(n == 5 || isRel){ //이어진 관계 다 찾았거나 재귀로 찾던 중 isRel이 true로 업데이트 되었다면 끝
            isRel = true;
            return;
        }
        visited[i] = true;
        Iterator<Integer> iterator = arr[i].listIterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if(!visited[next]) //방문하지 않았다면 dfs수행
                dfs(next, n+1);
        }
        visited[i] = false; // 다른 재귀 사이클에서 탐색 가능 하도록 false로 다시 바꿔주기
    }
}
