package ch08_3_위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1948_임계경로 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 수(노드)
        int M = Integer.parseInt(br.readLine()); // 도로 수(엣지)

        ArrayList<ArrayList<dNode>> arr = new ArrayList<>(); // 도시 인접 리스트
        ArrayList<ArrayList<dNode>> reserveArr = new ArrayList<>(); // 역방향 인접 리스트
        for (int i = 0; i <= N; i++) { // 도시 수만큼 인접리스트 데이터 저장
            arr.add(new ArrayList<>());
            reserveArr.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1]; // 진입차수 저장 배열
        for (int j = 1; j < M; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 도로의 출발 도시번호
            int b = Integer.parseInt(st.nextToken()); // 도착 도시번호
            int c = Integer.parseInt(st.nextToken()); // 걸리는 시간
            arr.get(a).add(new dNode(b, c)); // 인접리스트 데이터 저장
            reserveArr.get(b).add(new dNode(a, c)); // 역방향 인접리스트 데이터 저장
            indegree[b]++; // 진입차수 배열 초기 데이터 저장
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 임계경로 구할 시작도시
        int end = Integer.parseInt(st.nextToken()); // 마지막 도시

        //위상정렬
        Queue<Integer> q = new LinkedList<>();
        q.offer(start); // 출발 도시 큐에 삽입
        int[] result = new int[N + 1]; // result(각 도시의 최대 걸리는 시간 저장 - 임계 경로값)
        while (!q.isEmpty()) {
            int now = q.poll();//현재 노드 = 큐에서 데이터 poll
            for (dNode next : arr.get(now)) { // 현재 노드에서 갈 수 있는 노드의 개수
                indegree[next.targetNode]--; // 타깃 노드 진입차수 배열 --
                //result = 타깃 노드의 현재 경로 값과 현재 노드의 경로값 + 도로 시간값 중 큰 값으로 저장
                result[next.targetNode] = Math.max(result[next.targetNode],
                    result[now] + next.value);
                if (indegree[next.targetNode] == 0) {
                    q.offer(next.targetNode);
                }
            }
        }

        //위상정렬 reverse
        int resultCount = 0; // 1분도 쉬지 않고 달려야하는 도로의 수
        boolean visited[] = new boolean[N + 1]; // 각 도시의 방문 유무 저장
        q = new LinkedList<>();
        q.offer(end); // 도착 도시 큐에 삽입 (위 위상정렬과 반대)
        visited[end] = true; // 도착도시(시작하는)를 방문 도시로 표시
        while (!q.isEmpty()) {
            int now = q.poll();
            for (dNode next : reserveArr.get(now)) {  //현재노드에서 갈 수 있는 노드 개수 -> 역방향 인접 리스트 기준
                // 1분도 쉬지 않는 도로 체크
                if (result[next.targetNode] + next.value == result[now]) {
                    resultCount++; // 1분도 쉬지 않고 달려야 하는 도로값 1증가
                    if (visited[next.targetNode] == false) { // 아직 방문하지 않은 도시면
                        visited[next.targetNode] = true; // 방문 배열에 체크
                        q.offer(next.targetNode); // 큐에 타깃 노드 추가
                    }
                }
            }
        }
        System.out.println(result[end]);
        System.out.println(resultCount);
    }
}

class dNode {

    int targetNode;
    int value;

    dNode(int targetNode, int value) {
        this.targetNode = targetNode;
        this.value = value;
    }
}

