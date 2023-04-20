import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()); //데이터, 질의 읽어들일 StringTokenizer 객체 생성
        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int q = Integer.parseInt(st.nextToken()); //질의 개수

        st = new StringTokenizer(br.readLine()); //수 읽어들일 객체 생성
        int[] ps = new int[N+1]; //수의 합배열

        //합 배열 구하기, 질의에서 요소 순서를 쉽게 사용하기 위해 인덱스 1부터 사용
        ps[1] = Integer.parseInt(st.nextToken()); //인덱스 0 저장
        for(int i=2; i<=N; i++){
            ps[i] = ps[i-1] + Integer.parseInt(st.nextToken()); //누적합 구하기
        }
        
        //질의 수만큼 진행
        for(int i=0; i<q; i++){
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken()); //시작 인덱스
            int endIdx = Integer.parseInt(st.nextToken()); // 끝 인덱스

            //구간 합 구하기
            bw.write(ps[endIdx] - ps[startIdx-1] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
