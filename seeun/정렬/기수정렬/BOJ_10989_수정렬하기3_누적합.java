/**
* 각 요소 값과 같은 인덱스에 넣고 누적합 사용해서 구현
**/
import java.io.*;

public class BOJ_10989_수정렬하기3_누적합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int maxNum = 0;
        
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(br.readLine());
            if(maxNum < num[i])
                maxNum = num[i];
        }
        
        int[] buf = new int[maxNum+1];//숫자 개수세기 버퍼

        //num요소들 숫자 세기
        for(int i=0; i<N; i++){
            buf[num[i]]++;
        }

        //누적합 구하기
         for(int i=1; i<=maxNum; i++){
             buf[i] += buf[i-1];
         }

         int[] rslt = new int[N];
         //누적합으로부터 구하는 것이므로 뒤에서부터 시작, 결과 배열
        for(int i=N-1; i>=0; i--){
            rslt[--buf[num[i]]] = num[i];
        }

        for(int i=0; i<N; i++){
            bw.write(rslt[i] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();

    }
}
