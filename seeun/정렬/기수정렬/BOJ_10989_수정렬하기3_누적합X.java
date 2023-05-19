/**
* 각 요소 값과 같은 인덱스에 넣고 누적합 사용하지 않고 구현
**/
import java.io.*;

public class BOJ_10989_수정렬하기3_누적합X {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int maxNum = 0;

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
            if (maxNum < num[i])
                maxNum = num[i];
        }

        int[] buf = new int[maxNum + 1];//숫자 개수세기 버퍼

        //num요소들 숫자 세기, 값을 인덱스로해서 카운팅
        for (int i = 0; i < N; i++) {
            buf[num[i]]++;
        }

        for(int i=0; i<=maxNum; i++){
            for(;buf[i]>0; buf[i]--){ //인덱스 요소에 더해진 만큼 차례로 다 빼주기
                bw.write(i + "\n"); //인덱스 자체가 요소의 값
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
