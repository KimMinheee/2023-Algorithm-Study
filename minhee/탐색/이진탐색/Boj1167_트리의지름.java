package minhee.탐색.이진탐색;
import java.io.*;
import java.util.*;
public class Boj1167_트리의지름 {
    static int V; //정점의 개수
    static List<List<Edge>> data = new ArrayList<>();
    static boolean[] check;
    static int[] tmpAnswer;
    static int[] realAnswer;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        check = new boolean[V+1];
        tmpAnswer = new int[V+1];
        realAnswer = new int[V+1];

        for(int i=0; i<=V; i++){
            data.add(new ArrayList<>());
        }

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
        for(int i=1; i<=V; i++){
            findMaxDiameter(i,0); //i 정점을 기준으로 최대 정점인 것 찾기
            realAnswer[i] = Arrays.stream(tmpAnswer).max().getAsInt();
            Arrays.fill(check,false); //초기화
            Arrays.fill(tmpAnswer,0);
        }
        System.out.println(Arrays.stream(realAnswer).max().getAsInt());
    }
    static void findMaxDiameter(int num, int totalDistance){
        check[num] = true;
        for(int i=0; i<data.get(num).size(); i++){
            int next = data.get(num).get(i).point;
            int distance = data.get(num).get(i).distance;
            if(!check[next]){
                tmpAnswer[next] = totalDistance + distance;
                findMaxDiameter(next,totalDistance+distance);
            }
        }

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
