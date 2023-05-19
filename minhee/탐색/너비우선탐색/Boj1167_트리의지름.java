package minhee.탐색.너비우선탐색;
import java.io.*;
import java.util.*;

public class Boj1167_트리의지름 {
    static int V; //정점의 개수
    static List<List<Edge>> data = new ArrayList<>();
    static boolean[] check;
    static int answer = 0;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        check = new boolean[V+1];

        //초기화
        for(int i=0; i<=V; i++){
            data.add(new ArrayList<>());
        }

        //정점 연결
        for(int i=1; i<=V; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int point = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int anotherPoint  = Integer.parseInt(st.nextToken());

                if(anotherPoint == -1) break;
                int distance = Integer.parseInt(st.nextToken());
                data.get(point).add(new Edge(anotherPoint, distance));
            }
        }

        findMaxDiameter(1); //임의의 정점(1)에서 시작 -> root는 아님
        System.out.println(answer);
        br.close();
    }
    static int findMaxDiameter(int num){
        check[num] = true;

        int max = 0;
        int secondMax = 0;
        for(int i=0; i<data.get(num).size(); i++){
            int point = data.get(num).get(i).point;

            if(check[point]) continue;

            int distance = data.get(num).get(i).distance;
            int sum = findMaxDiameter(point) + distance;

            //가장 큰 값과 두 번쨰로 큰 값을 찾는다.
            if(sum > max){
                int tmp = max;
                max = sum;
                secondMax = tmp;
            }
            else if(sum > secondMax){
                //max보다 크지는 않지만 기존의 두번째로 큰 값보다 클 경우
                secondMax = sum;
            }
        }
        answer = Math.max(answer, (max+secondMax));

        return max;
    }
}
class Edge{
    int point;
    int distance;
    public Edge(int point, int distance){
        this.point = point;
        this.distance = distance;
    }
}
