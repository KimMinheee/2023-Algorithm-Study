import java.io.*;

public class BOJ_11720_숫자의합구하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //숫자 개수
        String numbers = br.readLine(); //공백 없이 주어진 N개의 숫자
        int sum = 0; //숫자의 합
        
        for(int i=0; i<N; i++) {
            int num = numbers.charAt(i)-'0'; //아스키 코드 계산
            sum += num;
        }

        //숫자 합 출력
        bw.write(String.valueOf(sum)); // write(int)메서드는 char타입을 int형으로 받는다. 정수값인 sum을 그대로 문자열로 내보내주어야함
        bw.flush();
        bw.close();

    }
}
