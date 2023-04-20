import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11660_구간합구하기2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); //데이터, 질의 읽어들일 StringTokenizer 객체 생성
        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int q = Integer.parseInt(st.nextToken()); //질의 개수

        int[][] arr = new int[N+1][N+1]; //수의 2차원 합배열

        //기본 배열 만들기, 질의에서 요소 순서를 쉽게 사용하기 위해 인덱스 1부터 사용
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] ps = new int[N+1][N+1]; //수의 2차원 합배열
        
        //누적합 구하기
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                //바로 직전까지의 누적합 더해주고 공통부분은 삭제 후 현재 요소 더해주기
                //인덱스 이하는 문제가 되지 않음. 0행 0열은 0으로 초기화
                ps[i][j] = ps[i][j-1] + ps[i-1][j] - ps[i-1][j-1] + arr[i][j];
            }
        }
        
        //질의 수만큼 진행
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()); //시작행
            int y1 = Integer.parseInt(st.nextToken()); //시작열
            int x2 = Integer.parseInt(st.nextToken()); // 끝행
            int y2 = Integer.parseInt(st.nextToken()); // 끝열

            //구간 합 구하기 x2,y2까지의 누적합에서 x1,y1-x2,y2의 사각형안에 포함되지 않는 누적합들 모두 제외시키기
            bw.write(ps[x2][y2] - ps[x2][y1-1] - ps[x1-1][y2] + ps[x1-1][y1-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
