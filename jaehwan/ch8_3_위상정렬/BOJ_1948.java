import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1948 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> A = new ArrayList<>();//정방향 인접리스트 배열
        ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();//역방향 인접리스트 배열
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1];  //진입차수 배열
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); //시작
            int E = Integer.parseInt(st.nextToken()); //도착
            int V = Integer.parseInt(st.nextToken()); //걸리는 시간
            A.get(S).add(new dNode(E, V)); //정방향 간선 추가 S에서 E로 가는 가중치 V 저장
            reverseA.get(E).add(new dNode(S, V)); //역방향 간선 추가
            indegree[E]++;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(st.nextToken()); //시작도시
        int endDosi = Integer.parseInt(st.nextToken()); //도착도시

        //위상정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startDosi); //큐에 시작 도시를 넣고
        int[] result = new int[N + 1]; //임계경로 배열
        while (!queue.isEmpty()) {
            int now = queue.poll(); //처음에 시작 도시
            for (dNode next : A.get(now)) { //현재 노드에서 갈수있는 도시 개수만큼 돌면서 (위에서 A에)
                indegree[next.targetNode]--; //진입차수배열 --
                //타깃 노드의 현재 경로값과 현재 노드의 경로값 + 도로 시간값 중 큰 값으로 저장
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if (indegree[next.targetNode] == 0) { //0이되면 다음 노드 큐에
                    queue.offer(next.targetNode);
                }
            }
        }
        //위상정렬 역방향 수행
        int resultCount = 0;
        boolean[] visited = new boolean[N + 1];
        queue = new LinkedList<>();
        queue.offer(endDosi);
        visited[endDosi] = true;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (dNode next : reverseA.get(now)) {
                if (result[next.targetNode] + next.value == result[now]) { 
                    // 해당도시의 임계 경로값+에지==이전도시 임계 경로 값인지 확인 
                    //임계경로값 = 해당도시까지 최대 거리니까 지나온 에지가 지난번 노드의 최대거리 값과 같은 즉 최대한 멀리떨어져있는 경로인지 확인하는것
                    resultCount++; //정답 1증가
                    if (visited[next.targetNode] == false) {
                        visited[next.targetNode] = true;
                        queue.offer(next.targetNode);
                    }
                }
            }
        }
        System.out.println(result[endDosi]);
        System.out.println(resultCount);
    }
}

class dNode {
    int targetNode;//인덱스
    int value;//값

    dNode(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}

/*
7
9
1 2 4
1 3 2
1 4 3
2 6 3
2 7 5
3 5 1
4 6 4
5 6 2
6 7 5
1 7
* */
/*
문제해설
모든 도로가 일방 통행이다.
특정 도시에서 다른 도시로 가기위해서는 그전의 도시들을 모두 방문해야한다.
x번 도시를 가기위해 거쳐야하는 도시의 개수가 필요 -> 진입차수 배열 필요
모든 사람들이 만날 수 있다 그중에 최소 -> 최장거리 오는 사람들은 거리가 가장 먼 사람들이다. -> 임계경로 배열도 필요 이중 가장 큰 수가 기준이 된다.
쉬지않고 오는 사람들이 지나가는 모든 도로(에지)의 수를 체크해서 카운팅해준다.

문제풀이
최대값 거리를 지나간 사람들이 지나갈때는 지 거리가 최대값에 포함되는지 알수가 없습니다. -> 한바퀴 돌고 다시 역재생해야함
목표점에서 출발점으로 오면서 역배열



실패 케이스
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<dNode>> A = new ArrayList<>();//정방향 인접리스트 배열
        ArrayList<ArrayList<dNode>> reverseA = new ArrayList<>();//역방향 인접리스트 배열
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            reverseA.add(new ArrayList<>());
        }
        int[] indegree = new int[N + 1];  //진입차수 배열
        int[] indegree_re=new int[N + 1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()); //시작
            int E = Integer.parseInt(st.nextToken()); //도착
            int V = Integer.parseInt(st.nextToken()); //걸리는 시간
            A.get(S).add(new dNode(E, V)); //정방향 간선 추가 S에서 E로 가는 가중치 V 저장
            reverseA.get(E).add(new dNode(S, V)); //역방향 간선 추가
            indegree[E]++;
        }
        for(int i = 1; i < indegree.length; i++){
            indegree_re[indegree.length-i]=indegree[i];
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startDosi = Integer.parseInt(st.nextToken()); //시작도시
        int endDosi = Integer.parseInt(st.nextToken()); //도착도시

        //위상정렬
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startDosi); //큐에 시작 도시를 넣고
        int[] result = new int[N + 1]; //임계경로 배열
        while (!queue.isEmpty()) {
            int now = queue.poll(); //처음에 시작 도시
            for (dNode next : A.get(now)) { //현재 노드에서 갈수있는 도시 개수만큼 돌면서
                indegree[next.targetNode]--; //진입차수배열 --
                //타깃 노드의 현재 경로값과 현재 노드의 경로값 + 도로 시간값 중 큰 값으로 저장
                result[next.targetNode] = Math.max(result[next.targetNode], result[now] + next.value);
                if (indegree[next.targetNode] == 0) { //진입차수 0이면 다음 노드
                    queue.offer(next.targetNode);
                }
            }
        }
        //
        Queue<Integer> queue_re = new LinkedList<>();
        queue_re.offer(endDosi); //큐에 도시를 넣고
        int[] result_re = new int[N + 1]; //임계경로 배열
        while (!queue_re.isEmpty()) {
            int now = queue_re.poll(); //처음에 시작 도시
            for (dNode next : reverseA.get(now)) { //현재 노드에서 갈수있는 도시 개수만큼 돌면서
                indegree_re[next.targetNode]--; //진입차수배열 --
                //타깃 노드의 현재 경로값과 현재 노드의 경로값 + 도로 시간값 중 큰 값으로 저장
                result_re[next.targetNode] = Math.max(result_re[next.targetNode], result_re[now] + next.value);
                if (indegree_re[next.targetNode] == 0) { //진입차수 0이면 다음 노드
                    queue_re.offer(next.targetNode);
                }
            }
        }
        int resultCount=0;
        for(int i=1;i<=N;i++){
            if(result[i] + result_re[i] == result[endDosi]){
                resultCount++;
            }
        }
        System.out.println(result[endDosi]);
        System.out.println(resultCount);
    }
}

class dNode {
    int targetNode;//인덱스
    int value;//값

    dNode(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}
*/
