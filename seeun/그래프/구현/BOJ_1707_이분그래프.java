import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1707_이분그래프 {

    private static ArrayList<Integer>[] arr;
    private static boolean[] visited;
    private static boolean canDivide;
    private static int[] divide;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        //테스트 케이스 수 만큼 반복
        for (int test_case = 0; test_case < k; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken()); //노드 개수
            int e = Integer.parseInt(st.nextToken()); //에지 개수

            arr = new ArrayList[v + 1];
            //노드 에지 리스트 초기화
            for (int i = 1; i <= v; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                //임의의 노드에서 전체노드를 탐색해야 하기 때문에 양방향으로 저장
                arr[from].add(to);
                arr[to].add(from);
            }

            visited = new boolean[v + 1]; //방문 저장 배열 노드 탐색 시작할 때마다 초기화
            canDivide = true;//이분탐색 가능여부판별결과 변수
            divide = new int[v + 1]; //이분탐색하면서 저장할 집합

            //모든 노드 탐색해서 이분 그래프 안되는 부분 있나 체킹
            for (int i = 1; i <= v; i++) {

                if (canDivide)
                    dfs(i);//이분그래프 불가한 노드 나오기 전까지 계속 탐색
                else {//불가한 노드 나왔다면 아예 끝내기
                    break;
                }
            }
            if (canDivide)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
        
    }

    private static void dfs(int node) {
        visited[node] = true;

        //끝까지 탐색 다마쳤을 경우 탐색 끝내주기
        if (arr[node].isEmpty()) {
            return;
        }
        for (int curr : arr[node]) {
            if (!visited[curr]) {
                visited[curr] = true;
                //node와 다른집합에 저장
                if(divide[node] == 1)
                    divide[curr] = 0;
                else divide[curr] = 1;
                dfs(curr);
            }

            //방문한 노드와 현재 주목하고 있는 노드가 같은 집합, 이분 그래프 불가, 바로 끝내기
            else if (divide[curr] == divide[node]) {
                canDivide = false;
            }
            
            
        }
    }
}
