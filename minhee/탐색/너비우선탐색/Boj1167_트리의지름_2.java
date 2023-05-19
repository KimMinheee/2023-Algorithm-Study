package minhee.탐색.너비우선탐색;
/*
 * solution 2) 특정 정점에서 가장 먼 정점을 찾고 그 정점에서 다시 가장 먼 정점 사이의 거리를 이용하는 solution
 * 1. 특정 정점(a) 중 가장 먼 정점을 찾는다.
 * 2. 해당 정점은 리프노드이며 특정 정점에서 가장 거리가 먼 정점임이 보장된다.
 * 3. 해당 정점에서 가장 먼 정점을 구한다.
 */

import java.util.*;
import java.io.*;

public class Boj1167_트리의지름_2 {
    static int V;
    static List<List<Connection>> data = new ArrayList<>();
    static boolean[] check;
    static int[] tmpAnswer;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        check = new boolean[V+1];
        tmpAnswer = new int[V+1];

        //리스트 초기화
        for(int i=0; i<=V; i++){
            data.add(new ArrayList<>());
        }

        //연결 정점 세팅 - V번
        for(int i=1; i<=V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());

            while(st.hasMoreTokens()){
                int point = Integer.parseInt(st.nextToken());
                if(point == -1) break;
                int distance = Integer.parseInt(st.nextToken());

                data.get(start).add(new Connection(point, distance));
            }
        }


        //정점 1로 부터 가장 멀리 있는 정점을 찾는다.
        check[1] = true;
        findMaxNode(1,0);

        int maxNode = 0;
        int maxValue = Integer.MIN_VALUE;
        for(int i=1; i<=V; i++){
            if(tmpAnswer[i] > maxValue){
                maxValue = tmpAnswer[i];
                maxNode = i;
            }
        }

        Arrays.fill(tmpAnswer,0);
        Arrays.fill(check,false);

        findMaxNode(maxNode,0); //1에서 가장 먼 정점에서 다시 bfs
        maxValue = Integer.MIN_VALUE;

        for(int i=1; i<=V; i++){
            if(i == maxNode) continue;
            if(tmpAnswer[i] > maxValue){
                 maxValue = tmpAnswer[i];
            }
        }

        System.out.println(maxValue);
        br.close();
    }
    static void findMaxNode(int num, int totalDistance){
        for(int i=0; i<data.get(num).size(); i++){
            Connection c = data.get(num).get(i);

            if(!check[c.point]){
                check[c.point] = true;
                tmpAnswer[c.point] = totalDistance + c.distance;
                findMaxNode(c.point, totalDistance+c.distance);
            }
        }
    }
}
class Connection{
    int point;
    int distance;

    public Connection(int point, int distance){
        this.point = point;
        this.distance = distance;
    }
}
