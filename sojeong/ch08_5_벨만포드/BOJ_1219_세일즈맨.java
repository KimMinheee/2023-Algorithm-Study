package ch08_5_벨만포드;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class City {

    int end;
    int weight;

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class BOJ_1219_세일즈맨 {

    static int N;
    static ArrayList<ArrayList<City>> a;
    static int[] addMoney;
    static long[] totalMoney; // int[] 타입으로 정의하면 오버플로우 발생
    static final int INF = -987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 개수
        int startCity = Integer.parseInt(st.nextToken());
        int endCity = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()); // 도로의 개수

        a = new ArrayList<>(); // 인접리스트
        for (int i = 0; i < N; i++) {
            a.add(new ArrayList<>());
        }

        // 단방향 인접리스트 구현
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            a.get(start).add(new City(end, -weight));
        }

        addMoney = new int[N]; // 해당 도시에 도착하였을 때 얻는 돈

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            addMoney[i] = Integer.parseInt(st.nextToken());
        }

        String ans = "";
        if (!BFS(startCity, endCity)) { // 시작 도시에서 도착 도시에 도달할 수 없는 경우
            ans = "gg";
        } else {
            totalMoney = new long[N]; // 시작 도시에서 특정 도시에 도달할 때, 최종적인 돈의 값

            if (bellmanFord(startCity, endCity)) { // 도착 도시에 도달하는 데 무한한 돈이 발생
                ans = "Gee";
            } else { // 사이클 발생 없이 정상적으로 도착 도시에 도달
                ans = String.valueOf(totalMoney[endCity]);
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 특정 두 도시가 연결되어있는지 확인
    public static boolean BFS(int startCity, int endCity) {
        if (startCity == endCity) {
            return true;
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N];
        q.offer(startCity);
        visited[startCity] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            for (City c : a.get(now)) {
                if (!visited[c.end]) {
                    if (c.end == endCity) {
                        return true;
                    }

                    visited[c.end] = true;
                    q.offer(c.end);
                }
            }
        }

        return false;
    }

    // 벨만 포드 알고리즘
    public static boolean bellmanFord(int startCity, int endCity) {
        Arrays.fill(totalMoney, INF);
        totalMoney[startCity] = addMoney[startCity]; // 시작 도시 초기화.
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for (int i = 0; i < N - 1; i++) {
            update = false;

            // 최단거리 초기화.
            for (int j = 0; j < N; j++) {
                for (City city : a.get(j)) {
                    if (totalMoney[j] == INF) {
                        break;
                    }

                    if (totalMoney[city.end] < totalMoney[j] + city.weight + addMoney[city.end]) {
                        totalMoney[city.end] = totalMoney[j] + city.weight + addMoney[city.end];
                        update = true;
                    }
                }
            }

            // 더 이상 최단거리 초기화가 일어나지 않았을 경우 반복문을 종료.
            if (!update) {
                break;
            }
        }

        // 사이클이 발생한 노드를 따로 저장함.
        ArrayList<Integer> cycleNodeList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (City city : a.get(i)) {
                if (totalMoney[i] == INF) {
                    break;
                }

                if (totalMoney[city.end] < totalMoney[i] + city.weight + addMoney[city.end]) {
                    cycleNodeList.add(i);
                    cycleNodeList.add(city.end);
                }
            }
        }

        // 사이클이 발생한 노드가 도착 지점에 도달할 수 있는 지확인함.
        for (int i = 0; i < cycleNodeList.size(); i++) {
            if (BFS(cycleNodeList.get(i), endCity)) {
                return true;
            }
        }

        // 사이클이 발생한 노드가 전부 도착 지점에 도달할 수 없다면,
        // 그 노드를 제외한 나머지 노드로 totalMoney를 초기화 함.
        Arrays.fill(totalMoney, INF);
        totalMoney[startCity] = addMoney[startCity];

        for (int i = 0; i < N - 1; i++) {
            update = false;
            for (int j = 0; j < N; j++) {
                for (City city : a.get(j)) {
                    if (cycleNodeList.contains(j) || totalMoney[j] == INF) {
                        break;
                    }

                    if (cycleNodeList.contains(city.end)
                        || totalMoney[city.end]
                        < totalMoney[j] + city.weight + addMoney[city.end]) {
                        totalMoney[city.end] = totalMoney[j] + city.weight + addMoney[city.end];
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        return false;

    }

}