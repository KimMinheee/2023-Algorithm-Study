import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_14425 { //[BOJ_14425]문자열찾기 jaehwan solved - hash 사용
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st =new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int count =0;

        Map<String,Integer> map =new HashMap<>();
        for(int i=0; i<N;i++){
            map.put(br.readLine(),0); //키로 문자열 넣고, 벨류 아무거나 
        }
        for(int i=0;i<M;i++){
            if(map.containsKey(br.readLine())) //해당 문자열이 맵의 키에 존재하는지 확인
                count++;
        }
        System.out.println(count);
    }
}

/*
트라이 문제인데 기존에 이런 문제를 해쉬로 배운적이 있어 해쉬로 간단히 풀었다
*/
