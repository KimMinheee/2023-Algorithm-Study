import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11403 { //[BOJ_11403]경로찾기 jaehwan solved - 플로이드 사용
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] distance;
    static int max=1000000;

    public static void main(String[] args) throws Exception{
        N=Integer.parseInt(br.readLine());
        distance=new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                int num = Integer.parseInt(st.nextToken());
                if(num==0){
                    distance[i][j]=max;
                }else distance[i][j]=num;
            }
        }
        for(int k=1;k<=N;k++) {
            for (int i = 1; i <= N; i++) {
                for(int j=1;j<=N;j++){
                    distance[i][j]=Math.min(distance[i][j],distance[i][k]+distance[k][j]);
                }
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1; j<=N;j++) {
                if (distance[i][j] == max) {
                    bw.write("0 ");
                }
                else bw.write("1 ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
/*
어떤 최단 거리가 있다면 k를 지나가는 경우와 지나가지 않는 경우로 나뉜다.
dist[u][v] = MIN(dist[u][v], dist[u][k] + dist[k][v])
*/
