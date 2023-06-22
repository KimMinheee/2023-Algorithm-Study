import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11404 { //[BOJ_11404]버스노선 jaehwan solved - 플로이드 사용
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[][] distance;
    static int max=10000000;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        distance = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) { //시작 도시와 연결 도시가 같은 경우
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = max;
                }
            }
        }
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (distance[s][e] > v) {
                distance[s][e] = v;
            }
        }
        //플로이드 알고리즘 제일 바깥에 경로만큼 이 핵심 3중 반복문
        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    if(distance[i][j]>distance[i][k]+distance[k][j]){
                        distance[i][j]=distance[i][k]+distance[k][j];
                    }
                }
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                if(distance[i][j] == max){
                    bw.write("0 ");
                }
                else {
                    bw.write(distance[i][j]+" ");
                }
            }bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
