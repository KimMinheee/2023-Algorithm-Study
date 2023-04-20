import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1546_평균구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //시험본 과목 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); //시험 과목들

        int max = 0; //과목 최대값 초기화
        int sum = 0; //과목 총점
        
        //과목 별 총점 구하기 및 최고점 과목 구하기
        while (st.hasMoreTokens()) {
            int score = Integer.parseInt(st.nextToken());
            sum += score;
            if (max < score) {
                max = score;
            }
        }
        //바꾼 점수 평균 구하기
        //(40/80*100 + 80/80*100 + 60/80*100)/3 -> (40+80+60)/80*100/N 공통부분이 더하기로 이어지는 연산
        bw.write(String.valueOf((double)sum / max * 100 / N));
        bw.flush();
        bw.close();
    }
}
