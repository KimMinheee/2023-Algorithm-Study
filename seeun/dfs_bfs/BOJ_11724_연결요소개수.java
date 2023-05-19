/**
* 연결될 수 있는 묶음 안에 들어가는 노드의 최대 개수를 구하는 문제
* 각 노드에 대해 dfs 구현
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소개수 {

    static ArrayList<Integer> arr[]; //방향없는 그래프이므로 양방향 저장하기 위해 배열로 선언
    static boolean visited[]; //방문여부 저장 배열

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //노드 개수
        int m = Integer.parseInt(st.nextToken()); //간선 개수
        arr = new ArrayList[n+1];
        visited = new boolean[n+1];
        Arrays.fill(visited, false); //초기화
        int cnt = 0; //연결요소 개수
        
        //노드 정보 저장
        for (int i = 1; i <= n; i++) {
            arr[i] = new ArrayList<>(); //각 노드에 리스트 생성
        }
        //간선 정보 저장
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            arr[node].add(node2); //무방향으로 두 방향 다 저장
            arr[node2].add(node);
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]){
                cnt++;
                dfs(i);
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    public static void dfs(int i) {
        if(visited[i]) //재귀로 들어오는 요소에 대해 방문여부 확인
            return;

        visited[i] = true;

        Iterator<Integer> iterator = arr[i].listIterator();
        while (iterator.hasNext()) {
            int next = iterator.next();
            if(!visited[next]) //방문하지 않았다면 dfs수행
                dfs(next);
        }
    }
}
