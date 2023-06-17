import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_1033_칵테일 {

    static boolean[] visited;
    static ArrayList<Node>[] ratio;

    static long rslt[];

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ratio = new ArrayList[n]; //재료 별로 비율들 저장하는 어레이리스트 배열
        rslt = new long[n]; //결과 배열

        for(int i=0; i<n; i++)
            ratio[i] = new ArrayList<>(); //각 노드에 대해 비율 어레이리스트 초기화

        visited = new boolean[n]; //노드 방문 여부 저장

        long gcd = 0;
        long lcm = 1;
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            ratio[a].add(new Node(b, p, q));
            ratio[b].add(new Node(a, q, p));

            gcd = getRslt(Math.max(p, q), Math.min(p, q));
            lcm *= p * q / gcd; //최소공배수

        }

        rslt[0] = lcm;
        dfs(0);

        //배열 요소 n개의 최대공약수 구하기
        long gcdN = rslt[0];
        for (int i = 1; i < n; i++) {
            gcdN = getRslt(Math.max(gcdN, rslt[i]), Math.min(gcdN, rslt[i]));
        }

        for (int i = 0; i < n; i++) {
            bw.write((rslt[i]/gcdN) + " ");
        }


        bw.flush();
        br.close();
        bw.close();
    }

    private static void dfs(int i) {
        visited[i] = true;

        for (Node node : ratio[i]) {
            int next = node.next;
            if (!visited[next]) {
                rslt[next] = rslt[i] * node.ratio2 / node.ratio1; //?
                dfs(next);
            }
        }
    }

    public static long getRslt(long max, long min) {
        if(min == 0) return max;
        else return getRslt(min, max % min);
    }

     public static class Node{
        int next;
        int ratio1;
        int ratio2;

         public Node(int next, int ratio1, int ratio2) {
             this.next = next;
             this.ratio1 = ratio1;
             this.ratio2 = ratio2;
         }
     }
}
