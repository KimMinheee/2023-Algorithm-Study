import java.io.*;
import java.util.*;
public class BOJ_2750_수정렬하기 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); //정렬할 요소 수
        int[] numbers = new int[N]; // 정렬할 배열

        //배열 입력받기
        for(int i=0; i<N; i++){
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers); //배열 오름차순 정렬
        //배열 출력
        for(int i=0; i<N; i++){
            bw.write(numbers[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
}