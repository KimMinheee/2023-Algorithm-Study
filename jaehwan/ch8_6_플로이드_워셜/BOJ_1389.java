import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1389 { //[BOJ_1389]케빈베이컨 jaehwan solved - 플로이드 워셜 사용
    static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int[] memo;
    static int max=1000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memo = new int[N +1];

        int[][] dist = new int[N +1][N +1];

        // 초기화
        for(int i = 1; i<= N; i++) { //유저수만큼
            for(int j = 1; j<= N; j++) {
                if(i==j) dist[i][j] = 0;//시작도시와 종료 도시가 같으면 0
                else dist[i][j] = max;
            }
        }

        for(int i = 1; i<= M; i++) { //친구 관계수
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1; //친구 관계를 맺은 사람수
            dist[b][a] = 1;
        }


        for(int k = 1; k<= N; k++) { //노드 
            for(int i = 1; i<= N; i++) {
                for(int j = 1; j< N +1; j++) {
                    dist[i][j]= Math.min(dist[i][j],dist[i][k]+dist[k][j]);
                }
            }
        }

        for(int i = 1; i<= N; i++) {
            for(int j = 1; j<= N; j++) {
                memo[i] += dist[i][j]; //한줄 값을 모두 더함 케빈 베이컨 수 배열 
            }
        }

        int min = Integer.MAX_VALUE;//충분히 큰값 
        int idx =0; //찾고자 하는 정답 
        for(int i = 1; i<= N; i++) {
            if(min > memo[i]) {//처음에 무조건 들어갈수 있게 해주고 바꾼다
                min = memo[i];
                idx =i;
            }
        }
        System.out.println(idx);
    }
}
